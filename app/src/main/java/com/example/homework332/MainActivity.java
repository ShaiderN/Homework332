package com.example.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Spinner coloursSpinner;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        languageSpinner = findViewById(R.id.chooseLangSpinner);
        coloursSpinner = findViewById(R.id.chooseColourSpinner);
        btnOk = findViewById(R.id.buttonOk);
        initLanguageSpinner();
        initColoursSpinner();
    }

    private void initLanguageSpinner() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguages);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> languageView, View view, int iLang, long lLang) {
                String[] languages = getResources().getStringArray(R.array.languages);
                interfaceLanguage(languages[iLang]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> languageView) {
            }
        });
    }

    public void interfaceLanguage(String language) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (language) {
            case "Русский" :
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Locale locale = new Locale("ru");
                        Configuration config = new Configuration();
                        config.setLocale(locale);
                        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                    }
                });
                break;
            case "English" :
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Locale locale = new Locale("en");
                        Configuration config = new Configuration();
                        config.setLocale(locale);
                        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                    }
                });
                break;
        }

        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            languageSpinner.setAdapter(adapter);
        }
    }

    private void initColoursSpinner() {
        ArrayAdapter<CharSequence> adapterColour = ArrayAdapter.createFromResource(this,
                R.array.colours, android.R.layout.simple_spinner_item);
        adapterColour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coloursSpinner.setAdapter(adapterColour);

        coloursSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> colourView, View view, int iColour, long lColour) {
                String[] colours = getResources().getStringArray(R.array.colours);
                interfaceColour(colours[iColour]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> colourView) {
            }
        });
    }

    private void interfaceColour(String colour) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (colour) {
            case "Чёрный" :
            case "Black" :
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLACK);
                    }
                });
                break;
            case "Синий" :
            case "Blue" :
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                    }
                });
                break;
            case "Зелёный" :
            case "Green" :
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                    }
                });
                break;
        }

        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            languageSpinner.setAdapter(adapter);
        }
    }
}