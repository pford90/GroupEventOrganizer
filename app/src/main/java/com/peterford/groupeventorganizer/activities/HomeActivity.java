package com.peterford.groupeventorganizer.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;


import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.adapters.HomeTabPageAdapter;
import com.peterford.groupeventorganizer.fragments.FragmentManager;
import com.peterford.groupeventorganizer.fragments.FragmentTypes;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private final String TAG = HomeActivity.class.getSimpleName();

    @BindView(R.id.home_viewPager) ViewPager mViewPager;
    @BindView(R.id.home_toolbar) Toolbar mToolbar;
    @BindView(R.id.home_tab_layout) TabLayout mTabLayout;

    @BindView(R.id.home_nav_drawerLayout) DrawerLayout mDrawerLayout;
    @BindView(R.id.home_nav_view) NavigationView mNavigationView;
    private HomeTabPageAdapter mHomeTabPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_nav);

        mNavigationView.setNavigationItemSelectedListener(this);


        mHomeTabPageAdapter = new HomeTabPageAdapter(getSupportFragmentManager());

        mHomeTabPageAdapter.addFragment(FragmentManager.getFragment(FragmentTypes.UPCOMING_EVENTS));
        mHomeTabPageAdapter.addFragment(FragmentManager.getFragment(FragmentTypes.ACTIVE_CHARGES));
        mHomeTabPageAdapter.addFragment(FragmentManager.getFragment(FragmentTypes.CALENDAR));

        mViewPager.setAdapter(mHomeTabPageAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_event:
                Intent intent = new Intent(getApplicationContext(), EventActivity.class);
                startActivity(intent);
        }
        return true;
    }
}
