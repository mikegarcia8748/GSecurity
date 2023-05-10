package org.rmj.guanzongroup.appdriver.Config;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {
    private static final String TAG = AppConfig.class.getSimpleName();

    private final SharedPreferences pref;

    private final SharedPreferences.Editor editor;

    private static AppConfig mAppConfigPreference;

    private static final String CONFIG_NAME = "GSysConfig";

    private static final String TEST_CASE = "cTestingx";

    private AppConfig(Context context){
        int priv_Mode = 0;
        pref = context.getSharedPreferences(CONFIG_NAME, priv_Mode);
        editor = pref.edit();
    }

    public static AppConfig getInstance(Context context){
        if(mAppConfigPreference == null){
            mAppConfigPreference = new AppConfig(context);
        }
        return mAppConfigPreference;
    }

    public void setTestCase(boolean val){
        editor.putBoolean(TEST_CASE, val);
        editor.commit();
    }

    public boolean isTesting(){
        return pref.getBoolean(TEST_CASE, false);
    }
}
