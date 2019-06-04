package com.example.selflearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ParcelableDemoActivity extends AppCompatActivity {
    public static final String ACTION = "com.example.selflearning.intent.action.ParcelableDemoActivity";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_demo);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        tv = findViewById(R.id.text);
        Intent intent = getIntent();
        PeopleParcelable data = intent.getParcelableExtra("Parcelable");
        tv.setText(String.format("Name is %s, age is %d", data.getName(), data.getAge()));
    }
}
