package org.rmj.guanzongroup.appdriver.Lib.Account.Pojo;

public class LoginCredentials {

    private final String sUserName;
    private final String sPassword;
    private final String sMobileNo;

    public LoginCredentials(String UserName, String Password, String MobileNo) {
        this.sUserName = UserName;
        this.sPassword = Password;
        this.sMobileNo = MobileNo;
    }

    public String getUserName() {
        return sUserName;
    }

    public String getPassword() {
        return sPassword;
    }

    public String getMobileNo() {
        return sMobileNo;
    }
}
