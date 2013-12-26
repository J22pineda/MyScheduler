package com.verobapps.myscheduler;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.devspark.progressfragment.ProgressFragment;

public class AccountPickerDialogFragment extends ProgressFragment {

	Context context;
	private View mContentView;
	ListView listView;
	MyCalendarAccountsAdapter myAdapter;
	ArrayList<Calendar> calendars = new ArrayList<AccountPickerDialogFragment.Calendar>();

	public static AccountPickerDialogFragment newInstance() {
		AccountPickerDialogFragment fragment = new AccountPickerDialogFragment();
		return fragment;
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
		mContentView = inflater.inflate(R.layout.account_picker_layout, null);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setContentView(mContentView);
		setEmptyText(R.string.empty_account_list);

		listView = (ListView) getActivity().findViewById(R.id.account_listview);

		// Save selected item to shared preferences
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				SharedPreferences pref = PreferenceManager
						.getDefaultSharedPreferences(context
								.getApplicationContext());
				pref.edit()
						.putInt("calendar_account",
								calendars.get(position).getId()).commit();
				pref.edit()
						.putString("calendar_account_name",
								calendars.get(position).getName()).commit();

				getActivity().finish();

			}
		});

	}

	@Override
	public void onResume() {
		super.onResume();

		setContentView(mContentView);
		setEmptyText(R.string.empty_account_list);
		obtainData();
	}

	void obtainData() {
		new GetCalendarAccounts(getActivity()).execute();
	}

	private class Calendar {
		String name;
		int id;

		public Calendar(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public int getId() {
			return id;
		}
	}

	class MyCalendarAccountsAdapter extends BaseAdapter {

		private Context context;

		public MyCalendarAccountsAdapter(Context context) {
			super();
			this.context = context;
		}

		@Override
		public int getCount() {
			return calendars.size();
		}

		@Override
		public Object getItem(int position) {
			return calendars.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater mInflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = mInflater.inflate(
						R.layout.account_picker_item_layout, null);

			}

			TextView text = (TextView) convertView
					.findViewById(R.id.account_textview);
			text.setText(calendars.get(position).getName());

			return convertView;
		}

	}

	class GetCalendarAccounts extends AsyncTask<Void, Void, Void> {

		public final String[] FIELDS = {
				CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
				CalendarContract.Calendars._ID };

		public final Uri CALENDAR_URI = Uri
				.parse("content://com.android.calendar/calendars");

		ContentResolver contentResolver;

		public GetCalendarAccounts(Context ctx) {
			contentResolver = ctx.getContentResolver();
		}

		@Override
		protected Void doInBackground(Void... params) {

			// Fetch a list of all calendars sync'd with the device and their
			// display names
			Cursor cursor = contentResolver.query(
					CalendarContract.Calendars.CONTENT_URI, FIELDS, null, null,
					null);

			try {
				if (cursor.getCount() > 0) {
					while (cursor.moveToNext()) {
						int id = cursor
								.getInt(cursor
										.getColumnIndex(CalendarContract.Calendars._ID));
						String displayName = cursor
								.getString(cursor
										.getColumnIndex(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME));
						calendars.add(new Calendar(displayName, id));
					}
				}
			} catch (AssertionError ex) {
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			setContentShown(true);

			if (!calendars.isEmpty()) {
				myAdapter = new MyCalendarAccountsAdapter(context);

				if (listView != null) {
					listView.setAdapter(myAdapter);
				} else {
					setContentEmpty(false);
				}

			} else {
				setContentEmpty(true);
			}
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			calendars.clear();
			if (myAdapter != null) {
				myAdapter.notifyDataSetChanged();
			}
		}

	}

}
