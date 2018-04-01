package com.peterford.groupeventorganizer.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.api.responses.UserResponse;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UserResponse userResponse = (UserResponse)getIntent().getParcelableExtra("USER");
        Log.v(TAG, userResponse.getFirstName());
    }
}
