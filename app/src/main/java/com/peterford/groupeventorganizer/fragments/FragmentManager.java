package com.peterford.groupeventorganizer.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by Peter on 4/2/2018.
 */

public class FragmentManager {

    public static Fragment getFragment(FragmentTypes fragmentType) {
        Fragment fragment;

        switch (fragmentType) {
            case UPCOMING_EVENTS:
                fragment = UpcomingEventsFragment.newInstance("UPCOMING EVENTS");
                break;
            case ACTIVE_CHARGES:
                fragment = ActiveChargesFragment.newInstance("ACTIVE CHARGES");
                break;
            case CALENDAR:
                fragment = CalendarFragment.newInstance("CALENDAR");
                break;
            default:
                fragment = null;
        }

        return fragment;
    }
}
