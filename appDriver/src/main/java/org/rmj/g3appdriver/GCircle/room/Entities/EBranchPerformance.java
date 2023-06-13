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

package org.rmj.g3appdriver.GCircle.room.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "MC_Branch_Performance", primaryKeys = {"sBranchCd", "sPeriodxx"})
public class EBranchPerformance {

    @NonNull
    @ColumnInfo(name = "sBranchCd")
    private String BranchCd;
    @NonNull
    @ColumnInfo(name = "sPeriodxx")
    private String Periodxx;
    @ColumnInfo(name = "sBranchNm")
    private String BranchNm;
    @ColumnInfo(name = "nMCGoalxx")
    private int MCGoalxx;
    @ColumnInfo(name = "nSPGoalxx")
    private float SPGoalxx;
    @ColumnInfo(name = "nJOGoalxx")
    private int JOGoalxx;
    @ColumnInfo(name = "nLRGoalxx")
    private float LRGoalxx;
    @ColumnInfo(name = "nMCActual")
    private int MCActual;
    @ColumnInfo(name = "nSPActual")
    private float SPActual;
    @ColumnInfo(name = "nJOActual")
    private float JOActual;
    @ColumnInfo(name = "nLRActual")
    private float LRActual;

    public EBranchPerformance() {
    }

    @NonNull
    public String getBranchCd() {
        return BranchCd;
    }

    public void setBranchCd(@NonNull String branchCd) {
        BranchCd = branchCd;
    }

    public String getPeriodxx() {
        return Periodxx;
    }

    public void setPeriodxx(String periodxx) {
        Periodxx = periodxx;
    }

    public String getBranchNm() {
        return BranchNm;
    }

    public void setBranchNm(String branchNm) {
        BranchNm = branchNm;
    }

    public int getMCGoalxx() {
        return MCGoalxx;
    }

    public void setMCGoalxx(int MCGoalxx) {
        this.MCGoalxx = MCGoalxx;
    }

    public float getSPGoalxx() {
        return SPGoalxx;
    }

    public void setSPGoalxx(float SPGoalxx) {
        this.SPGoalxx = SPGoalxx;
    }

    public int getJOGoalxx() {
        return JOGoalxx;
    }

    public void setJOGoalxx(int JOGoalxx) {
        this.JOGoalxx = JOGoalxx;
    }

    public float getLRGoalxx() {
        return LRGoalxx;
    }

    public void setLRGoalxx(float LRGoalxx) {
        this.LRGoalxx = LRGoalxx;
    }

    public int getMCActual() {
        return MCActual;
    }

    public void setMCActual(int MCActual) {
        this.MCActual = MCActual;
    }

    public float getSPActual() {
        return SPActual;
    }

    public void setSPActual(float SPActual) {
        this.SPActual = SPActual;
    }

    public float getJOActual() {
        return JOActual;
    }

    public void setJOActual(float JOActual) {
        this.JOActual = JOActual;
    }

    public float getLRActual() {
        return LRActual;
    }

    public void setLRActual(float LRActual) {
        this.LRActual = LRActual;
    }
}