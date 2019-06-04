package com.example.selflearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutWithoutXML extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        for (int i=0; i<5;i++) {
            btn = new Button(this);
            btn.setText(String.format("Button %d: Kill Me!!!", i+1));
            btn.setOnClickListener(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.addView(btn, lp);
        }
    }

    @Override
    public void onClick(View v) {
        linearLayout.removeView(v);
    }
}
