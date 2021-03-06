package com.example.sprintapp.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CarsActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        onNavBarClick();

        setTitle("My cars");

        Button addCarButton = findViewById(R.id.add_car_button);
        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddCarActivity = new Intent(getApplicationContext(), AddCarActivity.class);
                startActivity(AddCarActivity);
            }
        });

        getCars();
    }

    private void getCars(){
        db.collection("cars").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                List<Car> cars = null;
                if(queryDocumentSnapshots != null){
                    cars = queryDocumentSnapshots.toObjects(Car.class);
                }

                if (cars == null) {
                    cars = new ArrayList<>();
                }

                CarListAdapter simpleAdapter = new CarListAdapter(cars);

                RecyclerView listView = findViewById(R.id.carsView);
                listView.setAdapter(simpleAdapter);
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
