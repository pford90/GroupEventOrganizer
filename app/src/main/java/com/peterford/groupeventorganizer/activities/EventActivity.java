package com.peterford.groupeventorganizer.activities;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.domain.Event;
import com.peterford.groupeventorganizer.utils.DateFormatString;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private static final String TAG = EventActivity.class.getSimpleName();

    @BindView(R.id.input_event_date) Button mDatePick;
    @BindView(R.id.input_event_time) Button mTimePick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        updateDatePickText( new Date() );
        Calendar calendar = Calendar.getInstance();
        updateTimePickText( calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
    }


    @OnClick(R.id.input_event_date)
    public void showDatePickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.EventDatePicker, this, year, month, day);
        datePickerDialog.show();
    }

    @OnClick(R.id.input_event_time)
    public void showTimePickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, hour, minute, true);
        timePickerDialog.show();
    }

    private void updateTimePickText(int hour, int minute) {
        mTimePick.setText(hour + ":" + minute);
    }

    public void updateDatePickText(Date date) {
        String dateStr = DateFormatString.formatString(date, "EEEE, MMMM-dd, yyyy");
        mDatePick.setText( dateStr );
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i1, i2);
        updateDatePickText(calendar.getTime());
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Log.v(TAG, "HOUR : " + i);
        Log.v(TAG, "MINUTE : " + i1);
        updateTimePickText(i, i1);
    }

    @OnClick(R.id.input_event_create)
    public void createEvent(View view) {

    }

}
