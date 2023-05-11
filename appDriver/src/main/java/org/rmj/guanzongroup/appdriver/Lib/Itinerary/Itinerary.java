package org.rmj.guanzongroup.appdriver.Lib.Itinerary;

import android.app.Application;

public class Itinerary {
    private static final String TAG = Itinerary.class.getSimpleName();

    private final Application instance;

    private String message;

    public Itinerary(Application instance) {
        this.instance = instance;
    }

    public boolean DownloadItinerary(){
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }


}
