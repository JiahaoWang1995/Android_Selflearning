package com.example.selflearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SerializableDemoActivity extends AppCompatActivity {
    public static final String ACTION = "com.example.selflearning.intent.action.SerializableDemoActivity";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable_demo);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        tv = findViewById(R.id.text);
        Intent intent = getIntent();
        PeopleSerializable data = (PeopleSerializable) intent.getSerializableExtra("Serializable");
        tv.setText(String.format("Name is %s, age is %d", data.getName(), data.getAge()));
    }
}
