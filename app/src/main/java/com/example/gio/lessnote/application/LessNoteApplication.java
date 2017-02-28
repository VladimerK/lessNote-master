package com.example.gio.lessnote.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Gio on 10/18/2016.
 */

public class LessNoteApplication extends Application {

    private static LessNoteApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public static LessNoteApplication getInstce() {
        return application;
    }

    //=========================================================================

    public String getSharedString(String key) {
        return getSharedPrefs().getString(key, "");
    }


    public void setSharedString(String key, String value) {
        getSharedPrefs().edit().putString(key, value).commit();
    }

    public int getSharedInt(String key) {
        return getSharedPrefs().getInt(key, 0);
    }

    public void setSharedInt(String key, int value) {
        getSharedPrefs().edit().putInt(key, value).commit();
    }

    public boolean getSharedBoolean(String key){
        return getSharedPrefs().getBoolean(key, false);
    }

    public void setSharedBoolean(String key, boolean value){
        getSharedPrefs().edit().putBoolean(key, value).commit();
    }

    //=========================================================================

    public SharedPreferences getSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

}
