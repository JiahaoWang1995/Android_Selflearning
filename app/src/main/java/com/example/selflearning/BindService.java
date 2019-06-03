package com.example.selflearning;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BindService extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    Button startBtn;
    Button stopBtn;
    Button syncBtn;
    TextView flag;
    TextView loopCount;
    EditText et;
    private MyDemoService.Binder binder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        startBtn = findViewById(R.id.btn_start_service);
        stopBtn = findViewById(R.id.btn_stop_service);
        syncBtn = findViewById(R.id.btn_sync_service);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        syncBtn.setOnClickListener(this);
        flag = findViewById(R.id.binded_service_flag);
        et = findViewById(R.id.bind_data_to_service);
        loopCount = findViewById(R.id.binded_service_loop_count);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_service:
                flag.setText("Service connected");
                loopCount.setText("Wait for incoming message from service");
                bindService(new Intent(BindService.this, MyDemoService.class), this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_stop_service:
                flag.setText("Service disconnected");
                loopCount.setText(getResources().getString(R.string.binded_service_loop_count));
                unbindService(this);
                break;
            case R.id.btn_sync_service:
                if (binder!=null) {
                    binder.setData(et.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder = (MyDemoService.Binder) service;
        binder.getMyDemoService().setCallback(new MyDemoService.Callback() {
            @Override
            public void onDataChange(String data) {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loopCount.setText(msg.getData().getString("data"));
        }
    };
}
