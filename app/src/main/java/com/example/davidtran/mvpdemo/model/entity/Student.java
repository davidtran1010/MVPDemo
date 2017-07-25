package com.example.davidtran.mvpdemo.model.entity;

/**
 * Created by davidtran on 7/24/17.
 */

public class Student {
    public String getID() {
        return ID;
    }

    public String getFName() {
        return FName;
    }

    public String getBDate() {
        return BDate;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public int getAcaYear() {
        return AcaYear;
    }

    public String getMajor() {
        return Major;
    }

    String ID;
    String FName;
    String BDate;
    String IDNumber;
    int AcaYear;
    String Major;

    public Student(String ID, String FName, String BDate, String IDNumber, int acaYear, String major) {
        this.ID = ID;
        this.FName = FName;
        this.BDate = BDate;
        this.IDNumber = IDNumber;
        AcaYear = acaYear;
        Major = major;
    }
}
