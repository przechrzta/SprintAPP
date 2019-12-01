package com.example.sprintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Date;

public class ClientMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        CalendarView calendar = (CalendarView) findViewById(R.id.simpleCalendarView);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
//                String date = year + "/" + (month+1) + "/" + day;
                Date date = new Date(year, month, day);
                if (checkIfDateIsAvailable(date)) {
//                    finish();
//                    Intent intent = new Intent(TasksActivity.this, NotesActivity.class);
//                    intent.putExtra("date", date);
//                    startActivity(intent);
                } else {
                    showMessage(R.string.day_is_not_available);
                }

            }
        });
    }

    private void showMessage(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

    private boolean checkIfDateIsAvailable(Date date) {
        return false;
    }

}

