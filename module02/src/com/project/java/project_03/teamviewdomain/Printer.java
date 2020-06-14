package com.project.java.project_03.teamviewdomain;

public class Printer implements Equipment{


    private String name;  //机器名称

    private String type;  //机器类型

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
