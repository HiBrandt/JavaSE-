package com.project.java.project_03.teamviewview;

import com.project.java.project_03.teamviewdomain.Employee;
import com.project.java.project_03.teamviewdomain.Programmer;
import com.project.java.project_03.teamviewservice.NameListService;
import com.project.java.project_03.teamviewservice.TeamException.TeamException;
import com.project.java.project_03.teamviewservice.TeamService;
import com.project.java.project_03.teamviewutil.TSUtility;

/**
 * 页面交互展示类
 */
public class TeamView {

    static NameListService nameListService=new NameListService();
    static TeamService teamService=new TeamService();

    public static void main(String[] args) {

        TeamView teamView=new TeamView();
        teamView.enterMainMenu();

    }


    //enterMainMenu ()方法：主界面显示及控制方法
    public void enterMainMenu(){

        boolean flag=true;
        while (flag){
            listAllEmployees();
            char selection = TSUtility.readMenuSelection();

            switch (selection){
                case '1':
                    System.out.println("\n--------------------团队成员列表---------------------\n");
                    Programmer[] team = getTeam();
                    if(team.length==0){
                        System.out.println("开发团队目前没有成员！");
                    }else {
                        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
                    }
                    for(int i=0;i<team.length;i++){
                        System.out.println(team[i].getDetailsForTeam());
                    }
                    TSUtility.readReturn();
                    break;
                case '2':  //添加
                    System.out.println("---------------------添加成员---------------------");
                    System.out.print("请输入要添加的员工ID：");
                    int readInt = TSUtility.readInt();
                    Employee addemployee = null;
                    try {
                        addemployee = nameListService.getEmployee(readInt);
                        addMember(addemployee);  //出现过bug
                    } catch (TeamException e) {
                        System.out.println(e.getMessage());
                    }


                    TSUtility.readReturn();
                    break;
                case '3':
                    System.out.println("---------------------删除成员---------------------");
                    System.out.print("请输入要删除员工的TID：");
                    int id2 = TSUtility.readInt();
                    System.out.print("确认是否删除(Y/N)：");
                    char c2 = TSUtility.readConfirmSelection();
                    if(c2=='Y'){
                        try {
                            removeMember(id2);
                        } catch (TeamException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char c = TSUtility.readConfirmSelection();
                    if(c=='Y'){
                        flag=false;
                    }
                    break;

            }
        }


    }


    //listAllEmployees ()方法：以表格形式列出公司所有成员
    public void listAllEmployees(){

        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] allEmployees = nameListService.getAllEmployees();
        if(allEmployees==null){
            System.out.println("没有客户记录！");
        }else {
            for(int i=0;i<allEmployees.length;i++){
                System.out.println(allEmployees[i]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

    }



    //获取所有对象的方法
    public  Programmer[] getTeam(){


        return teamService.getTeam();

    }


    //调用添加的方法

    public  void addMember(Employee employee) throws TeamException {

        teamService.addMember(employee);

    }

    //调用删除的方法

    public  void removeMember(int memberId) throws TeamException {


        teamService.removeMember(memberId);

    }



}
