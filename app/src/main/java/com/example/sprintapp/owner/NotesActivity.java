package com.example.sprintapp.owner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sprintapp.R;
import com.example.sprintapp.shared.Event;
import com.example.sprintapp.shared.EventListAdapter;
import com.example.sprintapp.shared.EventType;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    private TextView theDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ArrayList<Event> itemDataList = new ArrayList<>();

        itemDataList.add(new Event("Tomek cfel", "1231231123", EventType.DIAGNOSTICS));
        itemDataList.add(new Event("Adam cfel", "22222222", EventType.OIL_CHANGE));

        EventListAdapter simpleAdapter = new EventListAdapter(itemDataList);

        RecyclerView listView = findViewById(R.id.listView);
        listView.setAdapter(simpleAdapter);

//        theDate = findViewById(R.id.date);
//        btnGoToTasks = (Button) findViewById(R.id.btnGoToTasks);
//        btnAddTask = (Button) findViewById(R.id.btnAddTask);

        Intent incomingIntent = getIntent();
        final String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);
//
//        btnGoToTasks.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                finish();
//                Intent intent = new Intent(NotesActivity.this, TasksActivity.class);
//                startActivity(intent);
//            }
//                                        }
//        );
//        btnAddTask.setOnClickListener(new View.OnClickListener(){
//                                            @Override
//                                            public void onClick(View view){
//                                                Intent intent = new Intent(NotesActivity.this, AddTaskActivity.class);
//                                                intent.putExtra("date", date);
//                                                startActivity(intent);
//                                            }
//                                        }
//        );
    }



}
