package com.example.sprintapp.client;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.DateHelper;

public class ClientMainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        CalendarView calendar = findViewById(R.id.simpleCalendarView);
        calendar.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        String date = DateHelper.format(year, month, dayOfMonth);
        if (checkIfDateIsAvailable(date)) {
//                    finish();
//                    Intent intent = new Intent(TasksActivity.this, EventListActivity.class);
//                    intent.putExtra("date", date);
//                    startActivity(intent);
        } else {
            showMessage(R.string.day_is_not_available);
        }
    }

    private boolean checkIfDateIsAvailable(String date) {
        return false;
    }

    private void showMessage(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

}

