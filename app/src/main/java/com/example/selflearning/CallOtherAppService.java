package com.example.selflearning;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aidldemo.AppServiceRemoteBinder;

public class CallOtherAppService extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    Button startBtn;
    Button stopBtn;
    Button startBindBtn;
    Button stopBindBtn;
    Button syncBindBtn;
    EditText et;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_other_app_service);
        startBtn = findViewById(R.id.btn_start_service);
        stopBtn = findViewById(R.id.btn_stop_service);
        startBindBtn = findViewById(R.id.btn_bind_service);
        stopBindBtn = findViewById(R.id.btn_unbind_service);
        syncBindBtn = findViewById(R.id.btn_sync_service);
        et = findViewById(R.id.data_to_service);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        startBindBtn.setOnClickListener(this);
        stopBindBtn.setOnClickListener(this);
        syncBindBtn.setOnClickListener(this);

        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.aidldemo",
                "com.example.aidldemo.AppService"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                serviceIntent.putExtra("data", et.getText().toString());
                startService(serviceIntent);
                break;
            case R.id.btn_stop_service:
                stopService(serviceIntent);
                break;
            case R.id.btn_bind_service:
                bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(this);
                break;
            case R.id.btn_sync_service:
                if (binder!=null) {
                    try {
                        binder.setData(et.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        System.out.println("Can not get remote service");
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Bind service");
        System.out.println(service);
        binder = AppServiceRemoteBinder.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    private AppServiceRemoteBinder binder = null;
}
