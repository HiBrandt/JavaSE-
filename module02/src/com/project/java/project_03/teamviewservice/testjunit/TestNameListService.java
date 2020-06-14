//package com.project.java.project_03.teamviewservice.testjunit;
//
//import com.project.java.project_03.teamviewdomain.Employee;
//import com.project.java.project_03.teamviewservice.NameListService;
//import com.project.java.project_03.teamviewservice.TeamException.TeamException;
//import org.junit.jupiter.api.Test;
//
//
//public class TestNameListService {
//
//    @Test
//    public void testNameListService(){
//        NameListService nameListService=new NameListService();
//
//        Employee[] allEmployees = nameListService.getAllEmployees();
//        for(int i=0;i<allEmployees.length ;i++){
//            System.out.println(allEmployees[i]);
//        }
//
//        try {
//            System.out.println(nameListService.getEmployee(2));
//        } catch (TeamException e) {
//            e.printStackTrace();
//        }
//    }
//}
