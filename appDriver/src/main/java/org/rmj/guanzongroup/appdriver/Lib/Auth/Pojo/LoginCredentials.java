package org.rmj.guanzongroup.appdriver.Lib.Auth.Pojo;

public class LoginCredentials {

    private final String sUserName;
    private final String sPassword;
    private final String sMobileNo;

    private String message;

    public LoginCredentials(String UserName, String Password, String MobileNo) {
        this.sUserName = UserName;
        this.sPassword = Password;
        this.sMobileNo = MobileNo;
    }

    public String getMessage() {
        return message;
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

    public boolean isDataValid(){
        if(!isEmailValid()){
            return false;
        }
        if(!isPasswordValid()){
            return false;
        }
        return isMobileNoValid();
    }

    private boolean isEmailValid(){
        if(sUserName.isEmpty()){
            message = "Please enter your email";
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(){
        if(sPassword.isEmpty()) {
            message = "Please enter password";
            return false;
        }
        return true;
    }

    private boolean isMobileNoValid(){
        if(sMobileNo.isEmpty()){
            message = "Please enter mobile no.";
            return false;
        }
        if(sMobileNo.length()!=11){
            message = "Mobile number must be 11 characters";
            return false;
        }
        if(!sMobileNo.substring(0, 2).equalsIgnoreCase("09")){
            message = "Mobile number must start with '09'";
            return false;
        }
        return true;
    }
}
