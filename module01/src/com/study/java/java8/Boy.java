package com.study.java.java8;

public class Boy {

    private  Girl  gilr;


    public Boy() {
    }

    public Boy(Girl gilr) {
        this.gilr = gilr;
    }

    public Girl getGilr() {
        return gilr;
    }

    public void setGilr(Girl gilr) {
        this.gilr = gilr;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "gilr=" + gilr +
                '}';
    }
}
