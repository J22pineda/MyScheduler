package com.verobapps.myscheduler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class AccountPickerDialogActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Fragment fragment = getSupportFragmentManager().findFragmentById(
				android.R.id.content);
		if (fragment == null) {
			fragment = AccountPickerDialogFragment.newInstance();
		}

		getSupportFragmentManager().beginTransaction()
				.replace(android.R.id.content, fragment).commit();

	}

}
