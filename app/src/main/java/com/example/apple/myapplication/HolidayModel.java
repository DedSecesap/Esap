package com.example.apple.myapplication;

public class HolidayModel {
    String date;
    String occasion;

    public String getDate() {
        return date;
    }

    public String getOccasion() {
        return occasion;
    }

    public HolidayModel(String date,String occasion)
    {
        this.date=date;
        this.occasion=occasion;
    }
}
