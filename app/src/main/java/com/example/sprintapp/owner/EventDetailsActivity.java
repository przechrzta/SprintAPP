package com.example.sprintapp.owner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.DateHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Date;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        onNavBarClick();
    }


    protected void onNavBarClick() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
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
                        Intent intent1 = new Intent(getApplicationContext(), EventListActivity.class);
                        String date = DateHelper.format(new Date());
                        intent1.putExtra("date", date);

                        startActivity(intent1);
                        return true;

                    case R.id.manage:
                        Intent intent2 = new Intent(getApplicationContext(), ManageActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return true;
            }
        });
    }
}
