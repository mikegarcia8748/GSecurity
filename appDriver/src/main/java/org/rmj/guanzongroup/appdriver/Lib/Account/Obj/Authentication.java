package org.rmj.guanzongroup.appdriver.Lib.Account.Obj;

import android.app.Application;

import org.rmj.guanzongroup.appdriver.Lib.Account.Model.GAccount;

public class Authentication implements GAccount {

    private final Application instance;

    private String message;

    public Authentication(Application instance) {
        this.instance = instance;
    }

    @Override
    public int DoAction(Object args) {
        try{
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return 0;
        }
    }

    @Override
    public String getMessage() {
        return message;
    }
}
