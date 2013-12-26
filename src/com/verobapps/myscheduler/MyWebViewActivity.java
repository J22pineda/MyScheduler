package com.verobapps.myscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MyWebViewActivity extends FragmentActivity {

	public static String SCHEDULE_LINK = "https://enterpriseportal.disney.com/site/dlr/template"
			+ ".MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet"
			+ ".tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252FViewCalendar.do%253Bjsessionid%253DD2AB05CE88A7E2DF075DC48F81CD37C9&beanID=1406643234&viewID=maximized&method=loadViewMySchedule&a=1";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        // Set up system bar color
        Util.setSystemBarColor(this);

		setContentView(R.layout.webview_layout);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		Fragment fragment = MyWebViewFragment.newInstance();

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.add(R.id.webview_fragment, fragment);
		// Commit the transaction
		transaction.commit();
	}

	/*
	 * Handle action bar icons
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.webview_activity_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_copy:
			new GetScheduleAsyncTask(this).execute();
			return true;
		case R.id.action_settings:
			Intent intent = new Intent(this, MyPreferenceActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.slide_out_to_left, R.anim.fade_out);
			return true;
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		SCHEDULE_LINK = "https://enterpriseportal.disney.com/site/dlr/template"
				+ ".MAXIMIZE/menuitem.427e06f258729e615927f59354276099/?javax.portlet"
				+ ".tpst=65fa5153808737f60d9cab10b5e26099_ws_MX&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_viewID=maximized&javax.portlet.prp_65fa5153808737f60d9cab10b5e26099_dsfnavstate=%252FEHHLSM%252FViewCalendar.do%253Bjsessionid%253DD2AB05CE88A7E2DF075DC48F81CD37C9&beanID=1406643234&viewID=maximized&method=loadViewMySchedule&a=1";

	}

}
