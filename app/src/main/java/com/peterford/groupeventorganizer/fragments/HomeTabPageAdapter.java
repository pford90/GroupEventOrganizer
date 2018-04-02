package com.peterford.groupeventorganizer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peterford.groupeventorganizer.R;

import java.util.ArrayList;

public class HomeTabPageAdapter extends FragmentPagerAdapter{

    private static final String TAG = HomeTabPageAdapter.class.getSimpleName();


    public enum HOME_TITLES { UPCOMING_EVENTS, ACTIVE_CHARGES, CALENDAR  };

    private ArrayList<HomeTab> mFragments;

    public HomeTabPageAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    public void addFragment(HomeTab fragment) {
        mFragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getArguments().getString(HomeTab.TITLE);
    }


    public static class HomeTab extends Fragment {
        public static final String ARG_OBJECT = "object";

        private static String TITLE = "TITLE";
        private static String LAYOUT = "LAYOUT";


        public static HomeTab newInstance(HOME_TITLES homeTitle) {
            HomeTab homeTab = new HomeTab();
            Bundle args = new Bundle();
            String title = "";
            int fragmentLayout;
            switch (homeTitle) {
                case UPCOMING_EVENTS:
                    title = "UPCOMING EVENTS";
                    fragmentLayout = R.layout.fragment_upcoming_events;
                    break;
                case ACTIVE_CHARGES:
                    title = "ACTIVE CHARGES";
                    fragmentLayout = R.layout.fragment_active_charges;
                    break;
                case CALENDAR:
                    title = "CALENDAR";
                    fragmentLayout = R.layout.fragment_calendar;
                    break;
                default:
                    title = "UPCOMING EVENTS";
                    fragmentLayout = R.layout.fragment_upcoming_events;
            }
            args.putString(TITLE, title);
            args.putInt(LAYOUT, fragmentLayout);
            homeTab.setArguments(args);
            return homeTab;
        }

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            // The last two arguments ensure LayoutParams are inflated
            // properly.

            Bundle args = getArguments();

            String title = args.getString(TITLE);
            int fragmentLayout = args.getInt(LAYOUT);

            View rootView = inflater.inflate(
                    fragmentLayout, container, false);

            ((TextView) rootView.findViewById(R.id.text1)).setText(title);
            return rootView;
        }

    }
}
