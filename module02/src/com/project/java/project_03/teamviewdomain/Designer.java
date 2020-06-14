package com.project.java.project_03.teamviewdomain;

/**
 *
 * 设计师类 继承程序员类
 *
 * 这里不用继承 Employee 直接继承Programmer 继承越来越丰富的功能
 * 很好的思想
 */
public class Designer extends Programmer{


    private double bonus; //奖金

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }


//    public Designer(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment, double bonus) {
//        super(id, name, age, salary, memberId, status, equipment);
//        this.bonus = bonus;
//    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    public String getDetailsForTeam() {
        return getMemberDetails() + "\t设计师\t" + getBonus();
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" +
                getBonus() +"\t\t" + getEquipment().getDescription();
    }
}
