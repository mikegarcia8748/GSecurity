/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeInfo;

@Dao
public interface DEmployeeInfo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void SaveNewEmployeeSession(EEmployeeInfo employee);

    @Update
    void update(EEmployeeInfo employee);

    @Query("SELECT * FROM User_Info_Master")
    LiveData<EEmployeeInfo> getEmployeeInfo();

    @Query("SELECT * FROM User_Info_Master")
    EEmployeeInfo getEmployeeInfoNonLiveData();

    @Query("DELETE FROM User_Info_Master")
    void deleteAllEmployeeInfo();

    @Query("DELETE FROM xxxAOEmpRole")
    void RemoveAuthorizeAccess();

    @Query("SELECT sUserIDxx FROM User_Info_Master")
    LiveData<String> getUserID();

    @Query("SELECT sLogNoxxx FROM User_Info_Master")
    LiveData<String> getLogNumber();

    @Query("SELECT sClientID FROM User_Info_Master")
    LiveData<String> getClientID();

    @Query("SELECT sEmployID FROM User_Info_Master")
    LiveData<String> getEmployID();

    @Query("SELECT sBranchCD FROM User_Info_Master")
    LiveData<String> getSBranchID();

    @Query("SELECT * FROM User_Info_Master")
    Cursor getUserInfo();

    @Query("SELECT strftime('%H:%M:%S', 'now', 'localtime') - strftime('%H:%M:%S', dLoginxxx) AS Session FROM User_Info_Master")
    Integer getLoginDate();

    @Query("SELECT dLoginxxx FROM User_Info_Master")
    String getSessionTime();

    @Query("DELETE FROM User_Info_Master")
    void LogoutUser();

    @Query("DELETE FROM xxxAOEmpRole")
    void ClearAuthorizeFeatures();

    @Query("SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)")
    String getUserAreaCode();

    @Query("SELECT sAreaDesc FROM MC_Area_Performance " +
            "WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info " +
            "WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))")
    LiveData<String> getUserAreaCodeForDashboard();

    @Query("SELECT sEmployID FROM User_Info_Master")
    String getEmployeeID();

    @Query("SELECT a.sUserIDxx, " +
            "a.sEmailAdd, " +
            "a.sUserName, " +
            "a.nUserLevl, " +
            "a.sDeptIDxx, " +
            "a.sPositnID, " +
            "a.sEmpLevID," +
            "a.sEmployID," +
            "b.sBranchCd, " +
            "b.sBranchNm, " +
            "b.sAddressx FROM User_Info_Master a " +
            "LEFT JOIN Branch_Info b " +
            "ON a.sBranchCD = b.sBranchCd")
    LiveData<EmployeeBranch> GetEmployeeBranch();

    class EmployeeBranch{
        public String sUserIDxx;
        public String sEmailAdd;
        public String sUserName;
        public String nUserLevl;
        public String sDeptIDxx;
        public String sPositnID;
        public String sEmpLevID;
        public String sEmployID;
        public String sBranchCd;
        public String sBranchNm;
        public String sAddressx;
    }
}
