package org.rmj.guanzongroup.appdriver.Lib.Auth.Pojo.Obj;

import static org.rmj.guanzongroup.appdriver.Etc.AppConstants.getLocalMessage;

import android.app.Application;
import android.util.Log;

import org.rmj.guanzongroup.appdriver.Lib.Auth.Model.GAccount;

public class CreateAccount implements GAccount {
    private static final String TAG = CreateAccount.class.getSimpleName();

    private final Application instance;

    private String message;

    public CreateAccount(Application instance) {
        this.instance = instance;
    }

    @Override
    public int DoAction(Object args) {
        try{

        } catch (Exception e){
            e.printStackTrace();
            message = getLocalMessage(e);
            Log.d(TAG, message);
        }
        return 0;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
