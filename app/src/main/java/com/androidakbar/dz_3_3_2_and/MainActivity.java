package com.androidakbar.dz_3_3_2_and;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Toolbar appToolbar;
    private Spinner spnLanguage;
    private String selectedLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        appToolbar = findViewById(R.id.app_toolbar);
        appToolbar.setTitle(R.string.name_dz);
        appToolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryText));

        spnLanguage = findViewById(R.id.spn_language);
        initSpnLanguage();

        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale = new Locale(selectedLocal);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });


    }

    private void initSpnLanguage() {
        ArrayAdapter<CharSequence> adpLanguage = ArrayAdapter.createFromResource(MainActivity.this, R.array.sa_language, R.layout.support_simple_spinner_dropdown_item);
        spnLanguage.setAdapter(adpLanguage);

        spnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.sa_language);
                if (languages[i].equals(getResources().getString(R.string.str_name_local_ru))) {
                    selectedLocal = "ru";
                } else {
                    selectedLocal = "en";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}