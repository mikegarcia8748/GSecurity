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
import androidx.room.RoomWarnings;
import androidx.room.Update;

import org.rmj.g3appdriver.GCircle.room.Entities.EBranchLoanApplication;
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplicantInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplication;
import org.rmj.g3appdriver.GCircle.room.Entities.ELoanTerm;

import java.util.List;

@Dao
public interface DCreditApplication {

    @Insert
    void Save(ECreditApplication creditApplication);

    @Update
    void Update(ECreditApplication creditApplication);

    @Insert
    void Save(ECreditApplicantInfo creditApplicantInfo);

    @Update
    void Update(ECreditApplicantInfo creditApplicantInfo);

    @Insert
    void Save(EBranchLoanApplication branchLoanApplication);

    @Update
    void Update(EBranchLoanApplication branchLoanApplication);

    @Insert
    void Save(ELoanTerm loanTerm);

    @Update
    void Update(ELoanTerm loanTerm);

    @Query("SELECT * FROM Installment_Term WHERE nTermCode =:args")
    ELoanTerm GetLoanTerm(int args);

    @Query("SELECT * FROM Installment_Term ORDER BY nTermCode DESC")
    LiveData<List<ELoanTerm>> GetLoanTerms();

    @Query("SELECT * FROM Credit_Online_Application ORDER BY dTimeStmp DESC LIMIT 1")
    ECreditApplication GetLatestRecord();

    @Query("SELECT * FROM Credit_Online_Application WHERE sTransNox =:fsVal")
    ECreditApplication GetCreditOnlineApplication(String fsVal);

    @Query("SELECT * FROM Credit_Online_Application WHERE sTransNox =:fsVal")
    LiveData<ECreditApplication> GetCreditApplication(String fsVal);

    @Query("SELECT * FROM Credit_Applicant_Info WHERE sTransNox =:fsVal")
    LiveData<ECreditApplicantInfo> GetApplicantInfo(String fsVal);

    @Query("SELECT * FROM Credit_Applicant_Info WHERE sTransNox =:fsVal")
    ECreditApplicantInfo GetApplicantDetails(String fsVal);

    @Query("SELECT a.sTownName || ', ' || b.sProvName FROM Town_Info a " +
            "LEFT JOIN Province_Info b " +
            "ON a.sProvIDxx = b.sProvIDxx " +
            "WHERE a.sTownIDxx=:fsVal")
    String GetBirthPlace(String fsVal);

    @Query("SELECT sNational FROM Country_Info WHERE sCntryCde =:fsVal")
    String GetCitizenship(String fsVal);

    @Query("SELECT COUNT (*) FROM Credit_Online_Application")
    int GetRowsCountForID();

    @Query("SELECT COUNT (*) FROM Credit_Applicant_Info")
    int GetRowsCountForUniqueID();

    @Query("SELECT * FROM Credit_Online_Application")
    LiveData<List<ECreditApplication>> GetAllCreditApplication();

    @Query("SELECT * FROM Credit_Online_Application_List")
    LiveData<List<EBranchLoanApplication>> GetBranchApplications();

    @Query("SELECT * FROM Credit_Online_Application_List WHERE sTransNox =:args")
    EBranchLoanApplication GetBranchApplication(String args);

    @Query("SELECT * FROM Credit_Online_Application WHERE sTransNox =:TransNox")
    ECreditApplication getLoanInfoOfTransNox(String TransNox);

    @Query("SELECT * FROM Credit_Online_Application WHERE cSendStat = '0'")
    List<ECreditApplication> GetApplicationsForUpload();

    @Query("UPDATE Credit_Online_Application SET " +
            "sTransNox =:TransNox, " +
            "cSendStat = '1', " +
            "dModified =:DateTime " +
            "WHERE sTransNox =:oldTransNox")
    void updateSentLoanAppl(String oldTransNox, String TransNox, String DateTime);

    @Query("UPDATE Credit_Online_Application_List SET " +
            "sTransNox =:TransNox " +
            "WHERE sTransNox =:oldTransNox")
    void updateApplicationListTransNox(String oldTransNox, String TransNox);

    @Query("UPDATE Credit_Online_Application_List SET " +
            "sTransNox =:TransNox " +
            "WHERE sTransNox =:oldTransNox")
    void updateApplicationImageTransNox(String oldTransNox, String TransNox);

    @Query("UPDATE Credit_Online_Application_Documents SET " +
            "sTransNox =:TransNox " +
            "WHERE sTransNox =:oldTransNox")
    void updateApplicationDocsTransNox(String oldTransNox, String TransNox);

    @Query("SELECT * FROM Credit_Online_Application WHERE cSendStat <> '1'")
    List<ECreditApplication> getUnsentLoanApplication();

//    @Query("UPDATE Credit_Online_Application SET sFileLoct = (SELECT sFileLoct FROM Image_Information WHERE sSourceNo =:TransNox) WHERE sTransNox =:TransNox")
//    void updateApplicantImageStat(String TransNox);

    @Query("Select a.sGOCASNox, " +
            "a.sTransNox, " +
            "b.sBranchNm, " +
            "a.dCreatedx, " +
            "a.sDetlInfo, " +
            "a.sClientNm, " +
            "a.cWithCIxx, " +
            "a.cSendStat, " +
            "a.cTranStat, " +
            "a.dReceived, " +
            "a.dVerified " +
            "From Credit_Online_Application a " +
            "Left Join Branch_Info b " +
            "ON a.sBranchCd = b.sBranchCd " +
            "WHERE a.cTranStat != 4 " +
            "AND sCreatedx = (SELECT sUserIDxx From User_Info_Master) " +
            "GROUP BY a.sTransNox " +
            "ORDER BY a.dCreatedx DESC")
    LiveData<List<ApplicationLog>> getApplicationHistory();

    @Query("Select * From Credit_Applicant_Info WHERE cTranStat = 0 " +
            "GROUP BY sTransNox ")
    LiveData<List<ECreditApplicantInfo>> getAllCreditApp();

    @Query("SELECT sUserIDxx FROM User_Info_Master")
    String GetUserID();

    class ApplicationLog{
        public String sGOCASNox;
        public String sTransNox;
        public String sBranchNm;
        public String dCreatedx;
        public String sDetlInfo;
        public String sClientNm;
        public String cWithCIxx;
        public String cSendStat;
        public String cTranStat;
        public String dReceived;
        public String dVerified;
    }

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT a.sGOCASNox," +
            "a.sTransNox," +
            "b.sBranchNm," +
            "a.dCreatedx," +
            "a.sDetlInfo," +
            "a.sClientNm," +
            "a.cWithCIxx," +
            "a.cSendStat," +
            "a.cTranStat," +
            "a.dReceived," +
            "a.dVerified " +
            "FROM Credit_Online_Application a " +
            "LEFT JOIN Branch_Info b " +
            "ON a.sBranchCd = b.sBranchCd " +
            "WHERE cTranStat != 4 " +
            "AND a.sBranchCd =:BranchID " +
            "AND sCreatedx = (SELECT sUserIDxx From User_Info_Master) " +
            "ORDER BY a.dCreatedx DESC" )
    LiveData<List<ApplicationLog>> getApplicationByBranch(String BranchID);
}
