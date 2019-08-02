package managementsystem;

import java.sql.*;
import java.util.*;

public class Student {
    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC","root","123456");

   //public static List<Studentinfo> list = new ArrayList<>();
    public static Map<Integer,Studentinfo> list = new HashMap<>();
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner w = new Scanner(System.in);
        System.out.println("--------欢迎进入学生管理系统-------");
        System.out.println("请选择你的身份:(A/B)");
        System.out.println("A:管理员\nB:普通用户");
        System.out.println("====================================");
        while(true) {
            String s = w.nextLine();
            if (s.equals("A")) {
                managerLogin();
                break;

            } else if (s.equals("B")) {
                userLogin();
                break;

            } else {
                System.out.println("输入有误~请重新选择");
            }
        }

    }


    public static void managerLogin() throws Exception{
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

        System.out.println("==========欢迎coucou=========");
        //System.out.println("请输入您要进行的操作：");
        System.out.println("A.添加学生\nB.删除用户\nC.修改用户\nD.查看用户\n其他:默认退出");
        while(true) {
            System.out.println("请输入您要进行的操作：");
            String s = w.next();
            if (s.equals("A")) {
                addStudent();
            } else if (s.equals("B")) {
                deleteStudent();
            } else if (s.equals("C")) {
                reviseStudent();
            } else if (s.equals("D")) {
                selectStudent();
            }else{
                break;
            }
        }


    }


    public static void addStudent() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC","root","123456");

        Scanner w = new Scanner(System.in);
        System.out.println("请输入要添加的学生个数:");
        int num = w.nextInt();
        System.out.println("请依次录入学生信息:");
       // Scanner w = new Scanner(System.in);
        for(int i =0;i<num;i++){
            PreparedStatement ps = con.prepareStatement("insert into student (sid,name,age,grade) values (?,?,?,?)");
            System.out.println("请输入学生学号:");
            int sid = w.nextInt();
            ps.setObject(1,sid);
            System.out.println("请输入学生姓名:");
            String name = w.next();
            ps.setObject(2,name);
            System.out.println("请输入学生年龄:");
            int age = w.nextInt();
            ps.setObject(3,age);
            System.out.println("请输入学生成绩:");
            float grade = w.nextFloat();
            ps.setObject(4,grade);
            ps.execute();
        }
        System.out.println("录入成功！");

    }

    public static void deleteStudent() throws Exception{
        Scanner w = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC","root","123456");
        System.out.println("请输入要删除的学生学号:");
        int sid = w.nextInt();
        PreparedStatement ps = con.prepareStatement("delete from student where sid=?");
        ps.setObject(1,sid);
        ps.execute();
        System.out.println("删除成功！");
    }

    public static void reviseStudent() throws Exception{
        Scanner w = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC","root","123456");
        PreparedStatement ps = con.prepareStatement("select * from student where sid=?");
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        System.out.println("请输入要修改信息的学生学号:");
        int sid = w.nextInt();
        ps.setObject(1,sid);
        ps.execute();
        rs = ps.executeQuery();
        System.out.println("该同学的当前信息如下:");
        while(rs.next()){
            System.out.println("姓名:"+rs.getObject(3)+"  年龄:"+rs.getObject(4)+"  成绩:"+rs.getObject(5));
        }
        System.out.println("请选择要修改的信息:(A/B/C)\nA.年龄 B.成绩 C.年龄和成绩");
        String c = w.next();
        if(c.equals("A")){
            ps1 = con.prepareStatement("update student set age=? where sid=?");
            ps1.setObject(2,sid);
            System.out.println("请输入新的年龄:");
            int age = w.nextInt();
            ps1.setObject(1,age);
            System.out.println("修改信息成功！");

        }else if(c.equals("B")){
            ps1 = con.prepareStatement("update student set grade=? where sid=?");
            ps1.setObject(2,sid);
            System.out.println("请输入新的成绩:");
            float grade = w.nextFloat();
            ps1.setObject(1,grade);
            System.out.println("修改信息成功！");

        }else if(c.equals("C")){
            ps1 = con.prepareStatement("update student set age=?,grade=? where sid=?");
            ps1.setObject(3,sid);
            System.out.println("请输入新的年龄和成绩:");
            System.out.println("请输入年龄:");
            int age = w.nextInt();
            System.out.println("请输入成绩:");
            float grade = w.nextFloat();
            ps1.setObject(1,age);
            ps1.setObject(2,grade);
            System.out.println("修改信息成功！");

        }

    }

    public static void selectStudent() throws Exception{
        Scanner w = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC","root","123456");
        PreparedStatement ps = con.prepareStatement("select * from student");
        PreparedStatement ps1 = con.prepareStatement("select * from student where sid=?");
        ResultSet rs = null;
        System.out.println("您是否要查看所有学生信息？(Y/N)");
        String c = w.next();
        if(c.equals("Y")){
            ps.execute();
            rs = ps.executeQuery();
            while(rs.next()){
                Studentinfo o = new Studentinfo(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getFloat(5));
                System.out.print("studentTd-->"+o.getSId()+"  name-->"+o.getName()+" age-->"+o.getAge()+"  grade-->"+o.getGrade());
                System.out.println();
            }


        }else if(c.equals("N")){
            System.out.println("请输入要查询信息的学生学号:");
            int sid = w.nextInt();
            ps1.setObject(1,sid);
            rs = ps1.executeQuery();
            System.out.println(sid+"同学的学生信息如下:");
            while(rs.next()){
                System.out.println("studentId-->"+rs.getInt(2)+"  name-->"+rs.getString(3)+" age-->"+rs.getInt(4)+"  grade-->"+rs.getFloat(5));

            }

        }

    }

    public static void userLogin() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC","root","123456");
        String flag = "";
        con.setAutoCommit(false);
        Scanner w = new Scanner(System.in);
        System.out.println("=============================");
       // System.out.println("请输入您要进行的操作");
       System.out.println("A.注册学生用户\nB.登录学生账号\nC.退出");
        while(true) {
            System.out.println("请输入您要进行的操作");
            String s = w.next();
            if (s.equals("A")) {
                System.out.println("==========================");
                PreparedStatement ps = con.prepareStatement("insert into student (sid,name,pwd) values(?,?,?)");
                PreparedStatement ps1 = con.prepareStatement("select * from student where sid=?");
                //ResultSet rs = null;
                System.out.println("输入你的学号:");
                while(true) {
                    int sid = w.nextInt();
                    ps1.setObject(1, sid);
                    ps1.execute();
                    ResultSet rs = ps1.executeQuery();
                    if(!rs.next()) {
                        ps.setObject(1, sid);
                        break;
                    }else{
                        System.out.println("该学号已经存在！请重新输入！");

                    }
                }

                System.out.println("输入你的姓名:");
                String name = w.next();
                ps.setObject(2, name);
                System.out.println("设置你的密码:");
                String pwd = w.next();
                ps.setObject(3, pwd);
                System.out.println("~~~注册成功！^-^");
                ps.execute();
                con.commit();

            } else if (s.equals("B")) {
                PreparedStatement ps = con.prepareStatement("select * from student where sid=?");
                System.out.println("===========================");
                System.out.println("========请输入你的id=======");
                int sids = w.nextInt();
                ps.setObject(1, sids);
                ps.execute();
                ResultSet rs = ps.executeQuery();
                //System.out.println(rs.getString(6));
                System.out.println("=======请输入你的密码======");
                while (true) {
                    String pwd = w.next();
                    //while (rs.next()) {
                    while (rs.next()) {
                        flag = rs.getString(6);
                    }
                    if (!pwd.equals(flag)) {
                        System.out.println("密码不正确！请重新输入~");
                    } else {
                        //ResultSet rs1 = ps.executeQuery();
                        System.out.println("---------------登录成功-----");
                        System.out.println("-----------欢迎---------");
                        System.out.println("A.查询信息\nB.修改信息\nC:退出");
                        while (true) {
                            System.out.println("------请选择您可以进行的操作:(A/B/C)");
                            String c = w.next();
                            if (c.equals("A")) {
                                System.out.println("--------你的信息--------");
                                ResultSet rs1= ps.executeQuery();
                                while (rs1.next()) {
                                    System.out.println("studentId-->" + rs1.getInt(2) + "  name-->" + rs1.getString(3)
                                            + "  age-->" + rs1.getInt(4) + "  grade-->" + rs1.getFloat(5));
                                }
                                System.out.println();

                            } else if (c.equals("B")) {
                                PreparedStatement ps1 = null;
                                System.out.println("请选择要修改的信息:(A.名字 B.年龄)");
                                String s1 = w.next();
                                if (s1.equals("A")) {
                                    ps1 = con.prepareStatement("update student set name=? where sid=?");
                                    ps1.setObject(2, sids);
                                    System.out.println("请输入新的名字:");
                                    String name1 = w.next();
                                    ps1.setObject(1, name1);
                                    ps1.execute();
                                    System.out.println("修改信息成功！");

                                } else if (s1.equals("B")) {
                                    ps1 = con.prepareStatement("update student set age=? where sid=?");
                                    ps1.setObject(2, sids);
                                    System.out.println("请输入新的年龄:");
                                    int age1 = w.nextInt();
                                    ps1.setObject(1, age1);
                                    ps1.execute();
                                    System.out.println("修改信息成功！");

                                }
                            } else if (c.equals("C")) {
//
                                System.out.println("正在退出……");
                               return;


                            } else {
                                System.out.println("选择有误，请重新选择！");
                            }


                        }

                    }
                    //   }
                }
            } else if(s.equals("C")){
                return;

            }else{
                System.out.println("选择有误！请重新选择！");
            }
        }




    }

//    public static void userLogin2() throws Exception{
//
//
//
//
//
//
//    }

}


