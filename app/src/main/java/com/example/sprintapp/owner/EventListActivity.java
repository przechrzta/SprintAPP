package com.example.sprintapp.owner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.Event;
import com.example.sprintapp.shared.EventListAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class EventListActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        onNavBarClick();
        Intent incomingIntent = getIntent();
        final String date = incomingIntent.getStringExtra("date");
        setTitle(date);

        getEventsForDate(date);
    }

    private void getEventsForDate(String date) {
        db.collection("dates").document(date).collection("events").addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                List<Event> events = null;
                if (documentSnapshot != null) {
                    events = documentSnapshot.toObjects(Event.class);
                }

                if (events == null) {
                    events = new ArrayList<>();
                }

                EventListAdapter simpleAdapter = new EventListAdapter(events);

                RecyclerView listView = findViewById(R.id.eventListView);
                listView.setAdapter(simpleAdapter);
            }

        });
    }

    protected void onNavBarClick(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.calendar:
                        finish();
                        Intent intent = new Intent(getApplicationContext(), OwnerMainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.today:
                        Intent intent1= new Intent(getApplicationContext(), EventListActivity.class);
                        startActivity(intent1);
                        return true;

                    case R.id.manage:
                        Intent intent2= new Intent(getApplicationContext(), ManageActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return true;
            }
        });

    }

}
