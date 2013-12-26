package com.verobapps.myscheduler;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class ColorPickerDialog extends FragmentActivity {

	GridView myGrid;
	int[] defaultColors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY,
			Color.GRAY, Color.GREEN, Color.LTGRAY, Color.MAGENTA, Color.RED,
			Color.WHITE, Color.YELLOW };

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.color_picker_layout);

		myGrid = (GridView) findViewById(R.id.myColorGridview);

		myGrid.setAdapter(new MyColorAdapter(getApplicationContext(),
				defaultColors));

		// Save selected color to shared preferences
		myGrid.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				SharedPreferences pref = PreferenceManager
						.getDefaultSharedPreferences(getApplicationContext());
				pref.edit().putInt("default_color", defaultColors[position])
						.commit();

				finish();

			}
		});

		// Default color button
		Button resetBtn = (Button) findViewById(R.id.reset_default_btn);
		resetBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences pref = PreferenceManager
						.getDefaultSharedPreferences(getApplicationContext());
				pref.edit().putInt("default_color", 0).commit();

				finish();
			}
		});
	}

	class MyColorAdapter extends BaseAdapter {
		private Context mContext;
		private int[] mColors;

		public MyColorAdapter(Context context, int[] colors) {
			mContext = context;
			mColors = colors;
		}

		@Override
		public int getCount() {
			return mColors.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@SuppressWarnings("deprecation")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View gridView;

			if (convertView == null) {
				gridView = new View(mContext);
				gridView = inflater.inflate(R.layout.grid_item_layout, null);

			} else {
				gridView = (View) convertView;
			}

			GradientDrawable shape = new GradientDrawable();
			shape.setCornerRadius(8);
			shape.setColor((mColors[position]));

			// set value into textview
			TextView textView = (TextView) gridView.findViewById(R.id.color);
			textView.setBackgroundDrawable(shape);

			return gridView;
		}
	}
}
