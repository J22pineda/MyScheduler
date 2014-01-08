package com.verobapps.myscheduler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.psdev.licensesdialog.LicensesDialog;

public class MyPreferenceFragment extends PreferenceFragment {

	AlertDialog.Builder builder;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.preference);

		Preference myPref = (Preference) findPreference("opensource");
		myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {

				// Launch dialog onClick
				new LicensesDialog(getActivity(), R.raw.notices, false, false)
						.show();

				return false;
			}
		});

		builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.clear_cache_message);
		builder.setPositiveButton(R.string.clear_cache_positive_btn_message,
				new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						// Delete shifts
						new DeleteCalendarShiftEventsAsyncTask(getActivity())
								.execute();

					}
				});
		builder.setNegativeButton(R.string.clear_cache_negative_btn_message,
				null);

		myPref = (Preference) findPreference("clear_cache");
		myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {

				// Clear cache dialog
				AlertDialog alertDialog = builder.create();
				alertDialog.show();

				return false;
			}
		});

		myPref = (Preference) findPreference("share_app");
		myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// Launch share dialog
				Intent sharingIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				sharingIntent.setType("text/plain");
				sharingIntent.putExtra(
						android.content.Intent.EXTRA_TEXT,
						getResources().getString(
								R.string.share_app_intent_message));
				startActivity(Intent.createChooser(sharingIntent, "Share via"));

				return false;
			}
		});

		myPref = (Preference) findPreference("default_color");
		myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// Launch color picker dialog
				Intent intent = new Intent(getActivity(),
						ColorPickerDialog.class);
				startActivity(intent);

				return false;
			}
		});

		myPref = (Preference) findPreference("calendar_account");
		myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// Lauch calendar account picker dialog
				Intent intent = new Intent(getActivity(),
						AccountPickerDialogActivity.class);
				startActivity(intent);

				return false;
			}
		});

		myPref = (Preference) findPreference("join_facebook_group");
        myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference preference) {
                // Launch Facebook group
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri
                            .parse("fb://group/619807184732229"));
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri
                            .parse("http://www.facebook.com/groups/MyScheduler/")));
                }

                return false;
            }
        });

        myPref = (Preference) findPreference("theme");
        myPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                Intent intent = getActivity().getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


                return true;
            }
        });

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Crouton.cancelAllCroutons();
	}

	@Override
	public void onResume() {
		super.onResume();

		// Refresh preference screen content
		Preference myPref = (Preference) findPreference("calendar_account");

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		String name = sp.getString("calendar_account_name", "null");

		if (name.equalsIgnoreCase("null")) {
			myPref.setSummary(R.string.calendar_account_summary_default);
		} else {
			myPref.setSummary(String
					.format(getResources().getString(
							R.string.calendar_account_summary), name));
		}
	}
}
