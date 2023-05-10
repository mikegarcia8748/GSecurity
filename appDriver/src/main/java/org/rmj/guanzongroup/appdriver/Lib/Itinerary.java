package org.rmj.guanzongroup.appdriver.Lib;

import android.app.Application;

public class Itinerary {
    private static final String TAG = Itinerary.class.getSimpleName();

    private final Application instance;

    public Itinerary(Application instance) {
        this.instance = instance;
    }
}
