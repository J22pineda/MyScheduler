package com.verobapps.myscheduler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.*;
import de.keyboardsurfer.android.widget.crouton.Crouton;

public class MainScheduleActivity extends FragmentActivity {

	public static boolean SCHEDULE_EXISTS = false;
	AlertDialog alertDialog;
	AlertDialog.Builder builder;
	Activity activity;

    @Override
	protected void onDestroy() {
		super.onDestroy();
		Crouton.cancelAllCroutons();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
        setTheme(Util.getTheme(this));
		super.onCreate(savedInstanceState);
		activity = this;

        // Set up system bar color    **NOT READY**
        //Util.setSystemBarColor(activity);

        // Force menu overflow on devices with hardware menu button
        Util.forceOverflowMenu(this);

		builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.save_schedule_message);

		builder.setPositiveButton(R.string.save_schedule_positive_btn_message,
				new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Save schedule if clicked yes
						new SaveScheduleAsyncTask(activity).execute();
					}
				});
		builder.setNegativeButton(R.string.save_schedule_negative_btn_message,
				null);

		Fragment fragment = getSupportFragmentManager().findFragmentById(
				android.R.id.content);
		if (fragment == null) {
			fragment = MyScheduleFragment.newInstance();
		}

		getSupportFragmentManager().beginTransaction()
				.replace(android.R.id.content, fragment).commit();

		invalidateOptionsMenu();

	}

	/*
	 * Handle action bar icons
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.schedule_activity_menu, menu);

		// Hide save icon if no shifts exist
		if (SCHEDULE_EXISTS) {
			menu.findItem(R.id.action_save).setEnabled(true);
			menu.findItem(R.id.action_save).setVisible(true);
		} else {
			menu.findItem(R.id.action_save).setEnabled(false);
			menu.findItem(R.id.action_save).setVisible(false);
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_add:
			Intent i = new Intent(this, MyWebViewActivity.class);
			startActivity(i);
			overridePendingTransition(R.anim.slide_out_to_left, R.anim.fade_out);
			return true;
		case R.id.action_save:
			AlertDialog alertDialog = builder.create();
			alertDialog.show();
			return true;
		case R.id.action_settings:
            finish();
			Intent intent = new Intent(this, MyPreferenceActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.slide_out_to_left, R.anim.fade_out);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}