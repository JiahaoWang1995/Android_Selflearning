package com.example.selflearning;

import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class PreferenceActivityDemo extends PreferenceActivity {

    private PreferenceManager manager;
    private CheckBoxPreference checkBoxPreference;
    private ListPreference listPreference;
    private EditTextPreference editTextPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_preference_demo);
        setTitle(getIntent().getStringExtra("title"));

        manager = getPreferenceManager();

        checkBoxPreference = (CheckBoxPreference) manager
                .findPreference("Checkbox");
        Toast.makeText(PreferenceActivityDemo.this,
                "The current status is "+checkBoxPreference.isChecked(),
                Toast.LENGTH_SHORT).show();

        listPreference = (ListPreference) manager
                .findPreference("List");
        Toast.makeText(PreferenceActivityDemo.this,
                listPreference.getEntry()+" uses "+listPreference.getValue(),
                Toast.LENGTH_SHORT).show();

        editTextPreference = (EditTextPreference) manager
                .findPreference("Edittext");
        Toast.makeText(PreferenceActivityDemo.this,
                "I know you want "+editTextPreference.getText(),
                Toast.LENGTH_SHORT).show();


    }
}
