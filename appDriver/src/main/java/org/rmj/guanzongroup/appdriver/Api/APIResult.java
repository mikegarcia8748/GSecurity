package org.rmj.guanzongroup.appdriver.Api;

import org.json.JSONObject;

public class APIResult {

    public static String SERVER_NO_RESPONSE = "Apologies, the server is not responding at the moment. Please try again later.";
    public static String NOT_CONNECTED = "Connectivity required. Please enable WiFi or enable mobile data to proceed.";
    public static String UNABLE_TO_REACH_LOCAL = "We're experiencing difficulties reaching the local server. Please ensure it is accessible and try again.";
    public static String UNABLE_TO_REACH_SERVER = "We're unable to establish a connection with our servers at the moment. Please check your internet connection and try again.";

    public static String getErrorMessage(JSONObject jsonError) throws Exception{
        String lsCode = jsonError.getString("code");
        switch (lsCode){
            default:
                return jsonError.getString("message");
        }
    }
}
