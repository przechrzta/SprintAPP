package com.example.sprintapp.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sprintapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VisitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);

        onNavBarClick();
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
