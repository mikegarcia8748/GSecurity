package org.rmj.guanzongroup.appdriver.Config;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {
    private static final String TAG = AppConfig.class.getSimpleName();

    private final SharedPreferences pref;

    private final SharedPreferences.Editor editor;

    private static AppConfig mAppConfig;

    private static final String CONFIG_NAME = "GSysConfig";

    private static final String TEST_CASE = "cTestingx";
    private static final String PRODUCT_ID = "sProdctID";
    private static final String MOBILE_NO = "sMobileNo";
    private static final String DEVICE_ID = "sDeviceID";
    private static final String APP_TOKEN = "sAppToken";

    private AppConfig(Context context){
        int priv_Mode = 0;
        pref = context.getSharedPreferences(CONFIG_NAME, priv_Mode);
        editor = pref.edit();
    }

    public static AppConfig getInstance(Context context){
        if(mAppConfig == null){
            mAppConfig = new AppConfig(context);
        }
        return mAppConfig;
    }

    public void setTestCase(boolean val){
        editor.putBoolean(TEST_CASE, val);
        editor.commit();
    }

    public boolean isTesting(){
        return pref.getBoolean(TEST_CASE, false);
    }

    public void setProductID(String val){
        editor.putString(PRODUCT_ID, val);
        editor.commit();
    }

    public String getProductID(){
        return pref.getString(PRODUCT_ID, "gRider");
    }

    public void setMobileNO(String val){
        editor.putString(MOBILE_NO, val);
        editor.commit();
    }

    public String getMobileNo(){
        return pref.getString(MOBILE_NO, "");
    }

    public void setDeviceID(String val){
        editor.putString(DEVICE_ID, val);
        editor.commit();
    }

    public String getDeviceID(){
        return pref.getString(DEVICE_ID, "");
    }

    public void setAppToken(String val){
        editor.putString(APP_TOKEN, val);
        editor.commit();
    }

    public String getAppToken(){
        return pref.getString(APP_TOKEN, "");
    }
}
