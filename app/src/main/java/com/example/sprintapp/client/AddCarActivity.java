package com.example.sprintapp.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sprintapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCarActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        onNavBarClick();

        Button registerButton = findViewById(R.id.save_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCar();
            }
        });
    }

    public void addCar() {
        final EditText brandField = findViewById(R.id.carBrand);
        String brand = brandField.getText().toString();

        final EditText modelField = findViewById(R.id.carModel);
        String model = modelField.getText().toString();

        final EditText productionYearField = findViewById(R.id.carProductionYear);
        String productionYear = productionYearField.getText().toString();

        final EditText fuelTypeField = findViewById(R.id.fuelType);
        String fuelType = fuelTypeField.getText().toString();

        final EditText registrationNumberField = findViewById(R.id.carRegistrationNumber);
        String registrationNumber = registrationNumberField.getText().toString();

        Map<String, Object> car = new HashMap<>();
        car.put("brand",brand);
        car.put("model",model);
        car.put("production_year",productionYear);
        car.put("fuel_type",fuelType);
        car.put("registration_number",registrationNumber);

        db.collection("cars").document()
                .set(car)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        finish();
                        showMessage(R.string.something_went_wrong);
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

    private void showMessage(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

}
