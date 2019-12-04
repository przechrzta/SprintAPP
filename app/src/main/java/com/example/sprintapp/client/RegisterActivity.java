package com.example.sprintapp.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sprintapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent incomingIntent = getIntent();
        final String date = incomingIntent.getStringExtra("date");

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(date);
                Intent ClientMainActivity = new Intent(getApplicationContext(), ClientMainActivity.class);
                startActivity(ClientMainActivity);
            }
        });

        final Spinner maintenanceSpinner = findViewById(R.id.maintenance);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.event_types,
                android.R.layout.simple_spinner_item
        );

        maintenanceSpinner.setAdapter(adapter);
    }

    public void register(String date) {
        final EditText nameField = findViewById(R.id.Name);
        String name = nameField.getText().toString();

        final EditText lastNameField = findViewById(R.id.lastName);
        String lastName = lastNameField.getText().toString();

        final EditText phoneNumberField = findViewById(R.id.phoneNumber);
        String phoneNumber = phoneNumberField.getText().toString();

        final EditText additionalInfoField = findViewById(R.id.additional_info);
        String additionalInfo = additionalInfoField.getText().toString();

        final EditText modelField = findViewById(R.id.car_model);
        String carModel = modelField.getText().toString();

        final EditText yearOfProdField = findViewById(R.id.production_year);
        String yearOfProd = yearOfProdField.getText().toString();

        final EditText registrationNumberField = findViewById(R.id.registration_number);
        String registrationNumber = registrationNumberField.getText().toString();

        final Spinner maintenanceSpinner = findViewById(R.id.maintenance);
        TextView textView = (TextView) maintenanceSpinner.getSelectedView();
        String maintenanceType = textView.getText().toString();


        Map<String, Object> event = new HashMap<>();
        event.put("Name",name);
        event.put("LastName", lastName);
        event.put("phoneNumber", phoneNumber);
        event.put("AdditionalInfo", additionalInfo);
        event.put("model", carModel);
        event.put("year", yearOfProd);
        event.put("registrationNumber", registrationNumber);
        event.put("eventType", maintenanceType);


        db.collection("dates").document(date).collection("events").document()
                .set(event)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });

    }



}
