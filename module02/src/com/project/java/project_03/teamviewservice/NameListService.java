package com.project.java.project_03.teamviewservice;

import com.project.java.project_03.teamviewdomain.*;
import com.project.java.project_03.teamviewservice.TeamException.TeamException;
import com.project.java.project_03.teamviewutil.Data;

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * 其实就是把Data的值 赋给Employee[]中的各个对象
 *
 */
public class NameListService {

    private Employee[]employees; //员工类的数组  保存所有员工的对象  感觉要用到多态了~~~

    public NameListService() {
        /**
         * 1.根据项目提供的Data类构建相应大小的employees数组
           2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，
             以及相关联的Equipment子类的对象
           3.将对象存于数组中
         *
         */

        employees=new Employee[Data.EMPLOYEES.length];

        //上面已经创建好数组，下面要创建对象，给数组赋值
        for(int i=0;i<employees.length;i++){

            String s = Data.EMPLOYEES[i][0];//获取代号 String类型 但是Data的属性都是int类的，需要转化
            final int propertyID = Integer.parseInt(s);

            //拿到Data.EMPLOYEES的信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age =Integer.parseInt(Data.EMPLOYEES[i][3]) ;
            double salary =Double.parseDouble(Data.EMPLOYEES[i][4]) ;

            Equipment equipment;


            //Employee  :  10, id, name, age, salary
            //Programmer:  11, id, name, age, salary
            //Designer  :  12, id, name, age, salary, bonus
            //Architect :  13, id, name, age, salary, bonus, stock

            //属性固定就那么几种用switch case
            switch (propertyID){
                case Data.EMPLOYEE:
                    employees[i]=new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment=getEquipment(i); //获取装备 因为装备不属于这个数组，所以得传入对象
                    employees[i]=new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                     equipment=getEquipment(i); //获取装备
                     double designerBonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                     employees[i]=new Designer(id,name,age,salary,equipment,designerBonus);
                     break;
                case Data.ARCHITECT:
                    equipment=getEquipment(i); //获取装备
                    double architectBonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int stock=Integer.parseInt(Data.EMPLOYEES[i][6]); //股票
                    employees[i]=new Architect(id,name,age,salary,equipment,architectBonus,stock);
                    break;
            }
        }





    }

    /**
     *
     * @param index 传入的编号创建相应的设备的对象
     * @return 返回设备
     */

    private Equipment getEquipment(int index) {

        Equipment equipment;


        int equipmentID = Integer.parseInt(Data.EQUIPMENTS[index][0]);

        switch (equipmentID){
            case Data.PC:
                String model = Data.EQUIPMENTS[index][1]; //型号
                String display = Data.EQUIPMENTS[index][2]; //名称
                return equipment=new PC(model,display);
               // break;   //上面都return了就不用了break了
            case Data.NOTEBOOK:
                String modelNoteBook = Data.EQUIPMENTS[index][1]; //型号
                int price = Integer.parseInt(Data.EQUIPMENTS[index][2]);//价格
                return equipment=new NoteBook(modelNoteBook,price);

            case Data.PRINTER:
                String name = Data.EQUIPMENTS[index][1]; //型号
                String type = Data.EQUIPMENTS[index][2];//类型
                return equipment=new Printer(name,type);

        }
        return null;
    }

    /**
     * 获取员工数组
     * @return
     */
    public Employee[] getAllEmployees(){

        return employees;
    }


    /**
     * 获取指定id员工 有风险报异常
     * @param id 员工ID
     * @return  员工信息
     */
    public Employee getEmployee(int id) throws TeamException{
        if(id>=1 && id<=employees.length){
            return employees[id-1];
        }else {
           throw  new TeamException("找不到指定的员工\n");
        }

    }
}
