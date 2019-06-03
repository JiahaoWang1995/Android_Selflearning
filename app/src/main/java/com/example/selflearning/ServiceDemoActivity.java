package com.example.selflearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceDemoActivity extends AppCompatActivity {
    Button startBtn;
    Button stopBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        startBtn = findViewById(R.id.btn_start_service);
        stopBtn = findViewById(R.id.btn_stop_service);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ServiceDemoActivity.this, MyDemoService.class));
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ServiceDemoActivity.this, MyDemoService.class));
            }
        });
    }
}
