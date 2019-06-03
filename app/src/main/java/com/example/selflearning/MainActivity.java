package com.example.selflearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.trans_with_serializable) {
            Intent intent = new Intent(MainActivity.this, SerializableDemoActivity.class);
            intent.putExtra("Serializable", new PeopleSerializable("Frank", 24));
            startActivity(intent);
            return true;
        } else if (id == R.id.trans_with_parcelable) {
            Intent intent = new Intent(MainActivity.this, ParcelableDemoActivity.class);
            intent.putExtra("Parcelable", new PeopleParcelable("Roxanne", 24));
            startActivity(intent);
            return true;
        } else if (id == R.id.activity_return) {
            Intent intent = new Intent(MainActivity.this, ActivityReturnDemo.class);
//            startActivity(intent);
            startActivityForResult(intent, 0);
        } else if (id == R.id.call_multi_activities) {
            try {
                Intent intent = new Intent("com.example.selflearning.intent.action.DemoActivity");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Can not start this Activity", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.application_share_data) {
            Intent intent = new Intent(MainActivity.this, ShareDataDemoA.class);
            startActivity(intent);
        } else if (id == R.id.service_demo) {
            Intent intent = new Intent(MainActivity.this, ServiceDemoActivity.class);
            startActivity(intent);
        } else if (id == R.id.bind_service_demo) {
            Intent intent = new Intent(MainActivity.this, BindService.class);
            startActivity(intent);
        } else if(id == R.id.aidl_service) {
            Intent intent = new Intent(MainActivity.this, CallOtherAppService.class);
            startActivity(intent);
        } else if (id == R.id.broadcast_receiver_demo) {
            Intent intent = new Intent(MainActivity.this, BroadcastReceiverDemo.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0&&resultCode==1) {
            CharSequence text = "Return value detected: "+data.getStringExtra("data");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
