package com.example.apple.myapplication;

public class ClubGridModel {
    public String imageLink;
    public String textClub;

    public ClubGridModel(String imageLink,String textClub)
    {
        this.imageLink=imageLink;
        this.textClub=textClub;


    }

    public String getImageLink() {
        return imageLink;
    }

    public String getTextClub() {
        return textClub;
    }

}
