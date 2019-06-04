package com.example.selflearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FramelayoutActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    FrameLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);
        String title = getIntent().getStringExtra("title");
        setTitle(title);

        root = findViewById(R.id.framelayout_root);
        img1 = findViewById(R.id.framelayout_img1);
        img2 = findViewById(R.id.framelayout_img2);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchVisibility(img1);
                switchVisibility(img2);
            }
        });
    }

    private void switchVisibility(ImageView img) {
        if (img.getVisibility() == View.VISIBLE) {
            img.setVisibility(View.INVISIBLE);
        } else {
            img.setVisibility(View.VISIBLE);
        }
    }
}
