package com.project.java.project_03.teamviewservice;

import com.project.java.project_03.teamviewdomain.Architect;
import com.project.java.project_03.teamviewdomain.Designer;
import com.project.java.project_03.teamviewdomain.Employee;
import com.project.java.project_03.teamviewdomain.Programmer;
import com.project.java.project_03.teamviewservice.TeamException.TeamException;

/**
 *
 * 关于开发团队成员的管理：添加、删除等
 *
 *

 */
public class TeamService {


    // counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId
    private static int counter=1;

    //MAX_MEMBER：表示开发团队最大成员数
    private final  int MAX_MEMBER=5;

    public TeamService() {
        team=new Programmer[MAX_MEMBER];
    }

    //team数组：用来保存当前团队中的各成员对象
    //为什么要用Programmer呢？因为Programmer是开发成员（程序员，架构，设计师）的父类
    private Programmer[] team;
    //total：记录团队成员的实际人数
    private int total;


    //getTeam()方法：返回当前团队的所有对象
    public Programmer[] getTeam(){

        //因为属性team可能长度不够5个 如果返回属性的数组，可能空指针 所以要再创建个数组
        Programmer[] totalTeam=new Programmer[total];

       // return team;  错误的写法 team如果只有2个人不够5个 报空指针，有几个列几个
        for(int i=0;i<total;i++){
            totalTeam[i] = this.team[i];
        }
        return totalTeam;  //返回的不是属性的team呦



    }
    //addMember(e: Employee)方法：向团队中添加成员
    //为什么不传id直接添加呢？因为id是在view层传入的
    public void addMember(Employee e) throws TeamException{

        if (this.total==MAX_MEMBER){  //不要写5
            throw new TeamException("成员已满无法添加");
        }
        if(!(e instanceof Programmer)){  // Employee 返回false 再反转！ 返回true 抛异常
            throw new TeamException("非开发人员无法添加");
        }
        for(int i=0;i<total;i++){
            if(team[i].equals(e)){
                throw new TeamException("该成员已在本团队中");
            }

        }
        Programmer p=(Programmer)e;
        Status status = p.getStatus();  //
        if(status.equals("BUSY") ||status.equals("VOCATION")){
            throw new TeamException("该成员正在其他团队或者正在休假中无法添加");
        }
        int proNum=0; //程序员个数
        int desNum=0; //设计师个数
        int arcNum=0; //架构师个数
        for(int j=0;j<total;j++){
            //判断数量 -->如果无法通过书信去判断 那么就用instanceof去判断
            if(team[j] instanceof Architect){
                arcNum++;
            }else if(team[j] instanceof Designer){
                desNum++;
            }else if(team[j] instanceof Programmer){
                proNum++;
            }
        }
        if(p instanceof Architect && arcNum>=1){
            throw new TeamException("做多只能添加一个架构师");
        }else if(p instanceof Designer && desNum>=2){
            throw new TeamException("最多只能添加二个设计师");
        }else if(p instanceof Programmer && proNum>=3){
            throw new TeamException("最多只能添加三个程序员");
        }

        //通过重重困难终于走到这一步 装好发车!!!
        p.setStatus(Status.BUSY);  //通过类名去掉静态的
        p.setMemberId(counter++);
        team[total++]=p; //total在这里已经加过了


    }


    //removeMember(memberId: int)方法：从团队中删除成员
    public void removeMember(int memberId) throws TeamException{
        int n=0; //提出来很玄妙
        for(;n<total;n++){
            if(team[n].getMemberId()==memberId){
                team[n].setStatus(Status.FREE);
                //提高效率
                break;
            }
        }
        //遍历完了还没有找到
        if(total==n){
            throw new TeamException("无法删除，没有找到该成员");
        }
        //删除成功后的动作,要删除的memberId的后面的元素覆盖前面的
        for (int i = n + 1; i < total; i++) {
            team[i - 1] = team[i];
        }
        team[--total]=null; //牛皮

    }



}
