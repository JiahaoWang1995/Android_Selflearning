package com.example.selflearning;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class ActionBarDemo extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_demo);
        setTitle(getIntent().getStringExtra("title"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.img1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_demo, menu);
         MenuItem shareItem = menu.findItem(R.id.actionbar_share);
         shareActionProvider = MenuItemCompat.getActionProvider(shareItem);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionbar_search:
                Toast.makeText(this, "Search button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionbar_setting:

                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.actionbar_share:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
