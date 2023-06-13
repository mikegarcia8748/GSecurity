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

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.GCircle.room.Entities.EBranchInfo;

import java.util.List;

@Dao
public interface DBranchInfo {

    @Insert
    void SaveBranchInfo(EBranchInfo branchInfo);

    @Update
    void UpdateBranchInfo(EBranchInfo branchInfo);

    @Query("SELECT * FROM Branch_Info WHERE sBranchCd =:fsVal")
    EBranchInfo GetBranchInfo(String fsVal);

    @Query("SELECT * FROM Branch_Info ORDER BY dTimeStmp DESC LIMIT 1")
    EBranchInfo GetLatestBranchInfo();

    @Query("UPDATE Branch_Info SET sBranchNm =:BranchNm, " +
            " sDescript=:Descript," +
            " sAddressx=:Addressx," +
            " sTownIDxx=:TownIDxx," +
            " sAreaCode=:AreaCode," +
            " cDivision=:Division," +
            " cRecdStat=:RecdStat," +
            " cPromoDiv=:PromoDiv," +
            " dTimeStmp=:TimeStmp " +
            "WHERE sBranchCd=:BranchCd")
    void updateBranchInfo(String BranchCd,
                          String BranchNm,
                          String Descript,
                          String Addressx,
                          String TownIDxx,
                          String AreaCode,
                          String Division,
                          String PromoDiv,
                          String RecdStat,
                          String TimeStmp);

    @Query("SELECT * FROM Branch_Info")
    LiveData<EBranchInfo> getBranchInfo();

    @Query("SELECT * FROM Branch_Info WHERE cDivision = 1")
    LiveData<List<EBranchInfo>> getAllMcBranchInfo();

    @Query("SELECT * FROM Branch_Info WHERE cDivision = 0")
    LiveData<List<EBranchInfo>> getAllMpBranchInfo();

    @Query("SELECT sBranchNm FROM Branch_Info WHERE cDivision = 1")
    LiveData<String[]> getMCBranchNames();

    @Query("SELECT sBranchNm FROM Branch_Info WHERE cRecdStat = 1")
    LiveData<String[]> getAllBranchNames();

    @Query("SELECT * FROM Branch_Info WHERE cRecdStat = 1")
    LiveData<List<EBranchInfo>> getAllBranchInfo();

    @Query("SELECT cPromoDiv FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)")
    LiveData<String> getPromoDivision();

    @Query("SELECT * FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)")
    LiveData<EBranchInfo> getUserBranchInfo();

    @Query("SELECT sBranchNm FROM Branch_Info WHERE cRecdStat = 1 AND sBranchCd = :BranchCde")
    LiveData<String> getBranchName(String BranchCde);

    @Query("SELECT MAX(dTimeStmp) FROM Branch_Info")
    String getLatestDataTime();

    @Query("SELECT sBranchNm FROM Branch_Info WHERE sBranchCd =:sBranchCd")
    String getBranchNameForNotification(String sBranchCd);

    @Query("SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = :fsBranchCd")
    LiveData<String> getBranchAreaCode(String fsBranchCd);

    @Query("SELECT * FROM Branch_Info " +
            "WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info " +
            "WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))")
    LiveData<List<EBranchInfo>> getAreaBranchList();

    @Query("SELECT * FROM Branch_Info")
    List<EBranchInfo> getBranchList();

    @Query("SELECT * FROM Branch_Info " +
            "WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info " +
            "WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))")
    List<EBranchInfo> getAreaBranchesList();

    @Query("SELECT * FROM Branch_Info WHERE sBranchCd = " +
            "(SELECT sBranchCd FROM Employee_Log_Selfie WHERE cReqCCntx != '1' || cReqRSIxx != '1' ORDER BY dLogTimex DESC LIMIT 1)")
    LiveData<EBranchInfo> getSelfieLogBranchInfo();

    @Query("SELECT * FROM Branch_Info WHERE sBranchCd =:BranchCd")
    LiveData<EBranchInfo> getBranchInfo(String BranchCd);
}
