package org.rmj.guanzongroup.appdriver.Lib.Account.Obj;

import android.app.Application;

import org.rmj.guanzongroup.appdriver.Lib.Account.Model.GAccount;

public class CreateAccount implements GAccount {


    private final Application instance;

    public CreateAccount(Application instance) {
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
