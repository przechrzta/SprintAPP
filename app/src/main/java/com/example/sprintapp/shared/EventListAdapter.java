package com.example.sprintapp.shared;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.MyViewHolder> {

    private List<Event> mDataset;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }


    public EventListAdapter(List<Event> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public EventListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position).getClientName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}