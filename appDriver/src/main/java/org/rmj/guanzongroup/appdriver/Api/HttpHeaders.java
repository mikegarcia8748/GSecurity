/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */

package org.rmj.guanzongroup.appdriver.Api;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import org.rmj.guanzongroup.appdriver.Config.AppConfig;
import org.rmj.guanzongroup.appdriver.Etc.SQLUtil;
import org.rmj.guanzongroup.appdriver.Etc.SecUtil;
import org.rmj.guanzongroup.appdriver.Etc.Telephony;
import org.rmj.guanzongroup.appdriver.Lib.Account.AccountSession;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HttpHeaders {
    private static final String TAG = HttpHeaders.class.getSimpleName();

    private final Telephony poTlphony;
    private final AppConfig poConfigx;
    private final AccountSession poSession;

    private HttpHeaders(Context application){
        this.poTlphony = new Telephony(application);
        this.poConfigx = AppConfig.getInstance(application);
        this.poSession = AccountSession.getInstance(application);
    }

    private static HttpHeaders mHeaders;

    public static HttpHeaders getInstance(Application application){
        if(mHeaders == null){
            mHeaders = new HttpHeaders(application);
        }
        return mHeaders;
    }

    public static HttpHeaders getInstance(Context application){
        if(mHeaders == null){
            mHeaders = new HttpHeaders(application);
        }
        return mHeaders;
    }

    private Map<String, String> initHttpHeaders() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Calendar calendar = Calendar.getInstance();

        String lsUserIDx = poSession.getUserID();
        String lsClientx = poSession.getClientID();
        String lsLogNoxx = poSession.getLogNumber();
        String lsTokenxx = poConfigx.getAppToken();
        String lsProduct = poConfigx.getProductID();
        String lsDevcIDx = poTlphony.getDeviceID();
        String lsDateTme = SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss");
        String lsDevcMdl = Build.MODEL;
        String lsMobileN = poConfigx.getMobileNo();

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", lsProduct);
        headers.put("g-api-client", lsClientx);
        headers.put("g-api-imei", lsDevcIDx);
        headers.put("g-api-model", lsDevcMdl);
        headers.put("g-api-mobile", lsMobileN);
        headers.put("g-api-token", lsTokenxx);
        headers.put("g-api-user", lsUserIDx);
        headers.put("g-api-key", lsDateTme);
        String hash_toLower = SecUtil.md5Hex(headers.get("g-api-imei") + headers.get("g-api-key"));
        hash_toLower = hash_toLower.toLowerCase();
        headers.put("g-api-hash", hash_toLower);
        headers.put("g-api-log", lsLogNoxx);
        return headers;
    }

    private Map<String, String> initTestHeaders() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Calendar calendar = Calendar.getInstance();


        String lsUserIDx = poSession.getUserID();
        String lsClientx = poSession.getClientID();
        String lsLogNoxx = poSession.getLogNumber();
        String lsTokenxx = "f7qNSw8TRPWHSCga0g8YFF:APA91bG3i_lBPPWv9bbRasNzRH1XX1y0vzp6Ct8S_a-yMPDvSmud8FEVPMr26zZtBPHq2CmaIw9Rx0MZmf3sbuK44q3vQemUBoPPS4Meybw8pnTpcs3p0VbiTuoLHJtdncC6BgirJxt3";
        String lsProduct = "gRider";
        String lsDevcIDx = poTlphony.getDeviceID();
        String lsDateTme = SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss");
        String lsDevcMdl = Build.MODEL;
        String lsMobileN = "09171870011";

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("g-api-id", lsProduct);
        headers.put("g-api-client", lsClientx);
        headers.put("g-api-imei", lsDevcIDx);
        headers.put("g-api-model", lsDevcMdl);
        headers.put("g-api-mobile", lsMobileN);
        headers.put("g-api-token", lsTokenxx);
        headers.put("g-api-user", lsUserIDx);
        headers.put("g-api-key", lsDateTme);
        String hash_toLower = SecUtil.md5Hex(headers.get("g-api-imei") + headers.get("g-api-key"));
        hash_toLower = hash_toLower.toLowerCase();
        headers.put("g-api-hash", hash_toLower);
        headers.put("g-api-log", lsLogNoxx);
        return headers;
    }

    public HashMap<String, String> getHeaders(){
        if(!poConfigx.isTesting()) {
            return (HashMap<String, String>) initHttpHeaders();
        }
        return (HashMap<String, String>) initTestHeaders();
    }
}
