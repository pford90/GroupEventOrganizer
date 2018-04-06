package com.peterford.groupeventorganizer.activities;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.peterford.groupeventorganizer.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = EventActivity.class.getSimpleName();

    @BindView(R.id.input_event_date) Button mDatePick;
//    @BindView(R.id.input_event_date) DatePicker mDatePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        updateDatePickText( new Date() );
    }


    @OnClick(R.id.input_event_date)
    public void showDatePickerDialog(View view) {
//        DatePickerFragment dialogFragment = new DatePickerFragment();
//        dialogFragment.show(getSupportFragmentManager(), "datePicker");
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.EventDatePicker, this, year, month, day);
        datePickerDialog.show();
    }

    private String formatString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM-dd, yyyy");
        String result = dateFormat.format(date);
        Log.v(TAG, result);
        return result;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i1, i2);
        updateDatePickText(calendar.getTime());
    }

    public void updateDatePickText(Date date) {
        String dateStr = formatString( date );
        Log.v(TAG, dateStr);
        mDatePick.setText( dateStr );
    }

    @Override
    protected void onPause() {
        Log.v(TAG, "ON PAUSE");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG, "ON RESUME");
        super.onResume();
    }
}
