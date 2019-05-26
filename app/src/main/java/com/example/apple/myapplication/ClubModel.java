package com.example.apple.myapplication;

import android.support.annotation.Nullable;

public class ClubModel {

    public String name;
@Nullable
public String Council;

    public ClubModel(String name,@Nullable String Council){
        this.name=name;
        this.Council=Council;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getCouncil() {
        return Council;
    }
}
