package com.example.apple.myapplication;

public class MyMarksModel {
    String code,marks,name2;
    public MyMarksModel(String name,String code,String marks)
    {
        this.name2=name;
        this.code=code;
        this.marks=marks;
    }


    public String getCode() {
        return code;
    }

    public String getMarks() {
        return marks;
    }

    public String getName() {
        return name2;
    }
}
