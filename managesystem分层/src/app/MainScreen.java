package app;
import service.*;
import java.util.Scanner;

public class MainScreen {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        System.out.println("----欢迎进入学生管理系统----");
        System.out.println("----------A:管理员---------");
        System.out.println("---------B:普通用户--------");
        System.out.println("===========================");
        System.out.println("--------请选择你的身份:(A/B)");
        while(true) {
            String s = w.nextLine();
            if (s.equals("A")) {
                ManageOperate.managerLogin();
                break;
            } else if (s.equals("B")) {
                StudentScreen.studentScreen1();
                break;
            } else {
                System.out.println("输入有误~请重新选择");
            }
        }

    }
}
