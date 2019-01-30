/*
 * Copyright (c) 2018. Appinventor Inc. All right reserved.
 * Web URL  https://appinventor.co.in
 * Author Name: Vinod Vishwakarma
 * Linked In: https://www.linkedin.com/in/vvishwakarma
 * Email ID: vish.vino@gmail.com
 * Last Modified : 28/7/18 6:23 PM
 */

package in.co.appinventor.appsettings;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AppSettings {


    public static final String PREF_LOGIN_DATA = "PREF_LOGIN_DATA";
    public static final String PREF_USER_ID = "PREF_USER_ID";
    public static final String PREF_SOCIAL_DATA = "PREF_SOCIAL_DATA";
    public static final String PREF_USER_ACTION_TYPE = "PREF_USER_ACTION_TYPE";
    public static final String PREF_IS_LOGIN_DONE = "PREF_IS_LOGIN_DONE";
    public static final String PREF_USER_MOBILE = "PREF_USER_MOBILE";
    public static final String PREF_USER_PROFILE_PIC = "PREF_USER_PROFILE_PIC";
    public static final String PREF_USER_PROFILE_PIC80 = "PREF_USER_PROFILE_PIC80";
    public static final String PREF_USER_PROFILE_PIC500 = "PREF_USER_PROFILE_PIC500";
    public static final String PREF_GCM_TOKEN = "PREF_GCM_TOKEN";
    public static final String PREF_DEVICE_TOKEN = "PREF_DEVICE_TOKEN";
    public static final String PREF_SPLASH_BANNER_DATA = "PREF_SPLASH_BANNER_DATA";
    public static final String PREF_BANNER_DATA = "PREF_BANNER_DATA";
    public static final String PREF_CHANNEL_USER_DATA = "PREF_CHANNEL_USER_DATA";
    public static final String PREF_CHANNEL_DATA = "PREF_CHANNEL_DATA";
    public static final String PREF_PAGE_TOKEN = "PREF_PAGE_TOKEN";
    private static SharedPreferences prefs = null;
    private String APP_SHARED_PREFERENCE_NAME = "in.co.appinventor";
    private static final AppSettings ourInstance = new AppSettings();

    private AppSettings() {

    }

    public static AppSettings getInstance() {
        return ourInstance;
    }

    public void initAppSettings(String sharedPreferenceName) {
        APP_SHARED_PREFERENCE_NAME = "in.co.appinventor" + sharedPreferenceName + "sharedpreference";
    }


    public String getValue(Context context, String key, String defaultValue) {
        isAppSettingInit();

        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getString(key, defaultValue);
    }


    public SharedPreferences getAppSharedPreference(Context context) {
        isAppSettingInit();
        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs;
    }


    public void clearAppSharedData(Context context) {
        isAppSettingInit();
        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        prefs.edit().clear().apply();
    }


    public void setValue(Context context, String key, String value) {
        isAppSettingInit();

        if (value != null && context != null) {
            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(key, value);
            editor.apply();
        }
    }

    public int getIntValue(Context context, String key, int defaultValue) {
        isAppSettingInit();

        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getInt(key, defaultValue);
    }

    public void setIntValue(Context context, String key, int value) {
        isAppSettingInit();
        if (context != null) {
            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt(key, value);
            editor.apply();
        }
    }


    public boolean getBooleanValue(Context context, String key, boolean defaultValue) {
        isAppSettingInit();

        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getBoolean(key, defaultValue);
    }

    public void setBooleanValue(Context context, String key, boolean value) {
        isAppSettingInit();

        if (context != null) {
            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }
    }


    public void setList(Context context, String key, List<Object> value) {
        isAppSettingInit();

        if (context != null) {
            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();

            Gson gson = new Gson();
            String json = gson.toJson(value);

            editor.putString(key, json);
            editor.apply();
        }
    }

    public List<Object> getList(Context context, String key) {
        isAppSettingInit();
        List<Object> productFromShared = new ArrayList<>();

        if (context != null) {

            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);

            Gson gson = new Gson();
            String jsonPreferences = prefs.getString(key, "");
            if (jsonPreferences.length() > 0) {
                Type type = new TypeToken<List<Object>>() {}.getType();
                productFromShared = gson.fromJson(jsonPreferences, type);
            }
        }

        return productFromShared;
    }

    public void setListDates(Context context, String key, List<Date> value) {
        isAppSettingInit();

        if (context != null) {
            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();

            Gson gson = new Gson();
            String json = gson.toJson(value);

            editor.putString(key, json);
            editor.apply();
        }
    }

    public List<Date> getListDates(Context context, String key) {
        isAppSettingInit();
        List<Date> productFromShared = new ArrayList<>();

        if (context != null) {

            prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);

            Gson gson = new Gson();
            String jsonPreferences = prefs.getString(key, "");
            if (jsonPreferences.length() > 0) {
                Type type = new TypeToken<List<Date>>() {}.getType();
                productFromShared = gson.fromJson(jsonPreferences, type);
            }
        }

        return productFromShared;
    }


    private void isAppSettingInit() {
        if (APP_SHARED_PREFERENCE_NAME.equalsIgnoreCase("in.co.appinventor")) {
            try {
                throw new Exception("Please use initAppSettings in application class, Before using the method.  Add your app unique sharedpreference name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public String getSavedValue(Context context, String key) {
        isAppSettingInit();

        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getString(key, key);
    }


    public Set<String> getAutoCompletionData(Context context, String key) {
        isAppSettingInit();

        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getStringSet(key, new HashSet<String>());
    }

    public void setAutoCompletionData(Context context, String key, Set<String> history) {
        isAppSettingInit();

        prefs = context.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(key, history);
        editor.apply();
    }

    //--------
    public String getUserId(Context mContext) {
        isAppSettingInit();

        String key = PREF_USER_ID;
        prefs = mContext.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getString(key, key);
    }

    public String getUserMobile(Context mContext) {
        isAppSettingInit();

        String key = PREF_USER_MOBILE;
        prefs = mContext.getSharedPreferences(APP_SHARED_PREFERENCE_NAME, 0);
        return prefs.getString(key, key);
    }


}