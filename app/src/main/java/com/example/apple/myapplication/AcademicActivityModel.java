package com.example.apple.myapplication;

public class AcademicActivityModel {

    public String name;
    public String Details;
    public String type;


    public AcademicActivityModel(String name,String details,String type){
        this.name=name;
        this.Details=details;
        this.type=type;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return Details;
    }

    public String getType() {
        return type;
    }
}
