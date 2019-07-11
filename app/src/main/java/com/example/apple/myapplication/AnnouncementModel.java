package com.example.apple.myapplication;

public class AnnouncementModel {
    String title,message,from;
    public AnnouncementModel(String title, String  message, String from)
    {
        this.title=title;
        this.message=message;
        this.from=from;

    }


    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }


}
