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

public class ManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        setTitle("Set days availability");

        onNavBarClick();
    }

    protected void onNavBarClick(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                        String date = DateHelper.format(new Date());
                        intent1.putExtra("date", date);

                        startActivity(intent1);
                        return true;

                    case R.id.manage:
                        return true;

                }
                return true;
            }
        });

    }
}
