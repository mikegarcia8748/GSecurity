package org.rmj.guanzongroup.appdriver.Api;

import android.app.Application;

import org.rmj.guanzongroup.appdriver.Config.AppConfig;

public class APIAddress {
    private static final String TAG = APIAddress.class.getSimpleName();

    private static final String LIVE_DATA = "";
    private static final String LOCAL_DATA = "";

    private final Application instance;

    public final AppConfig poConfig;

    private static final String IMPORT_ITINERARY = "";

    public APIAddress(Application instance, AppConfig poConfig) {
        this.instance = instance;
        this.poConfig = poConfig;
    }


}
