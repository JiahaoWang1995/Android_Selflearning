package com.example.selflearning;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemo extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids = {R.id.view_pager_point1, R.id.view_pager_point2};
    private Button btnHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        setTitle(getIntent().getStringExtra("title"));

        initViews();
        initDots();

    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.view_pager_one, null));
        views.add(inflater.inflate(R.layout.view_pager_two, null));
        viewPagerAdapter = new ViewPagerAdapter(views, this);
        viewPager = findViewById(R.id.my_view_pager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(this);


        btnHello = views.get(1).findViewById(R.id.btn_hello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPagerDemo.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initDots() {
        dots = new ImageView[views.size()];
        for (int i=0; i<views.size();i++) {
            dots[i] = findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        for (int m=0; m<ids.length; m++){
            if (i==m) {
                dots[m].setImageResource(R.drawable.login_point_selected);
            } else {
                dots[m].setImageResource(R.drawable.login_point);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
