package com.example.selflearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutAnimationDemo extends AppCompatActivity implements View.OnClickListener {
    private Button btnCreate;
    LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation_demo);
        setTitle(getIntent().getStringExtra("title"));

        btnCreate = findViewById(R.id.btn1);
        btnCreate.setOnClickListener(this);

        rootView = findViewById(R.id.layout_animation);
//        LayoutAnimationController layoutAnimationController =
//                new LayoutAnimationController(
//                        AnimationUtils.loadAnimation(
//                                this, R.anim.trans_animation
//                        ), 0.1f);
//        rootView.setLayoutAnimation(layoutAnimationController);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                addButton();
                break;
        }
    }

    private void addButton() {
        Button btn = new Button(this);
        btn.setText("Remove Me!");
        rootView.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootView.removeView(v);
            }
        });
    }
}
