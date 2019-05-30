package com.example.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
    private static int sTheme;

    public final static int THEME_BLACK = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_GREEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        onActivityCreateSetTheme(this);
    }

    private void initViews() {
        languageSpinner = findViewById(R.id.chooseLangSpinner);
        coloursSpinner = findViewById(R.id.chooseColourSpinner);
        btnOk = findViewById(R.id.buttonOk);
        initLanguageSpinner();
        initColoursSpinner();
    }

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_BLACK:
                activity.setTheme(R.style.AppThemeBlack);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppThemeBlue);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.AppThemeGreen);
                break;
        }
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

    private void interfaceLanguage(String language) {
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
                        changeToTheme(this, THEME_BLACK);
                    }
                });
                break;
            case "Синий" :
            case "Blue" :
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
            case "Зелёный" :
            case "Green" :
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
        }
    }
}