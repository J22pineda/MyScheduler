package com.verobapps.myscheduler;

import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;

import com.verobapps.myscheduler.database.ScheduleContract;
import com.verobapps.myscheduler.database.ScheduleDbHelper;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class SaveScheduleAsyncTask extends AsyncTask<Void, Void, Void> {

	Context mContext;
	Activity mActivity;
	ProgressDialogFragment progressDialog;
	ScheduleDbHelper mDbHelper;

	public SaveScheduleAsyncTask(Activity activity) {
		mActivity = activity;
		mContext = activity.getApplicationContext();
	}

	@Override
	protected Void doInBackground(Void... params) {
		SQLiteDatabase db = mDbHelper.getWritableDatabase();

		String[] scheduleProjection = { ScheduleContract.ScheduleEntry._ID,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS,
				ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID };

		String whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR
				+ "=1";

		Cursor c = db.query(ScheduleContract.ScheduleEntry.TABLE_NAME,
				scheduleProjection, whereClause, null, null, null, null);

		c.moveToFirst();

		if (c.getCount() > 0) {
			do {

				String uniqueId = c
						.getString(c
								.getColumnIndex(ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID));
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

				// check to see if shift exists in calendar
				if (!existsInCalendar(startMillis, endMillis, eventTitle)) {
					// if not, then add it to calendar
					long id = addToCalendar(startMillis, endMillis, eventTitle);
					updateRow(db, uniqueId, id);
				}
			} while (c.moveToNext());
		}

		db.close();

		return null;

	}

	/**
	 * Updates the row with the unique calendar event id returned from the
	 * calendar
	 * 
	 * @param db
	 *            Open database object
	 * @param uniqueId
	 *            Shift uniqueId String
	 * @param id
	 *            Calendar event id
	 */
	void updateRow(SQLiteDatabase db, String uniqueId, long id) {
		ContentValues cv = new ContentValues();
		cv.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_SHIFT_CALENDAR_ID, id);

		String whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID
				+ " = " + DatabaseUtils.sqlEscapeString(uniqueId);

		db.update(ScheduleContract.ScheduleEntry.TABLE_NAME, cv, whereClause,
				null);
	}

	/**
	 * Checks if shift exists in Calendar database
	 * 
	 * @param startMillis
	 *            Shift start time in millis
	 * @param endMillis
	 *            Shift end time in millis
	 * @param eventTitle
	 *            Shift title
	 * @return If shift exists in calendar
	 */
	boolean existsInCalendar(long startMillis, long endMillis, String eventTitle) {

		String whereClause = CalendarContract.Events.DTSTART + " = '"
				+ startMillis + "' AND " + CalendarContract.Events.DTEND
				+ " = '" + endMillis + "' AND " + CalendarContract.Events.TITLE
				+ " = " + DatabaseUtils.sqlEscapeString(eventTitle);

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
	 * @param startMillis
	 *            Shift start time in millis
	 * @param endMillis
	 *            Shift end time in millis
	 * @param eventTitle
	 *            Shift title
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

		// get the event ID that is the last element in the Uri long
		// eventID
		long eventID = Long.parseLong(uri2.getLastPathSegment());

		if (reminderValue >= 0) {
			// reminder insert
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

		// Notify user that shifts were saved
		Crouton.makeText(mActivity, R.string.crouton_saved_schedule_message,
				Style.INFO, Configuration.DURATION_LONG).show();

		progressDialog.dismissAllowingStateLoss();

	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
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
					R.string.saving_schedule_message));
			return dialog;
		}
	}

}
