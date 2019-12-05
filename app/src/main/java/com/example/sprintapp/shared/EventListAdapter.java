package com.example.sprintapp.shared;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;
import com.example.sprintapp.owner.EventDetailsActivity;

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

        return new EventViewHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, int position) {
        final Event event = events.get(position);

        holder.clientNameTextView.setText(event.getClientName());
        holder.clientPhoneNumberTextView.setText(event.getPhoneNumber());
        holder.eventTypeTextView.setText(event.getEventType());

        holder.clientDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, EventDetailsActivity.class);
                holder.context.startActivity(intent);
            }
        });

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + event.getPhoneNumber()));
                if (holder.context.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(holder.context, R.string.no_phone_permission, Toast.LENGTH_SHORT).show();
                } else {
                    holder.context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    static class EventViewHolder extends RecyclerView.ViewHolder {

        TextView clientNameTextView;
        TextView clientPhoneNumberTextView;
        TextView eventTypeTextView;
        LinearLayout clientDetails;
        Button callButton;

        final Context context;


        EventViewHolder(View v, final Context context) {
            super(v);
            this.context = context;
            clientNameTextView = v.findViewById(R.id.clientName);
            clientPhoneNumberTextView = v.findViewById(R.id.clientPhoneNumber);
            eventTypeTextView = v.findViewById(R.id.eventType);
            clientDetails = v.findViewById(R.id.clientDetails);
            callButton = v.findViewById(R.id.call_button);
        }

    }

}