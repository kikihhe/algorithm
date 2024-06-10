package com;

import java.sql.*;

public class DBUtil {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/api_gateway?useSSL=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&characterEncoding=UTF-8&collationConnection=utf8mb4_general_ci";
    private static final String name = "root";
    private static final String password = "123456";
    private static final Connection conn;

    static {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接对象
     * @return 数据库连接对象
     */
    public static Connection getConnect() {
        return conn;
    }

    /**
     * 关闭数据库相关资源
     * @param conn 数据库连接对象
     * @param ps sql语句执行对象
     * @param rs 查询结果集
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null) conn.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库相关资源
     * @param conn 数据库连接对象
     * @param ps sql语句执行对象
     */
    public static void close(Connection conn, PreparedStatement ps) {
        close(conn, ps, null);
    }

    /**
     * 关闭数据库相关资源
     * @param conn 数据库连接对象
     * @param rs 查询结果集
     */
    public static void close(Connection conn, ResultSet rs) {
        close(conn, null, rs);
    }


    public static int insertStudent(Student student) {
        String sql = "INSERT INTO students (student_id, name, gender, class_name, major, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getGender());
            stmt.setString(4, student.getClassName());
            stmt.setString(5, student.getMajor());
            stmt.setString(6, student.getPhone());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}