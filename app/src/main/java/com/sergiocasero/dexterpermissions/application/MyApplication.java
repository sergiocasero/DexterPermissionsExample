package com.sergiocasero.dexterpermissions.application;

import android.app.Application;

import com.karumi.dexter.Dexter;

/**
 * Created by sergiocasero on 26/3/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Dexter.initialize(this);
    }
}
