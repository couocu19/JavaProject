package app;

import service.StudentOperate;

import java.util.Scanner;

public class StudentScreen {

    //学生登录之前的界面
    public static void studentScreen1() {
        Scanner w = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("A.注册学生用户\nB.登录学生账号\nC.退出");
        while (true) {
            System.out.println("请输入您要进行的操作");
            String s = w.next();
            if(s.equals("A")){
                StudentOperate.singup();

            }else if (s.equals("B")){
                StudentOperate.login();

            }else if (s.equals("C")){
                return;
            }else{
                System.out.println("选择有误！请重新选择！");
            }


        }
    }

    //学生登录后的主界面
    public static void studentScreen2(int sid){
        Scanner w = new Scanner(System.in);
        System.out.println("---------------登录成功-----");
        System.out.println("-----------欢迎---------");
        System.out.println("A.查询信息\nB.修改信息\nC:退出");
        while (true) {
            System.out.println("------请选择您可以进行的操作:(A/B/C)");
            String s = w.next();
            if (s.equals("A")) {
                System.out.println("==========================");
                StudentOperate.selectInfo(sid);
                //查询
            } else if (s.equals("B")) {
                StudentOperate.reviseInfo(sid);

            }  else if(s.equals("C")){
                return;

            }else{
                System.out.println("选择有误！请重新选择！");
            }

        }





    }
}
