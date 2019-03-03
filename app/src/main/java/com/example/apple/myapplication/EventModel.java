package com.example.apple.myapplication;

public class EventModel {
    private String eventName;
    private String eventText;
    private String eventClub;
    private String eventContact;
    private String eventVenue;
    private String eventTime;
    private int drawable;

    public EventModel(String eventName,String eventText,String eventClub,String eventContact,String eventVenue,String eventTime,int drawable)
    {
        this.eventName=eventName;
        this.eventText=eventText;
        this.eventClub=eventClub;
        this.eventContact=eventContact;
        this.eventVenue=eventVenue;
        this.eventTime=eventTime;
        this.drawable=drawable;

    }


    public String getEventClub() {
        return eventClub;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getEventContact() {
        return eventContact;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventText() {
        return eventText;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventVenue() {
        return eventVenue;
    }

}
