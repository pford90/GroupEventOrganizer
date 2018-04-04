package com.peterford.groupeventorganizer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peterford.groupeventorganizer.R;
import com.peterford.groupeventorganizer.domain.Event;
import com.peterford.groupeventorganizer.fragments.UpcomingEventsFragment;
import com.peterford.groupeventorganizer.listeners.RecyclerViewClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpcomingEventsAdapter extends RecyclerView.Adapter<UpcomingEventsAdapter.ViewHolder> {

    private static final String TAG = UpcomingEventsAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<Event> mEvents;

    public UpcomingEventsAdapter(Context context, ArrayList<Event> events) {
        mContext = context;
        mEvents = events;

        Log.v(TAG, "SIZE OF EVENTS LIST : " + mEvents.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_upcoming_events, null, false);
        return new ViewHolder(view, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.v(TAG, "EVENT NUMBER : " + mEvents.get(position).getTitle());
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerViewClickListener mRecyclerViewClickListener;

        @BindView(R.id.list_item_event_title) TextView mEventTitle;

        public ViewHolder(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mRecyclerViewClickListener = recyclerViewClickListener;
        }

        @Override
        public void onClick(View view) {
            mRecyclerViewClickListener.onClick(view, getAdapterPosition());
        }

        public void bindData(Event event) {
            mEventTitle.setText(event.getTitle());
        }
    }
}
