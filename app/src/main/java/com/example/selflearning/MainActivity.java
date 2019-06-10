package com.example.selflearning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Self Learning TAG";
    Boolean isFirstIn = false;
    SharedPreferences sharedPreferences;

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
        init();

        findViewById(R.id.btn_reset_viewpager_flag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isFirstIn", true);
                editor.commit();
            }
        });

        findViewById(R.id.btn_image_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast imageToast = Toast.makeText(MainActivity.this, "This is a toast with image", Toast.LENGTH_LONG);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.oneplus);
                imageToast.setView(imageView);
                imageToast.setGravity(Gravity.CENTER, 0, 0);
                imageToast.show();
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
            intent.putExtra("title", item.getTitle());
            intent.putExtra("Serializable", new PeopleSerializable("Frank", 24));
            startActivity(intent);
            return true;
        } else if (id == R.id.trans_with_parcelable) {
            Intent intent = new Intent(MainActivity.this, ParcelableDemoActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("Parcelable", new PeopleParcelable("Roxanne", 24));
            startActivity(intent);
            return true;
        } else if (id == R.id.activity_return) {
            Intent intent = new Intent(MainActivity.this, ActivityReturnDemo.class);
            intent.putExtra("title", item.getTitle());
//            startActivity(intent);
            startActivityForResult(intent, 0);
        } else if (id == R.id.call_multi_activities) {
            try {
                Intent intent = new Intent("com.example.selflearning.intent.action.DemoActivity");
                intent.putExtra("title", item.getTitle());
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Can not start this Activity", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.application_share_data) {
            Intent intent = new Intent(MainActivity.this, ShareDataDemoA.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.service_demo) {
            Intent intent = new Intent(MainActivity.this, ServiceDemoActivity.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.bind_service_demo) {
            Intent intent = new Intent(MainActivity.this, BindService.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if(id == R.id.aidl_service) {
            Intent intent = new Intent(MainActivity.this, CallOtherAppService.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.broadcast_receiver_demo) {
            Intent intent = new Intent(MainActivity.this, BroadcastReceiverDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.tabbed_demo) {
            Intent intent = new Intent(MainActivity.this, TabbedActivity.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.framelayout_demo) {
            Intent intent = new Intent(MainActivity.this, FramelayoutActivity.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.layout_from_code) {
            Intent intent = new Intent(MainActivity.this, LayoutWithoutXML.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.component_demo) {
            Intent intent = new Intent(MainActivity.this, ComponentDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.animation_demo) {
            Intent intent = new Intent(MainActivity.this, AnimationDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.layout_animation_demo) {
            Intent intent = new Intent(MainActivity.this, LayoutAnimationDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.view_pager_demo) {
            isFirstIn = sharedPreferences.getBoolean("isFirstIn", true);
            if (isFirstIn) {
                Intent intent = new Intent(MainActivity.this, ViewPagerDemo.class);
                intent.putExtra("title", item.getTitle());
                startActivity(intent);
                isFirstIn = false;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isFirstIn", isFirstIn);
                editor.commit();
            } else {
                Toast.makeText(this, "Not the first time in the ViewPagerDemo", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.action_bar_demo) {
            Intent intent = new Intent(MainActivity.this, ActionBarDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.notification_demo) {
            Intent intent = new Intent(MainActivity.this, NotificationDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.sharedpreference_demo) {
            Intent intent = new Intent(MainActivity.this, SharedPreferenceDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.preference_demo) {
            Intent intent = new Intent(MainActivity.this, PreferenceActivityDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.sql_demo) {
            Intent intent = new Intent(MainActivity.this, SQLiteDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.content_provider_demo) {
            Intent intent = new Intent(MainActivity.this, ContentProviderDemo.class);
            intent.putExtra("title", item.getTitle());
            startActivity(intent);
        } else if (id == R.id.json_demo) {
            Intent intent = new Intent(MainActivity.this, JSONDemo.class);
            intent.putExtra("title", item.getTitle());
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

    private void init() {
        sharedPreferences = getSharedPreferences("Database", MODE_PRIVATE);
        isFirstIn = sharedPreferences.getBoolean("isFirstIn", true);
    }
}
