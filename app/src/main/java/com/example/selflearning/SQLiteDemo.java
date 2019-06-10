package com.example.selflearning;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SQLiteDemo extends ListActivity {
    MyDatabase myDatabase;
    private SimpleCursorAdapter adapter;
    private Button btnSubmit;
    private EditText etName;
    private RadioButton male;
    private RadioButton female;
    private SQLiteDatabase dbRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);
        setTitle(getIntent().getStringExtra("title"));

        btnSubmit = findViewById(R.id.btn_submit);
        etName = findViewById(R.id.edittext_name);
        male = findViewById(R.id.radio_male);
        female = findViewById(R.id.radio_female);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String sex = "";
                if (male.isChecked()) {
                    sex = "male";
                } else if (female.isChecked()) {
                    sex = "female";
                }
                if (!sex.equals("")) {
                    Toast.makeText(SQLiteDemo.this, "Saved!", Toast.LENGTH_SHORT).show();
                    SQLiteDatabase dbWrite = myDatabase.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", name);
                    contentValues.put("sex", sex);
                    dbWrite.insert("user", null, contentValues);
                    dbWrite.close();
                    refreshListView();

                }
            }
        });

        myDatabase = new MyDatabase(this);


        dbRead = myDatabase.getReadableDatabase();
        Cursor cursor = dbRead.query("user", null,
                "sex=?", new String[]{"male"}, null,
                null, null);
        adapter = new SimpleCursorAdapter(this,
                R.layout.simple_cursor_adapter_layout, cursor,
                new String[]{"name", "sex"},
                new int[]{R.id.name, R.id.sex});
        setListAdapter(adapter);
    }

    private void refreshListView() {
        dbRead = myDatabase.getReadableDatabase();
        Cursor cursor = dbRead.query("user", null,
                "sex=?", new String[]{"male"}, null,
                null, null);
        adapter.changeCursor(cursor);
    }

    @Override
    protected void onDestroy() {
        dbRead.close();
        super.onDestroy();
    }
}
