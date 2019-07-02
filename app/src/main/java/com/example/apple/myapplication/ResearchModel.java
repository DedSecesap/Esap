package com.example.apple.myapplication;

public class ResearchModel {
    public String projectName;
    public String projectMentor;
    public String projectBreif;

    public ResearchModel(String projectName,String projectMentor,String projectBreif)
    {
        this.projectName=projectName;
        this.projectMentor=projectMentor;
        this.projectBreif=projectBreif;
    }

    public String getProjectBreif() {
        return projectBreif;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectMentor() {
        return projectMentor;
    }


}
