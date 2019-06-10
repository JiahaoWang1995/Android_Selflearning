package com.example.selflearning;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContentProviderDemo extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_demo);
        setTitle(getIntent().getStringExtra("title"));

        btnWrite = findViewById(R.id.btn_write_db);
        btnWrite.setOnClickListener(this);
        editText = findViewById(R.id.write_db_value);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_write_db:
                write();
                break;
        }
    }

    private void write() {
        ContentValues values = new ContentValues();
        values.put("name", editText.getText().toString());
        getContentResolver().insert(MyContentProvider.uri, values);
    }
}
