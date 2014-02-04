package com.verobapps.myscheduler;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.verobapps.myscheduler.database.ScheduleContract;
import com.verobapps.myscheduler.database.ScheduleDbHelper;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GetScheduleAsyncTask extends AsyncTask<Void, Void, Void> {

    Context mContext;

    ArrayList<ShiftCard> mySchedule = new ArrayList<ShiftCard>();
    ArrayList<ShiftCard> daysOfTheWeek = new ArrayList<ShiftCard>();
    String url;
    Activity mActivity;
    ProgressDialogFragment progressDialog;

    public class ProgressDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            ProgressDialog dialog = new ProgressDialog(getActivity());
            dialog.setMessage(getResources().getString(
                    R.string.copy_schedule_progress_message));
            return dialog;
        }
    }

    public GetScheduleAsyncTask(Activity activity) {
        mActivity = activity;
        mContext = activity.getApplicationContext();
    }

    /**
     * Sets up the dates used by getting the first date of the week and adding
     * the next two weeks to the array
     *
     * @param doc Document object
     */
    private void setUpHeaderText(Document doc, boolean is3Week) {

        String dayTitle = is3Week == false ? "dayTitle2" : "dayTitle1";
        int endOfWeek = is3Week == false ? 14 : 21;


        // Splits string to get first date
        // eg. string: "Current Week - 10/13/2013 to 10/19/2013"
        String[] weekSpan = doc.select("div[id=" + dayTitle + "]").text().split("-")[1]
                .split("to");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        try {
            startDate = dateFormat.parse(weekSpan[0]);

            String[] dayNames = new DateFormatSymbols().getWeekdays();
            String[] monthNames = new DateFormatSymbols().getMonths();

            for (int size = 0; size < endOfWeek; size++) {
                daysOfTheWeek.add(new ShiftCard(mContext));

                Calendar cal = Util.addDays(startDate, size);
                String date = dayNames[cal.get(Calendar.DAY_OF_WEEK)] + ", "
                        + monthNames[cal.get(Calendar.MONTH)] + " "
                        + cal.get(Calendar.DAY_OF_MONTH);

                daysOfTheWeek.get(size).setMyStringDate(date);
                daysOfTheWeek.get(size).setMyDate(cal);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getShifts(Document doc, boolean is3Week) {

        int start = 7;

        String weekDisplay = "weekDisplay";
        String pfShifts;

        // Set up the date header text
        setUpHeaderText(doc, is3Week);

        // Loop twice to cover both weeks
        for (int week = 2; week <= 3; week++) {

            Elements tables = doc
                    .select("table[id=" + weekDisplay + week + "]");
            for (int weekDay = 0; weekDay < daysOfTheWeek.size(); weekDay++) {

                if ((weekDay + start) <= 13) {
                    pfShifts = "presentShifts";
                } else {
                    pfShifts = "futureShifts";
                }

                // Get the html code for the shift
                Elements shiftDays = tables.get(0).select(
                        "td[id=" + pfShifts + (weekDay + start) + "]");

                // Loop to get shifts
                for (int j = 0; j < shiftDays.size(); j++) {

                    // Empty string means theres no shift
                    if (shiftDays.get(j).text().equals("")) {
                        // add the default day
                        mySchedule.add(new ShiftCard(mContext));
                        // set the location
                        mySchedule.get(mySchedule.size() - 1).setMyLocation(
                                "OFF");
                        // set the date
                        mySchedule.get(mySchedule.size() - 1).setMyDate(
                                daysOfTheWeek.get(weekDay).getMyDate());
                        // set the date string
                        mySchedule.get(mySchedule.size() - 1).setMyStringDate(
                                daysOfTheWeek.get(weekDay).getMyStringDate());

                    }
                    // "View Time Details" means shift has passed
                    else if (shiftDays.get(j).text()
                            .contains("View Time Details")) {
                        // add the default day
                        mySchedule.add(new ShiftCard(mContext));
                        mySchedule.get(mySchedule.size() - 1)
                                .setAddToCal(false);

                        mySchedule.get(mySchedule.size() - 1).setMyLocation(
                                "No shift available.");
                        // set the date
                        mySchedule.get(mySchedule.size() - 1).setMyDate(
                                daysOfTheWeek.get(weekDay).getMyDate());
                        // set the date string
                        mySchedule.get(mySchedule.size() - 1).setMyStringDate(
                                daysOfTheWeek.get(weekDay).getMyStringDate());

                    } else {
                        // check to see if there are split shifts
                        String[] splitShifts = shiftDays.get(j).text()
                                .split(" -");

                        // Loop to account for split shifts
                        for (int splitSize = 0; splitSize < splitShifts.length; splitSize++) {
                            // add the default day
                            mySchedule.add(new ShiftCard(mContext));
                            mySchedule.get(mySchedule.size() - 1).setAddToCal(
                                    false);

                            // Shift location
                            String location = splitShifts[splitSize].trim();

                            mySchedule.get(mySchedule.size() - 1)
                                    .setMyLocation(
                                            splitShifts[splitSize].trim());
                            // set the date
                            mySchedule.get(mySchedule.size() - 1).setMyDate(
                                    daysOfTheWeek.get(weekDay).getMyDate());
                            // set the date string
                            mySchedule.get(mySchedule.size() - 1)
                                    .setMyStringDate(
                                            daysOfTheWeek.get(weekDay)
                                                    .getMyStringDate());

                            // Make sure string has shift times
                            if (!location.matches("[A-Za-z0-9]+")
                                    && location.length() > 2) {
                                // make sure this shift is added
                                mySchedule.get(mySchedule.size() - 1)
                                        .setAddToCal(true);

                                String[] text = location.split(" ");
                                String finalLocation = "";
                                int startHour = 0;
                                int startMinutes = 0;
                                int endHour = 0;
                                int endMinutes = 0;

                                for (int textSize = 0; textSize < text.length; textSize++) {

                                    // Get shift times
                                    if (textSize == 0) {
                                        try {
                                            // Parse the times
                                            String[] time = text[0]
                                                    .split("[-:]");
                                            startHour = Integer
                                                    .parseInt(time[0]);
                                            startMinutes = Integer
                                                    .parseInt(time[1]);
                                            endHour = Integer.parseInt(time[2]);
                                            endMinutes = Integer
                                                    .parseInt(time[3]);

                                            // Add shift time to Shift object
                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setStartHour(startHour);

                                            mySchedule
                                                    .get(mySchedule.size() - 1)
                                                    .getMyDate()
                                                    .set(Calendar.HOUR_OF_DAY,
                                                            startHour);

                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setStartMinute(
                                                            startMinutes);

                                            mySchedule
                                                    .get(mySchedule.size() - 1)
                                                    .getMyDate()
                                                    .set(Calendar.MINUTE,
                                                            startMinutes);

                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setEndHour(endHour);
                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setEndMinute(endMinutes);
                                        } catch (NumberFormatException e) {
                                            // Has no shift time, prevent from
                                            // being added to calendar
                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setAddToCal(false);
                                            continue;
                                        }

                                    } else {
                                        // String with shift location and time
                                        finalLocation = finalLocation
                                                + text[textSize] + " ";
                                        mySchedule.get(mySchedule.size() - 1)
                                                .setEventTitle(finalLocation);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        generateUniqueId();
        saveToDB();

    }

    public void get3WeekShifts(Document doc) {

        // Set up header text
        setUpHeaderText(doc, true);

        String weekDisplay = "weekDisplay";
        String pfShifts = "futureShifts";

        // Loop three times to cover three weeks
        for (int week = 1; week <= 3; week++) {

            Elements tables = doc
                    .select("table[id=" + weekDisplay + week + "]");
            for (int weekDay = 0; weekDay < daysOfTheWeek.size(); weekDay++) {


                // Get the html code for the shift
                Elements shiftDays = tables.get(0).select(
                        "td[id=" + pfShifts + weekDay + "]");

                // Loop to get shifts
                for (int j = 0; j < shiftDays.size(); j++) {

                    // Empty string means theres no shift
                    if (shiftDays.get(j).text().equals("")) {
                        // add the default day
                        mySchedule.add(new ShiftCard(mContext));
                        // set the location
                        mySchedule.get(mySchedule.size() - 1).setMyLocation(
                                "OFF");
                        // set the date
                        mySchedule.get(mySchedule.size() - 1).setMyDate(
                                daysOfTheWeek.get(weekDay).getMyDate());
                        // set the date string
                        mySchedule.get(mySchedule.size() - 1).setMyStringDate(
                                daysOfTheWeek.get(weekDay).getMyStringDate());

                    }
                    // "View Time Details" means shift has passed
                    else if (shiftDays.get(j).text()
                            .contains("View Time Details") || shiftDays.get(j).text()
                            .contains("This day is not within the published window.")) {
                        // add the default day
                        mySchedule.add(new ShiftCard(mContext));
                        mySchedule.get(mySchedule.size() - 1)
                                .setAddToCal(false);

                        mySchedule.get(mySchedule.size() - 1).setMyLocation(
                                "No shift available.");
                        // set the date
                        mySchedule.get(mySchedule.size() - 1).setMyDate(
                                daysOfTheWeek.get(weekDay).getMyDate());
                        // set the date string
                        mySchedule.get(mySchedule.size() - 1).setMyStringDate(
                                daysOfTheWeek.get(weekDay).getMyStringDate());

                    } else {
                        // check to see if there are split shifts
                        String[] splitShifts = shiftDays.get(j).text()
                                .split(" -");

                        // Loop to account for split shifts
                        for (int splitSize = 0; splitSize < splitShifts.length; splitSize++) {
                            // add the default day
                            mySchedule.add(new ShiftCard(mContext));
                            mySchedule.get(mySchedule.size() - 1).setAddToCal(
                                    false);

                            // Shift location
                            String location = splitShifts[splitSize].trim();

                            mySchedule.get(mySchedule.size() - 1)
                                    .setMyLocation(
                                            splitShifts[splitSize].trim());
                            // set the date
                            mySchedule.get(mySchedule.size() - 1).setMyDate(
                                    daysOfTheWeek.get(weekDay).getMyDate());
                            // set the date string
                            mySchedule.get(mySchedule.size() - 1)
                                    .setMyStringDate(
                                            daysOfTheWeek.get(weekDay)
                                                    .getMyStringDate());

                            // Make sure string has shift times
                            if (!location.matches("[A-Za-z0-9]+")
                                    && location.length() > 2) {
                                // make sure this shift is added
                                mySchedule.get(mySchedule.size() - 1)
                                        .setAddToCal(true);

                                String[] text = location.split(" ");
                                String finalLocation = "";
                                int startHour = 0;
                                int startMinutes = 0;
                                int endHour = 0;
                                int endMinutes = 0;

                                for (int textSize = 0; textSize < text.length; textSize++) {

                                    // Get shift times
                                    if (textSize == 0) {
                                        try {
                                            // Parse the times
                                            String[] time = text[0]
                                                    .split("[-:]");
                                            startHour = Integer
                                                    .parseInt(time[0]);
                                            startMinutes = Integer
                                                    .parseInt(time[1]);
                                            endHour = Integer.parseInt(time[2]);
                                            endMinutes = Integer
                                                    .parseInt(time[3]);

                                            // Add shift time to Shift object
                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setStartHour(startHour);

                                            mySchedule
                                                    .get(mySchedule.size() - 1)
                                                    .getMyDate()
                                                    .set(Calendar.HOUR_OF_DAY,
                                                            startHour);

                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setStartMinute(
                                                            startMinutes);

                                            mySchedule
                                                    .get(mySchedule.size() - 1)
                                                    .getMyDate()
                                                    .set(Calendar.MINUTE,
                                                            startMinutes);

                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setEndHour(endHour);
                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setEndMinute(endMinutes);
                                        } catch (NumberFormatException e) {
                                            // Has no shift time, prevent from
                                            // being added to calendar
                                            mySchedule.get(
                                                    mySchedule.size() - 1)
                                                    .setAddToCal(false);
                                            continue;
                                        }

                                    } else {
                                        // String with shift location and time
                                        finalLocation = finalLocation
                                                + text[textSize] + " ";
                                        mySchedule.get(mySchedule.size() - 1)
                                                .setEventTitle(finalLocation);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        generateUniqueId();
        saveToDB();

    }

    /**
     * Generate a unique id so shift can be identifiable in database
     */
    void generateUniqueId() {
        for (int i = 0; i < mySchedule.size(); i++) {
            String id = mySchedule.get(i).getMyLocation()
                    + mySchedule.get(i).getMyStringDate();

            mySchedule.get(i).setUniqueId(id);
        }
    }

    /**
     * Saves the shifts to the internal database
     */
    void saveToDB() {
        if (!mySchedule.isEmpty()) {
            ScheduleDbHelper mDbHelper = new ScheduleDbHelper(mContext);
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            // Only add future shifts
            for (int i = 0; i < mySchedule.size(); i++) {
                // Create a new map of values, where column names are the keys


                if (Calendar.getInstance()
                        .before(mySchedule.get(i).getMyDate()) && !mySchedule.get(i).getMyLocation().contains("No " +
                        "shift available.")) {

                    ContentValues values = new ContentValues();
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_SHIFT_CALENDAR_ID,
                            "");
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE,
                            mySchedule.get(i).getEventTitle());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_LOCATION,
                            mySchedule.get(i).getMyLocation());
                    values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_TIME,
                            mySchedule.get(i).getMyTime());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_STRING_DATE,
                            mySchedule.get(i).getMyStringDate());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR,
                            mySchedule.get(i).getStartHour());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE,
                            mySchedule.get(i).getStartMinute());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR,
                            mySchedule.get(i).getEndHour());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE,
                            mySchedule.get(i).getEndMinute());
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID,
                            mySchedule.get(i).getUniqueId());
                    int addToCal = mySchedule.get(i).isAddToCal() ? 1 : 0;
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR,
                            addToCal);
                    values.put(
                            ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS,
                            mySchedule.get(i).getMyDate().getTimeInMillis());

                    db.insertWithOnConflict(
                            ScheduleContract.ScheduleEntry.TABLE_NAME, null,
                            values, SQLiteDatabase.CONFLICT_IGNORE);

                }
            }
            db.close();
        }
    }

    @Override
    protected void onPostExecute(Void doc) {
        progressDialog.dismissAllowingStateLoss();

        if (!tryAgain) {
            this.mActivity.finish();

        } else {
            if (timeOut) {
                Crouton.makeText(mActivity, R.string.crouton_copy_timeout_message,
                        Style.ALERT, Configuration.DURATION_LONG).show();
            } else {
                Crouton.makeText(mActivity, R.string.crouton_copy_failed_message,
                        Style.ALERT, Configuration.DURATION_LONG).show();
            }
        }


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        tryAgain = true;
        timeOut = false;

        progressDialog = new ProgressDialogFragment();
        progressDialog.show(mActivity.getFragmentManager(), "dialog");
        progressDialog.setCancelable(false);

    }

    boolean tryAgain;
    boolean timeOut;

    @Override
    protected Void doInBackground(Void... params) {
        // Get document object from html code
        Document doc = Jsoup.parse(MyWebViewActivity.SCHEDULE_HTML);

        // Used for testing with dummy schedule
        // Document testDoc = Jsoup.parse(MyWebViewActivity.SCHEDULE_HTML);

        // Parse the HTML
        if (doc != null) {

            // Make sure schedule exists in html code
            Elements tables = doc.select("table[id=weekDisplay2]");
            if (!tables.isEmpty()) {
                Elements futureShiftsTable = doc.select("td[id=presentShifts7]");
                if (!futureShiftsTable.isEmpty()) {
                    Log.i(Util.DEBUG_MYSCHEDULER, "TWO weeks TEST");
                    getShifts(doc, false);
                    tryAgain = false;
                } else {
                    Log.i(Util.DEBUG_MYSCHEDULER, "Three weeks TEST");
                    get3WeekShifts(doc);
                    tryAgain = false;
                }
            }
        }

        return null;

    }
}
