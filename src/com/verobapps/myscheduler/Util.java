package com.verobapps.myscheduler;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.*;
import android.widget.FrameLayout.LayoutParams;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility class
 */
public class Util {

    public static String DEBUG_MYSCHEDULER = "debug_myscheduler";
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";

    public static void forceOverflowMenu(Activity activity){
        try {
            ViewConfiguration config = ViewConfiguration.get(activity);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception ex) {
            // Ignore
        }
    }

    public static int getTheme(Context mContext) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(mContext);

        int theme = Integer.parseInt(sp.getString("theme", String.valueOf(R.style.Theme_Light_blue)));

        switch (theme) {
            case 0:
                return R.style.Theme_Dark;
            case 1:
                return R.style.Theme_Light;
            case 2:
                return R.style.Theme_Light_blue;
            case 3:
                return R.style.Theme_Orange;

            default:
                return R.style.Theme_Light_blue;
        }
    }

    /*
    *   This will determine the size of the status bar
    *
    *   @res The activity's current resources
    *   @key String needed to identify the resource
    *
    */
    private static int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /*
    * Will set the color of the view under the transparent status bar so it matches the action bar
    *
    * @activity The current Activity
    *
    */

    public static void setSystemBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            Window win = activity.getWindow();
            ViewGroup decorViewGroup = (ViewGroup) win.getDecorView();

            View mStatusBarTintView = new View(activity);
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, getInternalDimensionSize(activity
                    .getResources(), STATUS_BAR_HEIGHT_RES_NAME));
            params.gravity = Gravity.TOP;

            mStatusBarTintView.setLayoutParams(params);
            SharedPreferences sp = PreferenceManager
                    .getDefaultSharedPreferences(activity);

            int theme = Integer.parseInt(sp.getString("theme", String.valueOf(R.style.Theme_Light_blue)));
            int statusBarColor;

            switch (theme) {
                case 0:
                    statusBarColor = R.color.black;
                    break;
                case 1:
                    statusBarColor = R.color.white_ab;
                    break;
                case 2:
                    statusBarColor = R.color.status_bar_blue;
                    break;
                case 3:
                    statusBarColor = R.color.orange_ab;
                    break;
                default:
                    statusBarColor = R.color.status_bar_blue;
            }

            mStatusBarTintView.setBackgroundColor(activity.getResources().getColor(statusBarColor));
            decorViewGroup.addView(mStatusBarTintView);


        }
    }


    // Adds days to Date object
    public static Calendar addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal;
    }
}
