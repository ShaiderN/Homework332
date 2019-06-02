package com.example.homework332;

import android.content.Intent;

public class Utils
{
    private static int sTheme;

    public final static int THEME_BLACK = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_GREEN = 2;

    public static void changeToTheme(MainActivity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(MainActivity activity)
    {
        switch (sTheme)
        {
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
}