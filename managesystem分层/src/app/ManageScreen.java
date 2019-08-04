package app;

import service.ManageOperate;

import java.util.Scanner;

public class ManageScreen {

    public static void ManageScreen() {
        Scanner w = new Scanner(System.in);
        System.out.println("==========欢迎coucou=========");
        System.out.println("A.添加学生\nB.删除用户\nC.修改用户\nD.查看用户\n其他:默认退出");
        while (true) {
            System.out.println("请输入您要进行的操作：");
            String s = w.next();
            if (s.equals("A")) {
                ManageOperate.addStudent();

            } else if (s.equals("B")) {
                ManageOperate.deleteStudent();

            } else if (s.equals("C")) {
                ManageOperate.reviseStudent();

            } else if (s.equals("D")) {
                ManageOperate.selectStudent();

            } else {
                break;
            }
        }
    }
}
