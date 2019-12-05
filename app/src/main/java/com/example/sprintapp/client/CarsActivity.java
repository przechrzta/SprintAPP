package com.example.sprintapp.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.sprintapp.R;
import com.example.sprintapp.owner.OwnerMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarsActivity extends AppCompatActivity {

    ListView listView;
    String car[] = {"Audi Q7", "BMW X5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        onNavBarClick();

        //listView = findViewById(R.id.ListView);

        setTitle("My cars");

        Button addCarButton = findViewById(R.id.add_car_button);
        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddCarActivity = new Intent(getApplicationContext(), AddCarActivity.class);
                startActivity(AddCarActivity);
            }
        });
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
