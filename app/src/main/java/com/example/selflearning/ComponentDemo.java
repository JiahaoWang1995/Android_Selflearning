package com.example.selflearning;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;


public class ComponentDemo extends AppCompatActivity implements View.OnClickListener {
    private Button btnDatePicker;
    private Button btnTimePicker;
    private RadioButton btnChoiceA;
    private RadioButton btnChoiceB;
    private RadioButton btnChoiceC;
    private Button btnSubmit;
    private Button btnMultiSubmit;
    private CheckBox choiceA;
    private CheckBox choiceB;
    private CheckBox choiceC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_demo);
        String title = getIntent().getStringExtra("title");
        setTitle(title);

        btnDatePicker = findViewById(R.id.btn_date_picker);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker = findViewById(R.id.btn_time_picker);
        btnTimePicker.setOnClickListener(this);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        btnChoiceA = findViewById(R.id.radio_choiceA);
        btnChoiceB = findViewById(R.id.radio_choiceB);
        btnChoiceC = findViewById(R.id.radio_choiceC);
        btnMultiSubmit = findViewById(R.id.btn_multi_submit);
        btnMultiSubmit.setOnClickListener(this);
        choiceA = findViewById(R.id.multi_choiceA);
        choiceB = findViewById(R.id.multi_choiceB);
        choiceC = findViewById(R.id.multi_choiceC);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_date_picker:
                new DatePickerDialog(ComponentDemo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btnDatePicker.setText(String.format("%d-%d-%d", year, month+1, dayOfMonth));
                    }
                }, 2019, 5, 4).show();
                break;
            case R.id.btn_time_picker:
                new TimePickerDialog(ComponentDemo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btnTimePicker.setText(String.format("%d:%d", hourOfDay, minute));
                    }
                }, 23, 59, true).show();
                break;
            case R.id.btn_submit:
                    if (btnChoiceA.isChecked()) {
                        Toast.makeText(this,
                                "You choose "+btnChoiceA.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    } else if (btnChoiceB.isChecked()) {
                        Toast.makeText(this,
                                "You choose "+btnChoiceB.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    } else if (btnChoiceC.isChecked()) {
                        Toast.makeText(this,
                                "You choose "+btnChoiceC.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                break;
            case R.id.btn_multi_submit:
                Toast.makeText(this,
                        "You choose "+(choiceA.isChecked()?choiceA.getText().toString()+" ":"")
                                +(choiceB.isChecked()?choiceB.getText().toString()+" ":"")
                                +(choiceC.isChecked()?choiceC.getText().toString()+" ":""),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
