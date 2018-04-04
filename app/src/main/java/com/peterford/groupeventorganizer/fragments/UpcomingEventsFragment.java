package com.peterford.groupeventorganizer.fragments;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.adapters.HomeTabPageAdapter;
import com.peterford.groupeventorganizer.adapters.UpcomingEventsAdapter;
import com.peterford.groupeventorganizer.domain.Event;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpcomingEventsFragment extends Fragment {

    private static final String TAG = UpcomingEventsFragment.class.getSimpleName();

    @BindView(R.id.upcoming_event_recyclerView) RecyclerView mRecyclerView;
    private UpcomingEventsAdapter mUpcomingEventsAdapter;

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
        ButterKnife.bind(this, rootView);

        ArrayList<Event> events = new ArrayList<>();
        Event event = new Event();
        event.setTitle("TEST 2");
        events.add( event );

        Event event2 = new Event();
        event2.setTitle("TEST 2");
        events.add(event2);

        mUpcomingEventsAdapter = new UpcomingEventsAdapter(getContext(), events);
        mRecyclerView.setAdapter(mUpcomingEventsAdapter);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        return rootView;
    }


}
