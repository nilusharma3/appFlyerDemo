package com.example.anil.appflyerdemo;

import android.app.Application;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.ConversionDataListener;

import java.util.Map;

/**
 * Created by anil on 2/22/18.
 */

public class GlobalClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //initialise app flyer event sdk
        AppFlyerEventHandler.init(this);
    }


}

