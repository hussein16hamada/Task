package com.example.task.base;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;


public class MyApplication extends Application {
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();

    }
    public static Context getAppContext() {
        return MyApplication.context;
    }


    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


}
