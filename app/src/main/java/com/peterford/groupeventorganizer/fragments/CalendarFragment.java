package com.peterford.groupeventorganizer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peterford.groupeventorganizer.R;

/**
 * Created by Peter on 4/2/2018.
 */

public class CalendarFragment extends android.support.v4.app.Fragment {

    public static CalendarFragment newInstance(String title) {
        CalendarFragment calendarFragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putString("TITLE", title);
        calendarFragment.setArguments(args);
        return calendarFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        return rootView;
    }



}
