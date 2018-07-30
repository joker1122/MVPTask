package com.example.dbflow.dbflow;

import android.app.Application;
import android.util.Log;

import com.example.dbflow.R;
import com.raizlabs.android.dbflow.config.FlowManager;

public class Task extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("get", getString(R.string.log));
        FlowManager.init(this);
    }
}
