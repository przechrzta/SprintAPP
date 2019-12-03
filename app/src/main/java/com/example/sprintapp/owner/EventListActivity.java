package com.example.sprintapp.owner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.Event;
import com.example.sprintapp.shared.EventListAdapter;
import com.example.sprintapp.shared.EventType;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Intent incomingIntent = getIntent();
        final String date = incomingIntent.getStringExtra("date");
        setTitle(date);

        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event("Tomek cfel", "1231231123", new EventType(1, "Diagnostyka")));
        events.add(new Event("Adam cfel", "22222222", new EventType(2, "Wymiana oleju")));

        EventListAdapter simpleAdapter = new EventListAdapter(events);

        RecyclerView listView = findViewById(R.id.eventListView);
        listView.setAdapter(simpleAdapter);
    }

}
