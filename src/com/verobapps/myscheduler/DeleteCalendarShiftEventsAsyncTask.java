package com.verobapps.myscheduler;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;

import com.verobapps.myscheduler.database.ScheduleContract;
import com.verobapps.myscheduler.database.ScheduleDbHelper;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;


public class DeleteCalendarShiftEventsAsyncTask extends
		AsyncTask<Void, Void, Void> {

	Context mContext;
	Activity mActivity;
	ProgressDialogFragment progressDialog;
	ScheduleDbHelper mDbHelper;

	public DeleteCalendarShiftEventsAsyncTask(Activity activity) {
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
				ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS };

		String whereClause = ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR
				+ "=1";

		// Get all shifts that have add to calendar to true
		Cursor c = db.query(ScheduleContract.ScheduleEntry.TABLE_NAME,
				scheduleProjection, whereClause, null, null, null, null);

		c.moveToFirst();

		if (c.getCount() > 0) {
			do {
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

				deleteShiftEvent(startMillis, endMillis, eventTitle);

			} while (c.moveToNext());
		}

		c.close();

		// Delete all shifts from internal database
		db.execSQL("DROP TABLE IF EXISTS "
				+ ScheduleContract.ScheduleEntry.TABLE_NAME);
		mDbHelper.onCreate(db);

		db.close();

		return null;
	}

	/**
	 * Checks if shift exists in calendar, deletes it if it does
	 * 
	 * @param startMillis
	 *            Beginning of shift in millis
	 * @param endMillis
	 *            End of shift in millis
	 * @param eventTitle
	 *            Title of shift event
	 */
	void deleteShiftEvent(long startMillis, long endMillis, String eventTitle) {

		String[] scheduleProjection = { CalendarContract.Events._ID };

		String whereClause = CalendarContract.Events.DTSTART + " = '"
				+ startMillis + "' AND " + CalendarContract.Events.DTEND
				+ " = '" + endMillis + "' AND " + CalendarContract.Events.TITLE
				+ " = " + DatabaseUtils.sqlEscapeString(eventTitle);

		// Return calendar event that match whereclause
		Cursor cursor = mContext.getContentResolver().query(
				Uri.parse("content://com.android.calendar/events"),
				scheduleProjection, whereClause, null, null);

		cursor.moveToFirst();

		// Get id of calendar event and delete it from calendar
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
		progressDialog.dismissAllowingStateLoss();
		Crouton.makeText(mActivity, R.string.crouton_shifts_deleted_message,
				Style.INFO, Configuration.DURATION_LONG).show();
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
