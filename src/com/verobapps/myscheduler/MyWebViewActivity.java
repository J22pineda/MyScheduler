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

	public static String SCHEDULE_LINK = "http://www.myscheduler.org/redirect";
    public static String SCHEDULE_HTML = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
        setTheme(Util.getTheme(this));

		super.onCreate(savedInstanceState);
        // Set up system bar color    **NOT READY**
        //Util.setSystemBarColor(this);

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
            case R.id.action_reload:
                SCHEDULE_LINK = "https://enterpriseportal.disney.com/site/dlr/menuitem.427e06f258729e615927f59354276099/index.jsp";
                Fragment fragment = MyWebViewFragment.newInstance();

                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.webview_fragment, fragment);
                // Commit the transaction
                transaction.commit();
                return true;
		case android.R.id.home:
            finish();
            Intent intent = new Intent(this, MainScheduleActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.slide_out_to_right);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SCHEDULE_LINK = "http://www.myscheduler.org/redirect";
    }

    @Override
    protected void onPause() {
        super.onPause();
        SCHEDULE_LINK = "http://www.myscheduler.org/redirect";
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainScheduleActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_to_right);

    }
}
