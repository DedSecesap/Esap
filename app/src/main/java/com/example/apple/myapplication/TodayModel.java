package com.example.apple.myapplication;

public class TodayModel {
    private String hall;
    private String time;
    private String code;
    public TodayModel(String hallName,String timings,String SubjectCode)
    {
        this.hall=hallName;
        this.time=timings;
        this.code=SubjectCode;
    }

    public String getTime() {
        return time;
    }

    public String getCode() {
        return code;
    }

    public String getHall() {
        return hall;
    }
}
