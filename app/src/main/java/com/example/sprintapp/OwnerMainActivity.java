package com.example.sprintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class OwnerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_main_activity);


        CalendarView calendar = findViewById(R.id.simpleCalendarView);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                String date = year + "/" + (month+1) + "/" + day;
                finish();
                Intent intent = new Intent(getApplicationContext(), NotesActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }

}
