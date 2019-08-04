package service;

import app.ManageScreen;
import dao.ManageDao;

import java.util.Scanner;

public class ManageOperate {

    //管理员登录
    public static void managerLogin(){
        Scanner w = new Scanner(System.in);
        System.out.println("------登录-------");
        System.out.println("请输入用户名：");
        while(true){
            String name1 = w.next();
            if(name1.equals("coucou")){
                break;
            }else{
                System.out.println("管理员不叫"+name1+"! 请重新输入~");
            }
        }
        System.out.println("请输入密码");
        while(true) {
            String pwd = w.next();
            if (pwd.equals("123456")) {
                break;
            }else{
                System.out.println("密码有误,请重新输入~");
            }
        }
        ManageScreen.ManageScreen();

    }

    //管理员新增学生
    public static void addStudent(){
        Scanner w = new Scanner(System.in);
        System.out.println("请输入要添加的学生个数:");
        int num = w.nextInt();
        System.out.println("请依次录入学生信息:");
        for(int i =0;i<num;i++){
            System.out.println("请输入学生学号:");
            int sid = w.nextInt();
            System.out.println("请输入学生姓名:");
            String name = w.next();
            System.out.println("请输入学生年龄:");
            int age = w.nextInt();
            System.out.println("请输入学生成绩:");
            float grade = w.nextFloat();
            ManageDao.newStudentDao(sid,name,age,grade);
        }
        System.out.println("录入成功！");

    }
    //管理员删除学生
    public static void deleteStudent(){
        Scanner w = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号:");
        int sid = w.nextInt();
        ManageDao.deleteStudentDao(sid);
        System.out.println("删除成功！");
    }

    //管理员修改学生信息
    public static void reviseStudent(){
        Scanner w = new Scanner(System.in);
        System.out.println("请输入要修改信息的学生学号:");
        int sid ;
        while(true) {
            sid = w.nextInt();
            if (ManageDao.studentIsExist(sid)) {
                System.out.println("该同学的当前信息如下:");
                ManageDao.selectStudentDao(sid);
                break;
            } else {
                System.out.println("该学号不存在！请重新输入");

            }
        }
        System.out.println("请选择要修改的信息:(A/B/C)\nA.年龄 B.成绩 C.年龄和成绩");
        String c = w.next();
        if(c.equals("A")){
            System.out.println("请输入新的年龄:");
            int age = w.nextInt();
            ManageDao.alterStudent01(sid,age);
            System.out.println("修改信息成功！");

        }else if(c.equals("B")){
            System.out.println("请输入新的成绩:");
            float grade = w.nextFloat();
            ManageDao.alterStudent02(sid,grade);
            System.out.println("修改信息成功！");

        }else if(c.equals("C")){
            System.out.println("请输入新的年龄和成绩:");
            System.out.println("请输入年龄:");
            int age = w.nextInt();
            System.out.println("请输入成绩:");
            float grade = w.nextFloat();
            ManageDao.alterStudent03(sid,grade,age);
            System.out.println("修改信息成功！");

        }

    }

    //管理员查看学生信息
    public static void selectStudent(){
        Scanner w = new Scanner(System.in);
        System.out.println("您是否要查看所有学生信息？(Y/N)");
        String c = w.next();
        if(c.equals("Y")){
          ManageDao.printAllStudentDao();

        }else if(c.equals("N")){
            System.out.println("请输入要查询信息的学生学号:");
            int sid = w.nextInt();
            System.out.println(sid+"同学的学生信息如下:");
            ManageDao.selectStudentDao(sid);


        }

    }


}
