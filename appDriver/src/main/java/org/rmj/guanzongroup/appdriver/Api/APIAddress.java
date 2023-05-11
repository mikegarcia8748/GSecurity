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

    private static APIAddress mApi;

    private APIAddress(Application instance) {
        this.instance = instance;
        this.poConfig = AppConfig.getInstance(instance);
    }

    public static APIAddress getInstance(Application instance){
        if(mApi == null){
            mApi = new APIAddress(instance);
        }

        return mApi;
    }

    public String getAuthentication(){
        if(!poConfig.isTesting()){
            return LIVE_DATA + IMPORT_ITINERARY;
        }
        return LOCAL_DATA + IMPORT_ITINERARY;
    }
}
