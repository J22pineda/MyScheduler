package com.verobapps.myscheduler.database;

import android.provider.BaseColumns;

public final class ScheduleContract {
	// Empty constructor to prevent someone from accidentally instantiating the
	// contract class
	public ScheduleContract() {
	}

	// Inner class that defines the table contents
	public static abstract class ScheduleEntry implements BaseColumns {
		public static final String TABLE_NAME = "shift";
		public static final String COLUMN_NAME_SHIFT_CALENDAR_ID = "shiftcalendarid";
		public static final String COLUMN_NAME_EVENT_TITLE = "eventtitle";
		public static final String COLUMN_NAME_LOCATION = "location";
		public static final String COLUMN_NAME_TIME = "time";
		public static final String COLUMN_NAME_STRING_DATE = "stringdate";
		public static final String COLUMN_NAME_START_HOUR = "starthour";
		public static final String COLUMN_NAME_START_MINUTE = "startminute";
		public static final String COLUMN_NAME_END_HOUR = "endhour";
		public static final String COLUMN_NAME_END_MINUTE = "endminute";
		public static final String COLUMN_NAME_UNIQUE_ID = "uniqueid";
		public static final String COLUMN_NAME_ADD_TO_CALENDAR = "addtocalendar";
		public static final String COLUMN_NAME_DATE_MILLIS = "datemillis";

	}
}
