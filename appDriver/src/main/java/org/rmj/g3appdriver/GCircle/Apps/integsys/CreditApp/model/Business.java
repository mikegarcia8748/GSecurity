package org.rmj.g3appdriver.GCircle.Apps.integsys.CreditApp.model;

import android.util.Log;

public class Business {

    private String sTransNox = "";
    private String sBussNtrx = "";
    private String sBussName = "";
    private String sBussAddx = "";
    private String sTownName = "";
    private String sBussTown = "";
    private String sBussType = "";
    private String sBussSize = "";
    private double sLenghtSv = 0;
    private String cIsYearxx = "";
    private long sMnthlyIn = 0;
    private long sMnthlyEx = 0;
    private String cMeanInfo = "";

    private String message;

    public Business() {

    }
    public String getMessage() {
        return message;
    }

    public String getMeanInfo() {
        return cMeanInfo;
    }

    public void setMeanInfo(String cMeanInfo) {
        this.cMeanInfo = cMeanInfo;
    }


    public String getTransNox() {
        return sTransNox;
    }

    public void setTransNox(String sTransNox) {
        this.sTransNox = sTransNox;
    }

    public String getNatureOfBusiness() {
        return sBussNtrx;
    }

    public void setNatureOfBusiness(String sBussNtrx) {
        this.sBussNtrx = sBussNtrx;
    }

    public String getNameOfBusiness() {
        return sBussName;
    }

    public void setNameOfBusiness(String sBussName) {
        this.sBussName = sBussName;
    }

    public String getBusinessAddress() {
        return sBussAddx;
    }

    public void setBusinessAddress(String sBussAddx) {
        this.sBussAddx = sBussAddx;
    }

    public String getTownName() {
        return sTownName;
    }

    public void setTownName(String sBussProv) {
        this.sTownName = sBussProv;
    }

    public String getTown() {
        return sBussTown;
    }

    public void setTown(String sBussTown) {
        this.sBussTown = sBussTown;
    }

    public String getTypeOfBusiness() {
        return sBussType;
    }

    public void setTypeOfBusiness(String sBussType) {
        this.sBussType = sBussType;
    }

    public String getSizeOfBusiness() {
        return sBussSize;
    }

    public void setSizeOfBusiness(String sBussSize) {
        this.sBussSize = sBussSize;
    }

    public double getLenghtOfService() {
        if(cIsYearxx.equalsIgnoreCase("0")){
            double ldValue = sLenghtSv;
            return ldValue / 12;
        } else {
            return sLenghtSv;
        }
    }

    public void setLengthOfService(double sLenghtSv) {
        this.sLenghtSv = sLenghtSv;
    }

    public void setIsYear(String sLenghtSv) {
        this.cIsYearxx = sLenghtSv;
    }

    public long getMonthlyIncome() {
        return sMnthlyIn;
    }

    public void setMonthlyIncome(long sMnthlyIn) {
        this.sMnthlyIn = sMnthlyIn;
    }

    public long getMonthlyExpense() {
        return sMnthlyEx;
    }

    public void setMonthlyExpense(long sMnthlyEx) {
        this.sMnthlyEx = sMnthlyEx;
    }

    public boolean isPrimary(){
        if (!cMeanInfo.equalsIgnoreCase("1")){
            return false;
        }
        return true;

    }

    public boolean isDataValid(){
        return isBusinessNatureValid() &&
                isBusinessNameValid() &&
                isBusinessAddressValid() &&
                isTownValid() &&
                isBusinessTypeValid() &&
                isBusinessSizeValid() &&
                isLenghtOfServiceValid() &&
                isMonthlyIncomeValid() &&
                isMonthlyExpenseValid();
    }

    boolean isBusinessNatureValid(){
        if(!sBussNtrx.isEmpty() || !sBussNtrx.equalsIgnoreCase("")) {
            return true;
        } else {
            message = "Please select business nature";
            return false;
        }
    }

    boolean isBusinessNameValid(){
        if(sBussName.trim().isEmpty() || sBussName.trim().equalsIgnoreCase("") || sBussName == null){
            message = "Please enter name of business";
            return false;
        }
        return true;
    }

    boolean isBusinessAddressValid(){
        if(sBussAddx.trim().isEmpty() || sBussAddx.trim().equalsIgnoreCase("") || sBussAddx == null){
            message = "Please enter business address";
            return false;
        }
        return true;
    }

    boolean isTownValid(){
        if(sBussTown.trim().isEmpty() || sBussTown.trim().equalsIgnoreCase( "") || sBussTown == null){
            message = "Please enter municipality address";
            return false;
        }
        return true;
    }

    boolean isBusinessTypeValid(){
        if(sBussType.trim().isEmpty() || sBussType.trim().equalsIgnoreCase("")){
            message = "Please select type of business";
            return false;
        }
        return true;
    }

    boolean isBusinessSizeValid(){
        if(sBussSize.trim().isEmpty() || sBussSize.trim().equalsIgnoreCase("")){
            message = "Please select size of business";
            return false;
        }
        return true;
    }

    boolean isLenghtOfServiceValid(){
        if(sLenghtSv == 0 ){
            message = "Please enter length of service";
            return false;
        }else {
            return isLenghtOfServiceSpinnerValid();
        }
    }
    boolean isLenghtOfServiceSpinnerValid(){
        if(cIsYearxx.trim().isEmpty() || cIsYearxx.trim().equalsIgnoreCase("")){
            message = "Please enter length of service in Month/Year";
            return false;
        }
        return true;
    }

    boolean isMonthlyIncomeValid(){
        if(sMnthlyIn == 0){
            message = "Please enter monthly income";
            return false;
        }
        return true;
    }

    boolean isMonthlyExpenseValid(){
        if(sMnthlyEx == 0){
            message = "Please enter monthly expense";
            return false;
        }
        return true;
    }
}
