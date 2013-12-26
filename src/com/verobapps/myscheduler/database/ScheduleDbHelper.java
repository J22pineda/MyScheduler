package com.verobapps.myscheduler.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ScheduleDbHelper extends SQLiteOpenHelper {

	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String UNIQUE_TYPE = " UNIQUE";

	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
			+ ScheduleContract.ScheduleEntry.TABLE_NAME + " ("
			+ ScheduleContract.ScheduleEntry._ID + " INTEGER PRIMARY KEY,"
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_SHIFT_CALENDAR_ID
			+ TEXT_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_EVENT_TITLE
			+ TEXT_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_LOCATION + TEXT_TYPE
			+ COMMA_SEP + ScheduleContract.ScheduleEntry.COLUMN_NAME_TIME
			+ TEXT_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_STRING_DATE
			+ TEXT_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_START_HOUR
			+ INTEGER_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_START_MINUTE
			+ INTEGER_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_END_HOUR
			+ INTEGER_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_ADD_TO_CALENDAR
			+ INTEGER_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_DATE_MILLIS
			+ INTEGER_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_UNIQUE_ID + TEXT_TYPE
			+ UNIQUE_TYPE + COMMA_SEP
			+ ScheduleContract.ScheduleEntry.COLUMN_NAME_END_MINUTE
			+ INTEGER_TYPE + " )";

	private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
			+ ScheduleContract.ScheduleEntry.TABLE_NAME;

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "MyScheduledShifts.db";
	public static final String DATABASE_PATH = "/data/data/com.verobapps.myscheduler/databases/";

	private SQLiteDatabase myDataBase;

	private final Context myContext;

	public ScheduleDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		myContext = context;
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}

	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			String myPath = ScheduleDbHelper.DATABASE_PATH
					+ ScheduleDbHelper.DATABASE_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {
			// database does't exist yet.
		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}

	/**
	 * Creates a empty database on the system and rewrites it with own database.
	 */
	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();

		if (dbExist) {
			// do nothing - database already exist
		} else {

			this.getReadableDatabase();

			try {

				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");

			}
		}
	}

	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

		// Path to the just created empty db
		String outFileName = DATABASE_PATH + DATABASE_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void openDataBase() throws SQLException {

		// Open the database
		String myPath = DATABASE_PATH + DATABASE_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);
	}

	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}
}
