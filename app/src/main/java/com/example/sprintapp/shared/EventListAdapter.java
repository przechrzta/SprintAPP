package com.example.sprintapp.shared;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;

import java.util.List;


public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {

    private List<Event> events;


    public EventListAdapter(List<Event> events) {
        this.events = events;
    }

    @Override
    @NonNull
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);

        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final Event event = events.get(position);

        holder.clientNameTextView.setText(event.getClientName());
        holder.clientPhoneNumberTextView.setText(event.getPhoneNumber());
        holder.eventTypeTextView.setText(event.getEventType().getName());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    static class EventViewHolder extends RecyclerView.ViewHolder {

        TextView clientNameTextView;
        TextView clientPhoneNumberTextView;
        TextView eventTypeTextView;


        EventViewHolder(View v) {
            super(v);
            clientNameTextView = v.findViewById(R.id.clientName);
            clientPhoneNumberTextView = v.findViewById(R.id.clientPhoneNumber);
            eventTypeTextView = v.findViewById(R.id.eventType);
        }
    }

}