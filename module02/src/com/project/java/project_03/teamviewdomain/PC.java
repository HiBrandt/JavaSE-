package com.project.java.project_03.teamviewdomain;

public class PC implements Equipment{


    private String model;  //机器型号

    private String display; //机器名称
    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getmodel() {
        return model;
    }

    public String getType() {
        return display;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.display = type;
    }
}
