package com.example.sprintapp.owner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.DateHelper;

public class OwnerMainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_main_activity);

        CalendarView calendar = findViewById(R.id.simpleCalendarView);
        calendar.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        String date = DateHelper.format(year, month, dayOfMonth);
        Intent intent = new Intent(getApplicationContext(), EventListActivity.class);
        intent.putExtra("date", date);
        startActivity(intent);
    }

}
