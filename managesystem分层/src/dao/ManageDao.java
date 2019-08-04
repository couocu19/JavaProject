package dao;

import model.StudentInfo;

import java.sql.*;


public class ManageDao {

    //管理员新增学生
    public static void newStudentDao(int sid,String name,int age,float grade){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert into student (sid,name,age,grade) values (?,?,?,?)");
            ps.setInt(1,sid);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setFloat(4,grade);
            ps.executeUpdate();
            //return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //return false;
        }


    }


    //管理员删除学生
    public static void deleteStudentDao(int sid){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from student where sid=?");
            ps.setInt(1,sid);
            ps.executeUpdate();
           // return true;
        } catch (SQLException e) {
            e.printStackTrace();
           // return false;
        }



    }


    //管理员打印所有学生信息
    public static void printAllStudentDao(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from student");
            ps.execute();
            rs = ps.executeQuery();
            while(rs.next()){
                StudentInfo o = new StudentInfo(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getFloat(5));
                System.out.print("studentTd-->"+o.getSId()+"  name-->"+o.getName()+" age-->"+o.getAge()+"  grade-->"+o.getGrade());
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    //管理员查看指定学号学生的信息
    public static void selectStudentDao(int sid){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from student where sid=?");
            ps.setObject(1,sid);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("studentId-->"+rs.getInt(2)+"  name-->"+rs.getString(3)+" age-->"+rs.getInt(4)+"  grade-->"+rs.getFloat(5));

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //管理员修改学生信息01(修改年龄)
    public static void alterStudent01(int sid,int age){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update student set age=? where sid=?");
            ps.setInt(2,sid);
            ps.setInt(1,age);
            ps.execute();

        }catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //管理员修改学生信息02(修改成绩)
    public static void alterStudent02(int sid,float grade){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update student set grade=? where sid=?");
            ps.setInt(2,sid);
            ps.setFloat(1,grade);
            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //管理员修改学生信息03(修改年龄以及成绩)
    public static void alterStudent03(int sid,float grade,int age){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update student set age=?,grade=? where sid=?");
            ps.setInt(3,sid);
            ps.setInt(1,age);
            ps.setFloat(2,grade);
            ps.execute();
           // return true;
        }catch (SQLException e) {
            e.printStackTrace();
            //return false;
        }

    }

    //判断某个学号的学生是否存在
    public static boolean studentIsExist(int sid){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from student where sid=?");
            ps.setInt(1,sid);
            ps.execute();
            rs = ps.executeQuery();
            if(rs.next())
                flag = true;
            else
                flag = false;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return flag;

    }




}



