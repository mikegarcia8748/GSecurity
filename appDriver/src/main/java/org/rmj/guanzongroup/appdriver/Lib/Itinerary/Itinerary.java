package org.rmj.guanzongroup.appdriver.Lib.Itinerary;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.rmj.guanzongroup.appdriver.Lib.Auth.Entity.EItinerary;

import java.util.List;

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

    public LiveData<List<EItinerary>> GetItinerary(){
        return null;
    }
}
