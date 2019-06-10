package com.example.selflearning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferenceDemo extends AppCompatActivity implements View.OnClickListener {
    private EditText et;
    private Button btnSave;
    private Button btnLoad;
    private Button btnClear;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String MY_KEY = "Key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_demo);
        setTitle(getIntent().getStringExtra("title"));

        et = findViewById(R.id.save_to_sharedpreference);
        btnSave = findViewById(R.id.btn_save);
        btnLoad = findViewById(R.id.btn_load);
        btnClear = findViewById(R.id.btn_clear);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        sharedPreferences = getPreferences(Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                editor.putString(MY_KEY, et.getText().toString());
                if (editor.commit()) {
                    Toast.makeText(SharedPreferenceDemo.this, "Save sucess", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_load:
                Toast.makeText(SharedPreferenceDemo.this,
                        sharedPreferences.getString(MY_KEY, "Undefined"),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_clear:
                editor.remove(MY_KEY);
                editor.commit();
                break;
        }
    }
}
