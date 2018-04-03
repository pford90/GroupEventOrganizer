package com.peterford.groupeventorganizer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.domain.Event;
import com.peterford.groupeventorganizer.fragments.UpcomingEventsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Peter on 4/2/2018.
 */

public class UpcomingEventsAdapter extends RecyclerView.Adapter<UpcomingEventsAdapter.ViewHolder> {

    private static final String TAG = UpcomingEventsAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<Event> mEvents;

    public UpcomingEventsAdapter(Context context, ArrayList events) {
        mContext = context;
        mEvents = events;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_upcoming_events, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_event_title) TextView mEventTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(Event event) {
            mEventTitle.setText(event.getTitle());
        }
    }
}
