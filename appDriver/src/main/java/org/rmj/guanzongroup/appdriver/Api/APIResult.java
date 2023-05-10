package org.rmj.guanzongroup.appdriver.Api;

import org.json.JSONObject;

public class APIResult {

    public static String getMessage(JSONObject foVal) throws Exception{
        return foVal.getString("message");
    }
}
