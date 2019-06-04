package com.example.selflearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShareDataDemoA extends AppCompatActivity {
    TextView tv;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data_demo);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        tv = findViewById(R.id.textView);
        tv.setText("Shared data is: "+((App)getApplicationContext()).getData());
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplicationContext()).setData(et.getText().toString());
                tv.setText("Shared data is: "+((App)getApplicationContext()).getData());
                Intent intent = new Intent(ShareDataDemoA.this, ShareDataDemoB.class);
                startActivity(intent);
            }
        });
    }
}
