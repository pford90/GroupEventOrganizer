package com.peterford.groupeventorganizer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.adapters.HomeTabPageAdapter;

public class UpcomingEventsFragment extends Fragment {

    public static UpcomingEventsFragment newInstance(String title) {
        UpcomingEventsFragment upcomingEventsFragment = new UpcomingEventsFragment();
        Bundle args = new Bundle();
        args.putString(HomeTabPageAdapter.TITLE, title);
        upcomingEventsFragment.setArguments(args);
        return upcomingEventsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_upcoming_events, container, false);
        return rootView;
    }


}
