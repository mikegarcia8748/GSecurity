package org.rmj.guanzongroup.appdriver.Lib.Auth.Obj;

import android.app.Application;

import org.rmj.guanzongroup.appdriver.Lib.Auth.Model.GAccount;

public class ForgotPassword implements GAccount {


    private final Application instance;

    public ForgotPassword(Application instance) {
        this.instance = instance;
    }

    @Override
    public int DoAction(Object args) {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
