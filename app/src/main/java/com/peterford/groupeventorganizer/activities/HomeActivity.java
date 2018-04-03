package com.peterford.groupeventorganizer.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.adapters.HomeTabPageAdapter;
import com.peterford.groupeventorganizer.fragments.ActiveChargesFragment;
import com.peterford.groupeventorganizer.fragments.CalendarFragment;
import com.peterford.groupeventorganizer.fragments.FragmentManager;
import com.peterford.groupeventorganizer.fragments.FragmentTypes;
import com.peterford.groupeventorganizer.fragments.UpcomingEventsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = HomeActivity.class.getSimpleName();

    @BindView(R.id.home_viewPager) ViewPager mViewPager;
    @BindView(R.id.home_toolbar) Toolbar mToolbar;
    @BindView(R.id.home_tab_layout) TabLayout mTabLayout;

    private HomeTabPageAdapter mHomeTabPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mHomeTabPageAdapter = new HomeTabPageAdapter(getSupportFragmentManager());

        mHomeTabPageAdapter.addFragment(FragmentManager.getFragment(FragmentTypes.UPCOMING_EVENTS));
        mHomeTabPageAdapter.addFragment(FragmentManager.getFragment(FragmentTypes.ACTIVE_CHARGES));
        mHomeTabPageAdapter.addFragment(FragmentManager.getFragment(FragmentTypes.CALENDAR));

        mViewPager.setAdapter(mHomeTabPageAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
