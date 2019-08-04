package service;

import app.StudentScreen;
import dao.ManageDao;
import dao.StudentDao;

import java.sql.*;
import java.util.Scanner;

public class StudentOperate {


    //学生注册
    public static void singup(){
        Scanner w = new Scanner(System.in);
        int sid = 0;
        System.out.println("==========================");
        System.out.println("输入你的学号:");
        while(true) {
            sid = w.nextInt();
            if(ManageDao.studentIsExist(sid)) {
                System.out.println("该学号已经存在！请重新输入！");
            }else{
                System.out.println("请输入你的姓名:");
                break;
            }
        }

        String name = w.next();
        System.out.println("设置你的密码:");
        String pwd = w.next();
        StudentDao.singUpDao(sid,name,pwd);
        System.out.println("~~~注册成功！^-^");


    }

    //学生登录
    public static void login(){
        Scanner w = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("========请输入你的id=======");
        int sids = w.nextInt();
        System.out.println("=======请输入你的密码======");
        while (true) {
            String pwd = w.next();
            if (!pwd.equals(StudentDao.truePwd(sids))) {
                System.out.println("密码不正确！请重新输入~");
            } else {
                StudentScreen.studentScreen2(sids);
            }
        }

    }


    //学生修改信息
    public static void reviseInfo(int sid){
        Scanner w = new Scanner(System.in);
        PreparedStatement ps1 = null;
        System.out.println("请选择要修改的信息:(A.名字 B.年龄)");
        String s1 = w.next();
        if (s1.equals("A")) {
            System.out.println("请输入新的名字:");
            String name1 = w.next();
            StudentDao.alterName(sid,name1);
            System.out.println("修改信息成功！");

        } else if (s1.equals("B")) {
            System.out.println("请输入新的年龄:");
            int age1 = w.nextInt();
            ManageDao.alterStudent01(sid,age1);
            System.out.println("修改信息成功！");

        }


    }



    //学生查看自己学号对应的信息
    public static void selectInfo(int sid){
        System.out.println("--------你的信息--------");
        StudentDao.selectInfoDao(sid);

    }




}
