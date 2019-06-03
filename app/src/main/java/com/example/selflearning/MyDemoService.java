package com.example.selflearning;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class MyDemoService extends Service {
//    Thread thread;
    private boolean serviceRunning = false;
    private String data = "Default data";
    private int loopCount = 0;

    public MyDemoService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("service created");
        serviceRunning = true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                loopCount = 0;
//                Thread thisThread = Thread.currentThread();
                while(serviceRunning) {
                    loopCount++;
                    Message msg = new Message();
                    msg.arg1 = 1;
                    String str = data+" loops "+Integer.toString(loopCount)+" times";
                    msg.obj = str;

                    if (callback!=null) {
                        callback.onDataChange(str);
                    }

                    handler.sendMessage(msg);
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new Binder();
    }

    public class Binder extends android.os.Binder{
        public void setData(String data) {
            MyDemoService.this.data = data;
        }

        public MyDemoService getMyDemoService() {
            return MyDemoService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        thread.start();
        System.out.println("service started");
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        thread = null;
        System.out.println("service stopped");
        serviceRunning = false;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.arg1==1) {
                Toast.makeText(MyDemoService.this, (String) msg.obj, Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });

    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public static interface Callback{
        void onDataChange(String data);
    }
}
