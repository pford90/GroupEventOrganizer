package com.peterford.groupeventorganizer.listeners;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;


public class UpcomingEventsItemTouchListener extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = UpcomingEventsItemTouchListener.class.getSimpleName();

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        rv.findChildViewUnder(e.getX(), e.getY());
        Log.v(TAG, "On Touch Event");
    }
}
