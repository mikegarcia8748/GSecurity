package org.rmj.guanzongroup.appdriver.Lib.NFC;

import android.app.Application;

public class NfcMaster {
    private static final String TAG = NfcMaster.class.getSimpleName();

    private final Application instance;

    public NfcMaster(Application instance) {
        this.instance = instance;
    }
}
