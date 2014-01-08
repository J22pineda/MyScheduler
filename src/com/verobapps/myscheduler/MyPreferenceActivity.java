package com.verobapps.myscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class MyPreferenceActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        setTheme(Util.getTheme(this));

		super.onCreate(savedInstanceState);
        // Set up system bar color   **NOT READY**
        //Util.setSystemBarColor(this);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new MyPreferenceFragment())
				.commit();

	}

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainScheduleActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_to_right);

    }

    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
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
}
