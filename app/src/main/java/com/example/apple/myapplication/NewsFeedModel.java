package com.example.apple.myapplication;

public class NewsFeedModel {
    public String Title;
    public String time;
    public String text;

    public NewsFeedModel(String title,String time,String text)
    {
        this.Title=title;
        this.time=time;
        this.text=text;
    }

    public String getTitle() {
        return Title;
    }

    public String getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}
