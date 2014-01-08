package com.verobapps.myscheduler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devspark.progressfragment.ProgressFragment;
import com.verobapps.myscheduler.database.ScheduleContract;
import com.verobapps.myscheduler.database.ScheduleDbHelper;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;


public class MyScheduleFragment extends ProgressFragment {

    private View mContentView;
    Context context;
    ArrayList<ShiftCard> cardList = new ArrayList<ShiftCard>();
    MyCardArrayAdapter myCardAdapter;
    ListView listView;
    int color = 0;

    public static MyScheduleFragment newInstance() {
        MyScheduleFragment fragment = new MyScheduleFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Setup content view
        setContentView(mContentView);
        // Setup text for empty content
        setEmptyText(R.string.empty_list);

        obtainData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        context = getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.main_schedule_activity, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Setup content view
        setContentView(mContentView);
        // Setup text for empty content
        setEmptyText(R.string.empty_list);

        listView = (ListView) getActivity().findViewById(R.id.myList);
    }

    class ViewHolder {
        RelativeLayout headerLayout;
        TextView headerText;

        ImageView border;
        TextView bodyText;
        TextView shiftLength;
    }

    class MyCardArrayAdapter extends BaseAdapter {

        private ArrayList<ShiftCard> list;
        private Context context;

        public MyCardArrayAdapter(Context context, ArrayList<ShiftCard> list) {
            super();
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return cardList.size();
        }

        @Override
        public ShiftCard getItem(int position) {
            return cardList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return cardList.get(position).getDateMillis();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                // Inflate new view
                holder = new ViewHolder();
                LayoutInflater mInflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.card_shift_layout,
                        null);
                holder.headerLayout = (RelativeLayout) convertView
                        .findViewById(R.id.header_relative_layout);
                holder.headerText = (TextView) convertView
                        .findViewById(R.id.header_title);
                holder.bodyText = (TextView) convertView
                        .findViewById(R.id.card_main_inner_simple_title);
                holder.border = (ImageView) convertView
                        .findViewById(R.id.colorBorder);
                holder.shiftLength = (TextView) convertView
                        .findViewById(R.id.shift_length);
                convertView.setTag(holder);
            } else {
                // Reuse view
                holder = (ViewHolder) convertView.getTag();
            }

            // Set color strip color
            if (color == 0) {
                holder.border.setImageDrawable(getResources().getDrawable(
                        R.drawable.color_strip_bg));
            } else {
                holder.border.setImageDrawable(new ColorDrawable(color));
            }

            // Format string to be displayed
            String[] string = list.get(position).getMyLocation().split(" ");
            String time = string[0];
            String location = "";
            for (int i = 1; i < string.length; i++) {
                location = location + string[i] + " ";
            }
            holder.headerText.setText(list.get(position).getMyStringDate());
            holder.bodyText.setText(time + "\n" + location);

            // Remove date header if day has more than one shift
            if (position > 0) {
                if (list.get(position)
                        .getMyStringDate()
                        .equalsIgnoreCase(
                                list.get(position - 1).getMyStringDate())) {
                    holder.headerLayout.setVisibility(View.GONE);
                } else {
                    holder.headerLayout.setVisibility(View.VISIBLE);
                }
            } else {
                holder.headerLayout.setVisibility(View.VISIBLE);
            }

            // Make date header display "Today" or "Tomorrow"
            Calendar rightNow = Calendar.getInstance();
            Calendar future = Calendar.getInstance();
            future.setTimeInMillis(list.get(position).getDateMillis());

            if (rightNow.get(Calendar.DAY_OF_YEAR) == future
                    .get(Calendar.DAY_OF_YEAR)) {

                holder.headerText.setText(getResources().getString(
                        R.string.card_header_title_today));

            } else {
                rightNow.add(Calendar.HOUR_OF_DAY, 24);
                if (rightNow.get(Calendar.DAY_OF_YEAR) == future
                        .get(Calendar.DAY_OF_YEAR)) {

                    holder.headerText.setText(getResources().getString(
                            R.string.card_header_title_tomorrow));

                } else {

                    holder.headerText.setText(list.get(position)
                            .getMyStringDate());
                }
            }

