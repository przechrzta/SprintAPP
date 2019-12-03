package com.example.sprintapp.owner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sprintapp.R;

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
