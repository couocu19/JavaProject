package dao;

import java.sql.*;

/***
 * JDBC工具类 包含获取connection与关闭资源的方法
 *
 */

public class JDBCUtil {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coucou?serverTimezone=UTC", "root", "123456");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL导包失败");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }
    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement ps, Connection conn){
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


