package org.rmj.guanzongroup.appdriver.Lib.Account;

import android.content.Context;
import android.content.SharedPreferences;

public class AccountSession {
    private static final String TAG = AccountSession.class.getSimpleName();

    private final SharedPreferences pref;

    private final SharedPreferences.Editor editor;

    private static final String CONFIG_NAME = "GAccountSession";

    private static AccountSession mAppConfigPreference;

    private static final String USER_ID = "sUserIDxx";
    private static final String CLIENT_ID = "sClientID";
    private static final String LOG_NUMBER = "sLogNoxxx";
    private static final String LOG_IN = "cIsLoginx";

    private AccountSession(Context context){
        int priv_Mode = 0;
        pref = context.getSharedPreferences(CONFIG_NAME, priv_Mode);
        editor = pref.edit();
    }

    public static AccountSession getInstance(Context context){
        if(mAppConfigPreference == null){
            mAppConfigPreference = new AccountSession(context);
        }
        return mAppConfigPreference;
    }

    public void setUserID(String val){
        editor.putString(USER_ID, val);
        editor.commit();
    }
    public void setClientID(String val){
        editor.putString(CLIENT_ID, val);
        editor.commit();
    }
    public void setLogNumber(String val){
        editor.putString(LOG_NUMBER, val);
        editor.commit();
    }
    public void setLogIn(boolean val){
        editor.putBoolean(LOG_IN, val);
        editor.commit();
    }

    public String getUserID(){
        return pref.getString(USER_ID, "");
    }
    public String getClientID(){
        return pref.getString(CLIENT_ID, "");
    }
    public String getLogNumber(){
        return pref.getString(LOG_NUMBER, "");
    }
    public boolean isLogIn(){
        return pref.getBoolean(LOG_IN, false);
    }

}
