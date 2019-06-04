package com.example.selflearning;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiverDemo extends AppCompatActivity implements View.OnClickListener {
    Button sendBtn;
    Button regBCRBtn;
    Button remBCRBtn;
    private MyBroadcastReceiver receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_demo);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        sendBtn = findViewById(R.id.btn_send_msg);
        regBCRBtn = findViewById(R.id.btn_register_broadcast_receiver);
        remBCRBtn = findViewById(R.id.btn_remove_broadcast_receiver);
        sendBtn.setOnClickListener(this);
        regBCRBtn.setOnClickListener(this);
        remBCRBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_msg:
//                Intent intent = new Intent(this, MyBroadcastReceiver.class);
                Intent intent = new Intent(MyBroadcastReceiver.ACTION);
                intent.putExtra("data", "Hello World");
                sendBroadcast(intent);
                break;
            case R.id.btn_register_broadcast_receiver:
                if (receiver == null) {
                    receiver = new MyBroadcastReceiver();
                    registerReceiver(receiver, new IntentFilter(MyBroadcastReceiver.ACTION));
                }
                break;
            case R.id.btn_remove_broadcast_receiver:
                if (receiver != null) {
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;
        }
    }
}
