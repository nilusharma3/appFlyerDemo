package com.example.anil.appflyerdemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;

import java.util.Map;

/**
 * Created by anil on 2/22/18.
 */
public final class AppFlyerEventHandler {

    //DELETE THESE BELOW DURING IMPLEMENTATION USE YOUT OWN EVENTS
    // just event name can be defined separately in an interface or class or can be given directly
    // prefer event name in lower case and less than 45 in length
    public static String EVENT_A = "evnt_a_both removed";
    public static String EVENT_B = "event_b_both_removed";
    public static String EVENT_C = "CCCC";
    public static String EVENT_A1 = "A1aaaaaa";
    public static String EVENT_A2 = "event_a2_expppp!";

    private static Application mApplication;

    /**
     * to initalise appFlyer sdk
     *
     * @param application instance of application
     */
    public static void init(final Application application) {
        mApplication = application;

        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {
            @Override
            public void onInstallConversionDataLoaded(final Map<String, String> map) {

            }

            @Override
            public void onInstallConversionFailure(final String s) {

            }

            @Override
            public void onAppOpenAttribution(final Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(final String s) {

            }
        };
        AppsFlyerLib.getInstance().init(BuildConfig.APP_FLYER_KEY,
                conversionListener, application.getApplicationContext());
        AppsFlyerLib.getInstance().startTracking(application);
    }


    /**
     * this method triggers the event and that event is logged on app flyer's dashboard
     * <p>
     * for evenName app flyer provide a predefined set of events
     * in AFInAppEventParameterName interface
     *
     * @param eventName name of the event
     * @param eventData data to be sent to app flyer with event bundled in map
     */
    public static void logAppFlyerEvent(final String eventName,
                                        final Map<String, Object> eventData) {
        AppsFlyerLib.getInstance().trackEvent(mApplication.getApplicationContext(), eventName, eventData);
    }

}
