package org.rmj.guanzongroup.appdriver.Lib.Auth;

import android.app.Application;

import org.rmj.guanzongroup.appdriver.Lib.Auth.Model.GAccount;
import org.rmj.guanzongroup.appdriver.Lib.Auth.Pojo.Obj.Authentication;
import org.rmj.guanzongroup.appdriver.Lib.Auth.Pojo.Obj.CreateAccount;
import org.rmj.guanzongroup.appdriver.Lib.Auth.Pojo.Obj.ForgotPassword;

public class Account {
    private static final String TAG = Account.class.getSimpleName();

    public enum TYPE{
        LOGIN,
        FORGOT_PASSWORD,
        CREATE_ACCOUNT
    }

    public static GAccount Initialize(Application instance, TYPE type){
        switch (type){
            case LOGIN:
                return new Authentication(instance);
            case CREATE_ACCOUNT:
                return new CreateAccount(instance);
            default:
                return new ForgotPassword(instance);

        }
    }
}
