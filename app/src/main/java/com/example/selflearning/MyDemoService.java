package com.example.selflearning;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class MyDemoService extends Service {
    Thread thread;

    public MyDemoService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                Thread thisThread = Thread.currentThread();
                while(thread == thisThread) {
                    Message msg = new Message();
                    msg.arg1 = 1;
                    handler.sendMessage(msg);
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thread = null;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.arg1==1) {
                Toast.makeText(MyDemoService.this, "Service Running", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
}
