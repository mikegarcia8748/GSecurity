package org.rmj.guanzongroup.appdriver.Lib.Auth.Obj;

import static org.rmj.guanzongroup.appdriver.Api.APIResult.SERVER_NO_RESPONSE;
import static org.rmj.guanzongroup.appdriver.Api.APIResult.getErrorMessage;

import android.app.Application;
import android.os.Build;

import org.json.JSONObject;
import org.rmj.guanzongroup.appdriver.Api.APIAddress;
import org.rmj.guanzongroup.appdriver.Api.HttpHeaders;
import org.rmj.guanzongroup.appdriver.Api.WebClient;
import org.rmj.guanzongroup.appdriver.Config.AppConfig;
import org.rmj.guanzongroup.appdriver.Data.Dao.DAccountInfo;
import org.rmj.guanzongroup.appdriver.Data.Entity.EAccountInfo;
import org.rmj.guanzongroup.appdriver.Data.GGC_SecSysDb;
import org.rmj.guanzongroup.appdriver.Etc.AppConstants;
import org.rmj.guanzongroup.appdriver.Lib.Account.AccountSession;
import org.rmj.guanzongroup.appdriver.Lib.Auth.Model.GAccount;
import org.rmj.guanzongroup.appdriver.Lib.Auth.Pojo.LoginCredentials;

public class Authentication implements GAccount {
    private static final String TAG = Authentication.class.getSimpleName();

    private final Application instance;
    private final DAccountInfo poDao;

    private String message;

    public Authentication(Application instance) {
        this.instance = instance;
        this.poDao = GGC_SecSysDb.getInstance(instance).accountDao();
    }

    @Override
    public int DoAction(Object args) {
        try{
            LoginCredentials loDetail = (LoginCredentials) args;

            if(!loDetail.isDataValid()){
                message = loDetail.getMessage();
                return 0;
            }

            AppConfig.getInstance(instance).setMobileNO(loDetail.getMobileNo());

            JSONObject params = new JSONObject();
            String lsResponse = WebClient.sendRequest(
                    APIAddress.getInstance(instance).getAuthentication(),
                    params.toString(),
                    HttpHeaders.getInstance(instance).getHeaders());

            if(lsResponse == null){
                message = SERVER_NO_RESPONSE;
                return 0;
            }

            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
                JSONObject loError = loResponse.getJSONObject("error");
                message = getErrorMessage(loError);
                return 0;
            }

            EAccountInfo employeeInfo = new EAccountInfo();
            employeeInfo.setClientID(loResponse.getString("sClientID"));
            employeeInfo.setBranchCD(loResponse.getString("sBranchCD"));
            employeeInfo.setBranchNm(loResponse.getString("sBranchNm"));
            employeeInfo.setLogNoxxx(loResponse.getString("sLogNoxxx"));
            employeeInfo.setUserIDxx(loResponse.getString("sUserIDxx"));
            employeeInfo.setEmailAdd(loResponse.getString("sEmailAdd"));
            employeeInfo.setUserName(loResponse.getString("sUserName"));
            employeeInfo.setUserLevl(loResponse.getString("nUserLevl"));
            employeeInfo.setSlfieLog(loResponse.getString("cSlfieLog"));
            employeeInfo.setDeptIDxx(loResponse.getString("sDeptIDxx"));
            employeeInfo.setPositnID(loResponse.getString("sPositnID"));
            employeeInfo.setEmpLevID(loResponse.getInt("sEmpLevID"));
            employeeInfo.setAllowUpd(loResponse.getString("cAllowUpd"));
            employeeInfo.setEmployID(loResponse.getString("sEmployID"));
            employeeInfo.setDeviceID(AppConfig.getInstance(instance).getDeviceID());
            employeeInfo.setModelIDx(Build.MODEL);
            employeeInfo.setMobileNo(AppConfig.getInstance(instance).getMobileNo());
            employeeInfo.setLoginxxx(AppConstants.DATE_MODIFIED());
            employeeInfo.setSessionx(AppConstants.CURRENT_DATE());
            poDao.Save(employeeInfo);

            AccountSession loSession = AccountSession.getInstance(instance);
            loSession.setUserID(loResponse.getString("sUserIDxx"));
            loSession.setClientID(loResponse.getString("sClientID"));
            loSession.setLogNumber(loResponse.getString("sLogNoxxx"));
            loSession.setLogIn(true);

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
