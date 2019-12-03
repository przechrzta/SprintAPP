package com.example.sprintapp.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sprintapp.R;
import com.example.sprintapp.owner.EventListActivity;
import com.example.sprintapp.shared.DateHelper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                Intent ClientMainActivity = new Intent(getApplicationContext(), ClientMainActivity.class);
                startActivity(ClientMainActivity);
            }
        });
    }

    public void register(){
        final EditText nameField = (EditText) findViewById(R.id.Name);
        String name = nameField.getText().toString();

        final EditText lastNameField = (EditText) findViewById(R.id.lastName);
        String lastName = lastNameField.getText().toString();

        final EditText phoneNumberField = (EditText) findViewById(R.id.phoneNumber);
        String phoneNumber = phoneNumberField.getText().toString();

        Map<String, Object> client = new HashMap<>();
        client.put("Name",name);
        client.put("LastName", lastName);
        client.put("phoneNumber", phoneNumber);


        db.collection("forms").document(phoneNumber)
                .set(client)
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