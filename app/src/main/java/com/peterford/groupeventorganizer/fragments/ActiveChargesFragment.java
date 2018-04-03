package com.peterford.groupeventorganizer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peterford.groupeventorganizer.R;

/**
 * Created by Peter on 4/2/2018.
 */

public class ActiveChargesFragment extends Fragment {

    public static ActiveChargesFragment newInstance(String title) {
        ActiveChargesFragment activeChargesFragment = new ActiveChargesFragment();
        Bundle args = new Bundle();
        args.putString("TITLE", title);
        activeChargesFragment.setArguments(args);
        return activeChargesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_active_charges, container, false);
        return rootView;
    }

}
