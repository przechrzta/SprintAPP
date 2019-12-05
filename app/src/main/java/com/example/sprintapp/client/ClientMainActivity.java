package com.example.sprintapp.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sprintapp.R;
import com.example.sprintapp.owner.EventListActivity;
import com.example.sprintapp.owner.ManageActivity;
import com.example.sprintapp.owner.OwnerMainActivity;
import com.example.sprintapp.shared.DateHelper;
import com.example.sprintapp.shared.Event;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClientMainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        CalendarView calendar = findViewById(R.id.simpleCalendarView);
        calendar.setOnDateChangeListener(this);

        onNavBarClick();
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        Date date = DateHelper.createDate(year, month, dayOfMonth);
        checkIfDateIsAvailable(date);
    }

    private void checkIfDateIsAvailable(final Date date) {
        final String stringDate = DateHelper.format(date);

        db.collection("dates").document(stringDate).collection("events").addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                List<Event> events = null;
                if (documentSnapshot != null) {
                    events = documentSnapshot.toObjects(Event.class);
                }

                if (events == null) {
                    events = new ArrayList<>();
                }

                if (events.size() <= 8) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    intent.putExtra("date", stringDate);
                    startActivity(intent);
                } else {
                    showMessage(R.string.day_is_not_available);
                }
            }

        });

    }

    private void showMessage(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

    protected void onNavBarClick() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.calendar_client:
                        finish();
                        Intent intent = new Intent(getApplicationContext(), ClientMainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.my_cars:
                        Intent intent1 = new Intent(getApplicationContext(), CarsActivity.class);
                        startActivity(intent1);
                        return true;

                    case R.id.my_visits:
                        Intent intent2 = new Intent(getApplicationContext(), VisitsActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return true;
            }
        });
    }
}



