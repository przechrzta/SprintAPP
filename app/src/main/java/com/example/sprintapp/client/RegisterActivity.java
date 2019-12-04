package com.example.sprintapp.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
            }
        });

        final Spinner maintenanceSpinner = findViewById(R.id.eventType);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.event_types,
                android.R.layout.simple_spinner_item
        );

        maintenanceSpinner.setAdapter(adapter);
    }

    public void register(String date) {
        final EditText clientNameField = findViewById(R.id.clientName);
        String clientName = clientNameField.getText().toString();

        final EditText phoneNumberField = findViewById(R.id.phoneNumber);
        String phoneNumber = phoneNumberField.getText().toString();

        final EditText additionalInfoField = findViewById(R.id.additionalInfo);
        String additionalInfo = additionalInfoField.getText().toString();

        final EditText carModelField = findViewById(R.id.carModel);
        String carModel = carModelField.getText().toString();

        final EditText carProductionYearField = findViewById(R.id.carProductionYear);
        String carProductionYear = carProductionYearField.getText().toString();

        final EditText carRegistrationNumberField = findViewById(R.id.carRegistrationNumber);
        String carRegistrationNumber = carRegistrationNumberField.getText().toString();

        final Spinner eventTypeField = findViewById(R.id.eventType);
        TextView textView = (TextView) eventTypeField.getSelectedView();
        String eventType = textView.getText().toString();


        Map<String, Object> event = new HashMap<>();
        event.put("clientName", clientName);
        event.put("phoneNumber", phoneNumber);
        event.put("additionalInfo", additionalInfo);
        event.put("carModel", carModel);
        event.put("carProductionYear", carProductionYear);
        event.put("carRegistrationNumber", carRegistrationNumber);
        event.put("eventType", eventType);

        db.collection("dates").document(date)
                .collection("events").document()
                .set(event)
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

    private void showMessage(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

}
