package org.rmj.guanzongroup.appdriver.Etc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppConstants {

    private static final String LOCAL_MESSAGE = "We apologize for the inconvenience. An error has occurred during the processing of your request";

    public static String CURRENT_DATE(){
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    public static String DATE_MODIFIED(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    public static String getLocalMessage(Exception val){
        return LOCAL_MESSAGE + "\n \n" + val.getMessage();
    }
}
