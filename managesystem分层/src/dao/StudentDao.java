package dao;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;


/**
 *学生端操作的Dao层
 *
 */
public class StudentDao {
    //学生注册
    public static void singUpDao(int sid,String name,String pwd){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert into student (sid,name,pwd) values (?,?,?)");
            ps.setInt(1,sid);
            ps.setString(2,name);
            ps.setString(3,pwd);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //返回学生登录时相应学号对应的密码
    public static String truePwd (int sid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pwd ="";
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from student where sid=?");
            ps.setInt(1, sid);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                pwd = rs.getString(6);
            }
            return pwd;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //学生查看自己的信息
    public static void selectInfoDao(int sid){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from student where sid=?");
            ps.setInt(1,sid);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("studentId-->" + rs.getInt(2) + "  name-->" + rs.getString(3)
                        + "  age-->" + rs.getInt(4) + "  grade-->" + rs.getFloat(5));
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //学生修改信息
    public static void alterName(int sid,String name){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("update student set name=? where sid=?");
            ps.setInt(2,sid);
            ps.setString(1,name);
            ps.execute();

        }catch (SQLException e) {
            e.printStackTrace();

        }



    }


}
