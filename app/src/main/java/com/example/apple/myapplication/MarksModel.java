package com.example.apple.myapplication;

public class MarksModel {
    String no,grade,UL,LL,avg;
    boolean checked;
    public MarksModel(String no,String grade,String UL,String LL,String avg,boolean checked)
    {
        this.no=no;
        this.grade=grade;
        this.UL=UL;
        this.LL=LL;
        this.avg=avg;
        this.checked=checked;
    }



    public String getAvg() {
        return avg;
    }

    public String getGrade() {
        return grade;
    }

    public String getLL() {
        return LL;
    }

    public String getNo() {
        return no;
    }

    public String getUL() {
        return UL;
    }

    public boolean getChecked()
    {
        return checked;
    }
}
