package com.example.apple.myapplication;

public class BranchGridModel {

    String name,tagline,imageUrl,designation,data;

    public  BranchGridModel(String name,String tagline,String Designation, String data, String imageUrl)
    {
        this.name=name;
        this.tagline=tagline;
        this.imageUrl=imageUrl;
        this.designation=Designation;
        this.data=data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getTagline() {
        return tagline;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDesignation() {
        return designation;
    }
}