            // Hide shift length view if it equals to 0.0
            if (list.get(position).getShiftLength().equalsIgnoreCase("0.0")) {
                holder.shiftLength.setVisibility(View.GONE);
            } else {
                holder.shiftLength.setVisibility(View.VISIBLE);
                holder.shiftLength.setText(String.format(getResources()
                        .getString(R.string.shift_item_hrs_string),
                        list.get(position).getShiftLength()));
            }
            return convertView;
        }
    }

    // Convenience method to retrieve database content
    void obtainData() {
        new GetDbSchedule(context, this).execute();
    }

    class GetDbSchedule extends AsyncTask<Void, Void, Void> {

        Context context;
        ScheduleDbHelper mDbHelper;
        int movePosition = 0;
        MyScheduleFragment mf;

        public GetDbSchedule(Context context, MyScheduleFragment mf) {
            this.context = context;
            this.mf = mf;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            setContentShown(true);

            if (!cardList.isEmpty()) {

                myCardAdapter = new MyCardArrayAdapter(getActivity()
                        .getBaseContext(), cardList);

                if (listView != null) {

                    // Set up Contextual Action Bar (CAB)
                    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
                    listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

                        double totalHrs = 0.0;

                        @Override
                        public boolean onPrepareActionMode(ActionMode mode,
                                                           Menu menu) {
                            return false;
                        }

                        @Override
                        public void onDestroyActionMode(ActionMode mode) {
                            totalHrs = 0.0;
                        }

                        @Override
                        public boolean onCreateActionMode(ActionMode mode,
                                                          Menu menu) {
                            MenuInflater inflater = mode.getMenuInflater();
                            inflater.inflate(R.menu.context_action_menu, menu);
                            return true;
                        }

                        @Override
                        public boolean onActionItemClicked(ActionMode mode,
                                                           MenuItem item) {
                            switch (item.getItemId()) {
                                // Handle action bar icon actions
                                case R.id.action_cab_share:
                                    new ShareSelectedShifts(getActivity(), mode).execute();
                                    return true;
                                case R.id.action_delete:
                                    new DeleteSelectedShifts(getActivity(), mode)
                                            .execute();
                                    return true;
                                case R.id.action_cab_save:
                                    new SaveSelectedShifts(getActivity(), mode)
                                            .execute();
                                    return true;
                                default:
                                    return false;
                            }
                        }

                        @Override
                        public void onItemCheckedStateChanged(ActionMode mode,
                                                              int position, long id, boolean checked) {

                            final int checkedCount = listView
                                    .getCheckedItemCount();

                            // Add up shift lengths
                            if (checked) {
                                totalHrs = totalHrs
                                        + Double.parseDouble(myCardAdapter
                                        .getItem(position)
                                        .getShiftLength());
                            } else {
                                totalHrs = totalHrs
                                        - Double.parseDouble(myCardAdapter
                                        .getItem(position)
                                        .getShiftLength());
                            }

                            // Update CAB title and subtitle
                            switch (checkedCount) {
                                case 0:
                                    mode.setTitle(null);
                                    mode.setSubtitle(null);
                                    totalHrs = 0.0;
                                    break;
                                case 1:
                                    mode.setTitle(getResources().getString(
                                            R.string.cab_select_message));
                                    mode.setSubtitle(String
                                            .format(getResources().getString(
                                                    R.string.cab_total_hrs_message),
                                                    totalHrs));
                                    break;
                                default:
                                    mode.setTitle(String.format(
                                            getResources().getString(
                                                    R.string.cab_selected_message),
                                            checkedCount));
                                    mode.setSubtitle(String
                                            .format(getResources().getString(
                                                    R.string.cab_total_hrs_message),
                                                    totalHrs));
                                    break;
                            }

                        }
                    });

                    listView.setAdapter(myCardAdapter);
                    listView.post(new Runnable() {
                        @Override
                        public void run() {
                            listView.setSelection(movePosition);
                        }
                    });

                }
                setContentEmpty(false);
                MainScheduleActivity.SCHEDULE_EXISTS = true;
            } else {
                setContentEmpty(true);
                MainScheduleActivity.SCHEDULE_EXISTS = false;
            }
            getActivity().invalidateOptionsMenu();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDbHelper = new ScheduleDbHelper(context);

            // Show indeterminate progress
            setContentShown(false);
            cardList.clear();
            if (myCardAdapter != null) {
                myCardAdapter.notifyDataSetChanged();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {

            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            String[] projection = {ScheduleContract.ScheduleEntry._ID,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_LOCATION,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_TIME,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_STRING_DATE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS};

            // Sort data based on date millis
            String sortOrder = ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS
                    + " ASC";

            String whereClause;

            SharedPreferences sp = PreferenceManager
                    .getDefaultSharedPreferences(context);
            boolean hideShifts = sp.getBoolean("hide_old_shifts", false);

            color = sp.getInt("default_color", 0);

            if (hideShifts) {
                whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS
                        + " > " + Calendar.getInstance().getTimeInMillis();
            } else {
                whereClause = null;
            }

            Cursor c = db.query(ScheduleContract.ScheduleEntry.TABLE_NAME,
                    projection, // The columns to return
                    whereClause, // The columns for the WHERE clause
                    null, // The values for the WHERE clause
                    null, // don't group the rows
                    null, // don't filter by row groups
                    sortOrder // The sort order
            );

            c.moveToFirst();

            String uniqueId;
            String myLocation;
            String myTime;
            String myStringDate;
            Calendar today = Calendar.getInstance();

            int startHour;
            int startMinute;
            int endHour;
            int endMinute;

            String eventTitle;

            int addToCal = 0;
            long dateMillis = 0;

            boolean positionFound = false;

            // If cursor is not empty
            if (c.getCount() > 0) {
                do {

                    uniqueId = c
                            .getString(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_LOCATION));

                    myLocation = c
                            .getString(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_LOCATION));
                    myTime = c
                            .getString(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_TIME));
                    myStringDate = c
                            .getString(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_STRING_DATE));
                    startHour = c
                            .getInt(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR));
                    startMinute = c
                            .getInt(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE));
                    endHour = c
                            .getInt(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR));
                    endMinute = c
                            .getInt(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE));
                    eventTitle = c
                            .getString(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE));
                    addToCal = c
                            .getInt(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR));

                    dateMillis = c
                            .getLong(c
                                    .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS));

                    if (!positionFound && today.getTimeInMillis() < dateMillis) {
                        movePosition = c.getPosition();
                        positionFound = true;
                    }

                    // Set up shift Card object
                    ShiftCard card = new ShiftCard(context);

                    // Set up behind the scenes card info
                    card.setMyLocation(myLocation);
                    card.setMyTime(myTime);
                    card.setMyStringDate(myStringDate);
                    card.setStartHour(startHour);
                    card.setStartMinute(startMinute);
                    card.setEndHour(endHour);
                    card.setEndMinute(endMinute);
                    card.setEventTitle(eventTitle);
                    card.setDateMillis(dateMillis);
                    card.setUniqueId(uniqueId);

                    card.setShiftLength(calculateShiftLength(startHour,
                            startMinute, endHour, endMinute, dateMillis));

                    if (addToCal == 1) {
                        card.setAddToCal(true);
                    } else {
                        card.setAddToCal(false);
                    }

                    cardList.add(card);

                } while (c.moveToNext());
            }

            db.close();

            return null;
        }
    }

    /**
     * @param startHour   Start hour of shift
     * @param startMinute Start minute of shift
     * @param endHour     End hour of shift
     * @param endMinute   End minute of shift
     * @param dateMillis  Shift date value in millis
     * @return String representation of shift length
     */
    private String calculateShiftLength(int startHour, int startMinute,
                                        int endHour, int endMinute, long dateMillis) {

        Calendar startDate = Calendar.getInstance();
        startDate.setTimeInMillis(dateMillis);

        startDate.set(Calendar.HOUR_OF_DAY, startHour);
        startDate.set(Calendar.MINUTE, startMinute);

        Calendar endDate = Calendar.getInstance();
        endDate.setTimeInMillis(dateMillis);

        // If shift goes past midnight
        if (endHour < startHour) {
            // make it the next day
            endDate.add(Calendar.HOUR_OF_DAY, 24);
        }

        // set end time to calendar instance
        endDate.set(Calendar.HOUR_OF_DAY, endHour);
        endDate.set(Calendar.MINUTE, endMinute);

        long difMillis = endDate.getTimeInMillis()
                - startDate.getTimeInMillis();

        int days = (int) (difMillis / (1000 * 60 * 60 * 24));
        int hours = (int) ((difMillis - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
        int min = (int) (difMillis - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours))
                / (1000 * 60);

        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        boolean lunchWaiver = sp.getBoolean("has_lunch_waiver", false);

        // Modify shift length if user has lunch waiver
        if (lunchWaiver) {
            if (hours + min > 6) {
                difMillis = difMillis - 1800000;
            }
        } else {
            if (hours == 5) {
                if (min > 30) {
                    difMillis = difMillis - 1800000;
                }
            } else if (hours + min > 6) {
                difMillis = difMillis - 1800000;
            }
        }

        days = (int) (difMillis / (1000 * 60 * 60 * 24));
        hours = (int) ((difMillis - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
        min = (int) (difMillis - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours))
                / (1000 * 60);

        String shiftLength = String.valueOf(hours + (double) min / 60.0);

        return shiftLength;
    }

    class DeleteSelectedShifts extends AsyncTask<Void, Void, Void> {

        Context mContext;
        Activity mActivity;
        ProgressDialogFragment progressDialog;
        ScheduleDbHelper mDbHelper;
        ActionMode mode;
        ArrayList<Long> removeList = new ArrayList<Long>();

        public DeleteSelectedShifts(Activity activity, ActionMode mode) {
            mActivity = activity;
            mContext = activity.getApplicationContext();
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Void... params) {
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            String[] scheduleProjection = {ScheduleContract.ScheduleEntry._ID,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR,
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS};

            SparseBooleanArray checkedItems = listView
                    .getCheckedItemPositions();

            // Delete selected shifts
            if (checkedItems != null) {
                for (int i = 0; i < checkedItems.size(); i++) {
                    if (checkedItems.valueAt(i)) {

                        int position = checkedItems.keyAt(i);

                        String whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS
                                + " = "
                                + listView.getAdapter().getItemId(position);

                        Cursor c = db.query(
                                ScheduleContract.ScheduleEntry.TABLE_NAME,
                                scheduleProjection, whereClause, null, null,
                                null, null);

                        c.moveToFirst();

                        if (c.getCount() > 0) {

                            String eventTitle = c
                                    .getString(c
                                            .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE));
                            int startHour = c
                                    .getInt(c
                                            .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR));
                            int startMinute = c
                                    .getInt(c
                                            .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE));
                            int endHour = c
                                    .getInt(c
                                            .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR));
                            int endMinute = c
                                    .getInt(c
                                            .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE));
                            long dateMillis = c
                                    .getLong(c
                                            .getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS));

                            long startMillis = 0;
                            long endMillis = 0;

                            Calendar ca = Calendar.getInstance();
                            ca.setTimeInMillis(dateMillis);

                            ca.set(Calendar.HOUR_OF_DAY, startHour);
                            ca.set(Calendar.MINUTE, startMinute);

                            // start time
                            startMillis = ca.getTimeInMillis();

                            ca = Calendar.getInstance();
                            ca.setTimeInMillis(dateMillis);

                            if (endHour < startHour) {
                                // make it the next day
                                ca.add(Calendar.HOUR_OF_DAY, 24);
                            }

                            // set end time to calendar instance
                            ca.set(Calendar.HOUR_OF_DAY, endHour);
                            ca.set(Calendar.MINUTE, endMinute);

                            // end time
                            endMillis = ca.getTimeInMillis();

                            if (eventTitle != null)
                                deleteShiftEvent(startMillis, endMillis,
                                        eventTitle);
                        }

                        removeList.add(listView.getAdapter()
                                .getItemId(position));
                    }
                }
            }

            db.close();

            deleteFromDb();

            return null;
        }

        /**
         * Delete selected values from internal database
         */
        void deleteFromDb() {
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            for (int i = 0; i < removeList.size(); i++) {
                String whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS
                        + " = " + removeList.get(i);

                db.delete(ScheduleContract.ScheduleEntry.TABLE_NAME,
                        whereClause, null);

            }
            db.close();
        }

        /**
         * Delete shift event from calendar
         *
         * @param startMillis Start time value in millis
         * @param endMillis   End time value in millis
         * @param eventTitle  Shift title
         */
        void deleteShiftEvent(long startMillis, long endMillis,
                              String eventTitle) {

            String[] scheduleProjection = {CalendarContract.Events._ID};

            String whereClause = CalendarContract.Events.DTSTART + " = '"
                    + startMillis + "' AND " + CalendarContract.Events.DTEND
                    + " = '" + endMillis + "' AND "
                    + CalendarContract.Events.TITLE + " = "
                    + DatabaseUtils.sqlEscapeString(eventTitle);

            Cursor cursor = mContext.getContentResolver().query(
                    Uri.parse("content://com.android.calendar/events"),
                    scheduleProjection, whereClause, null, null);

            cursor.moveToFirst();

            if (cursor.getCount() > 0) {
                long id = cursor.getLong(cursor
                        .getColumnIndex(CalendarContract.Events._ID));

                Uri eventUri = ContentUris.withAppendedId(
                        CalendarContract.Events.CONTENT_URI, id);
                mContext.getContentResolver().delete(eventUri, null, null);

            }
            cursor.close();
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mode.finish();
            progressDialog.dismissAllowingStateLoss();

            // Inform user that shifts were deleted
            if (removeList.size() == 1) {
                Crouton.makeText(
                        mActivity,
                        String.format(
                                getResources().getString(
                                        R.string.crouton_remove_shift_message),
                                removeList.size()), Style.INFO,
                        Configuration.DURATION_LONG).show();
            } else {
                Crouton.makeText(
                        mActivity,
                        String.format(
                                getResources().getString(
                                        R.string.crouton_remove_shifts_message),
                                removeList.size()), Style.INFO,
                        Configuration.DURATION_LONG).show();
            }

            myCardAdapter.notifyDataSetChanged();
            // Refresh data
            obtainData();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialogFragment();
            progressDialog.show(mActivity.getFragmentManager(), "dialog");
            progressDialog.setCancelable(false);

            mDbHelper = new ScheduleDbHelper(mContext);
        }

        public class ProgressDialogFragment extends DialogFragment {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setMessage(getResources().getString(
                        R.string.deleting_cache_dialog_message));
                return dialog;
            }
        }
    }

    class SaveSelectedShifts extends AsyncTask<Void, Void, Void> {

        Context mContext;
        Activity mActivity;
        ProgressDialogFragment progressDialog;
        ScheduleDbHelper mDbHelper;
        ActionMode mode;
        int shiftCount = 0;

        public SaveSelectedShifts(Activity activity, ActionMode mode) {
            mActivity = activity;
            mContext = activity.getApplicationContext();
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Void... params) {
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            SparseBooleanArray checkedItems = listView
                    .getCheckedItemPositions();

            // Save selected shifts
            if (checkedItems != null) {
                for (int i = 0; i < checkedItems.size(); i++) {
                    if (checkedItems.valueAt(i)) {
                        int position = checkedItems.keyAt(i);

                        if (myCardAdapter.getItem(position).isAddToCal()) {

                            long startMillis = 0;
                            long endMillis = 0;

                            long dateMillis = myCardAdapter.getItem(position)
                                    .getDateMillis();
                            int startHour = myCardAdapter.getItem(position)
                                    .getStartHour();
                            int startMinute = myCardAdapter.getItem(position)
                                    .getStartMinute();
                            int endHour = myCardAdapter.getItem(position)
                                    .getEndHour();
                            int endMinute = myCardAdapter.getItem(position)
                                    .getEndMinute();

                            String eventTitle = myCardAdapter.getItem(position)
                                    .getEventTitle();
                            String uniqueId = myCardAdapter.getItem(position)
                                    .getUniqueId();

                            Calendar ca = Calendar.getInstance();
                            ca.setTimeInMillis(dateMillis);

                            ca.set(Calendar.HOUR_OF_DAY, startHour);
                            ca.set(Calendar.MINUTE, startMinute);

                            // start time
                            startMillis = ca.getTimeInMillis();

                            ca = Calendar.getInstance();
                            ca.setTimeInMillis(dateMillis);

                            if (endHour < startHour) {
                                // make it the next day
                                ca.add(Calendar.HOUR_OF_DAY, 24);
                            }

                            // set end time to calendar instance
                            ca.set(Calendar.HOUR_OF_DAY, endHour);
                            ca.set(Calendar.MINUTE, endMinute);

                            // end time
                            endMillis = ca.getTimeInMillis();

                            if (!existsInCalendar(startMillis, endMillis,
                                    eventTitle)) {
                                // if not, then add it to calendar
                                long id = addToCalendar(startMillis, endMillis,
                                        eventTitle);
                                updateRow(db, uniqueId, id);
                            }

                            shiftCount++;
                        }
                    }
                }
            }

            db.close();

            return null;

        }

        /**
         * Updates the row with the unique calendar event id returned from the
         * calendar
         *
         * @param db       Open database object
         * @param uniqueId Shift uniqueId String
         * @param id       Calendar event id
         */
        void updateRow(SQLiteDatabase db, String uniqueId, long id) {
            ContentValues cv = new ContentValues();
            cv.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_SHIFT_CALENDAR_ID,
                    id);

            String whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID
                    + " = " + DatabaseUtils.sqlEscapeString(uniqueId);

            db.update(ScheduleContract.ScheduleEntry.TABLE_NAME, cv,
                    whereClause, null);
        }

        /**
         * Checks if shift exists in Calendar database
         *
         * @param startMillis Shift start time in millis
         * @param endMillis   Shift end time in millis
         * @param eventTitle  Shift title
         * @return If shift exists in calendar
         */
        boolean existsInCalendar(long startMillis, long endMillis,
                                 String eventTitle) {

            String whereClause = CalendarContract.Events.DTSTART + " = '"
                    + startMillis + "' AND " + CalendarContract.Events.DTEND
                    + " = '" + endMillis + "' AND "
                    + CalendarContract.Events.TITLE + " = "
                    + DatabaseUtils.sqlEscapeString(eventTitle);

            Cursor cursor = mContext.getContentResolver().query(
                    Uri.parse("content://com.android.calendar/events"), null,
                    whereClause, null, null);

            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            }

            cursor.close();
            return false;
        }

        /**
         * Adds shift to device calendar
         *
         * @param startMillis Shift start time in millis
         * @param endMillis   Shift end time in millis
         * @param eventTitle  Shift title
         * @return Calendar event id
         */
        long addToCalendar(long startMillis, long endMillis, String eventTitle) {
            SharedPreferences sp = PreferenceManager
                    .getDefaultSharedPreferences(mContext);

            int calID = sp.getInt("calendar_account", 1);

            ContentResolver cr = mContext.getContentResolver();
            ContentValues values = new ContentValues();
            values.put(CalendarContract.Events.DTSTART, startMillis);
            values.put(CalendarContract.Events.DTEND, endMillis);
            values.put(CalendarContract.Events.TITLE, eventTitle);
            values.put(CalendarContract.Events.CALENDAR_ID, calID);

            int color = sp.getInt("default_color", 0);
            if (color != 0) {
                values.put(CalendarContract.Events.EVENT_COLOR, color);
            }

            int reminderValue = Integer.parseInt(sp.getString("event_reminder",
                    "-1"));

            if (reminderValue >= 0) {
                values.put(CalendarContract.Events.HAS_ALARM, 1);
            } else {
                values.put(CalendarContract.Events.HAS_ALARM, 0);
            }

            TimeZone timeZone = TimeZone.getDefault();
            values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());

            Uri uri2 = cr.insert(CalendarContract.Events.CONTENT_URI, values);

            // Get the event ID that is the last element in the Uri
            long eventID = Long.parseLong(uri2.getLastPathSegment());

            if (reminderValue >= 0) {
                // Add reminder to Calendar event
                values = new ContentValues();
                values.put("event_id", eventID);
                values.put("method", 1);
                values.put("minutes", reminderValue);
                cr.insert(CalendarContract.Reminders.CONTENT_URI, values);
            }

            return eventID;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            mode.finish();
            progressDialog.dismissAllowingStateLoss();

            // Notify user shifts were saved
            if (shiftCount == 1) {
                Crouton.makeText(
                        mActivity,
                        String.format(
                                getResources().getString(
                                        R.string.crouton_save_shift_message),
                                shiftCount), Style.INFO,
                        Configuration.DURATION_LONG).show();
            } else {
                Crouton.makeText(
                        mActivity,
                        String.format(
                                getResources().getString(
                                        R.string.crouton_save_shifts_message),
                                shiftCount), Style.INFO,
                        Configuration.DURATION_LONG).show();
            }

            myCardAdapter.notifyDataSetChanged();
            // Refresh data
            obtainData();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialogFragment();
            progressDialog.show(mActivity.getFragmentManager(), "dialog");
            progressDialog.setCancelable(false);

            mDbHelper = new ScheduleDbHelper(mContext);

        }

        public class ProgressDialogFragment extends DialogFragment {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setMessage(getResources().getString(
                        R.string.saving_selected_shifts_dialog_message));
                return dialog;
            }
        }
    }

    class ShareSelectedShifts extends AsyncTask<Void, Void, Void> {

        Context mContext;
        Activity mActivity;
        ProgressDialogFragment progressDialog;
        ActionMode mode;
        ArrayList<Long> removeList = new ArrayList<Long>();
        String shifts = "";

        public ShareSelectedShifts(Activity activity, ActionMode mode) {
            mActivity = activity;
            mContext = activity.getApplicationContext();
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Void... params) {
            SparseBooleanArray checkedItems = listView
                    .getCheckedItemPositions();

            // Get selected shifts to share
            if (checkedItems != null) {
                for (int i = 0; i < checkedItems.size(); i++) {
                    if (checkedItems.valueAt(i)) {

                        int position = checkedItems.keyAt(i);

                        String date = myCardAdapter.getItem(position).getMyStringDate();
                        String totalHours = String.format(getResources()
                                .getString(R.string.shift_item_hrs_string),
                                myCardAdapter.getItem(position).getShiftLength());


                        if (i == checkedItems.size() - 1) {
                            shifts = shifts + date + "\n" + myCardAdapter.getItem(position).getMyLocation() + "\n" +
                                    totalHours + "\n\n" + getResources().getString(R.string.shared_via_myscheduler);
                        } else {
                            shifts = shifts + date + "\n" + myCardAdapter.getItem(position).getMyLocation() + "\n" + totalHours +
                                    "\n\n";
                        }

                    }
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            mode.finish();
            progressDialog.dismissAllowingStateLoss();

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shifts);
            startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string
                    .share_shifts_dialog_message)));

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialogFragment();
            progressDialog.show(mActivity.getFragmentManager(), "dialog");
            progressDialog.setCancelable(false);

        }

        public class ProgressDialogFragment extends DialogFragment {
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                ProgressDialog dialog = new ProgressDialog(getActivity());
                dialog.setMessage(getResources().getString(
                        R.string.share_shifts_progress_dialog_message));
                return dialog;
            }
        }
    }
}
