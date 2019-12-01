package com.example.sprintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button garageButton = findViewById(R.id.garage_button);
        garageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ownerMainActivity = new Intent(getApplicationContext(), OwnerMainActivity.class);
                startActivity(ownerMainActivity);
            }
        });

        Button clientButton = findViewById(R.id.client_button);
        clientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clientMainActivity = new Intent(getApplicationContext(), ClientMainActivity.class);
                startActivity(clientMainActivity);
            }
        });

    }

}
