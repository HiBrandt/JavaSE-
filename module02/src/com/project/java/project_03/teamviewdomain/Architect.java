package com.project.java.project_03.teamviewdomain;

/**
 * 架构师类
 *
 */
public class Architect extends Designer{

    private int stock; //公司股票

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t架构师\t" +
                getBonus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" +
                getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }
}
