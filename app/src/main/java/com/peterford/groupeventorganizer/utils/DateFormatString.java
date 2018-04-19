package com.peterford.groupeventorganizer.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Peter on 4/6/2018.
 */

public class DateFormatString {
    private static final String TAG = DateFormatString.class.getSimpleName();
    // "EEEE, MMMM-dd, yyyy"
    public static String formatString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String result = dateFormat.format(date);
        Log.v(TAG, result);
        return result;
    }


}
