package com.example.selflearning;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDemo extends AppCompatActivity implements View.OnClickListener {
    public static final Integer NOTIFICATION_ID = 4187;
    public static final String CHANNEL_ID = "mynotification";
    private Button btnShowNotification;
    private NotificationManager notificationManager;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        setTitle(getIntent().getStringExtra("title"));
        btnShowNotification = findViewById(R.id.show_notification);
        btnShowNotification.setOnClickListener(this);
        createNotificationChannel();
        count = 0;

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        CharSequence name = getString(R.string.channel_name);
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name,
                importance);
        channel.setDescription(description);
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_notification:
                count++;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        NotificationDemo.this, CHANNEL_ID);
                builder.setSmallIcon(R.drawable.ic_actionbar_setting_dark);
                builder.setContentTitle("This is "+count+" text Notification");
                builder.setContentText("This is the description of the Notification");
                Notification notification = builder.build();
//                notificationManager = getSystemService(NotificationManager.class);
                notificationManager.notify(NOTIFICATION_ID, notification);
                break;
        }
    }
}
