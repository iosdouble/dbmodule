package com.nh.dbmodule;

import com.mysql.jdbc.Driver;

import java.sql.*;


/**
 * com.nh.dbmodule
 * create by admin nihui
 * create time 2020/12/15
 * version 1.0
 **/
public class JDBCMain {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test?useSSL=false";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
//        test01();
    }

    private static void test02() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //
            String sql = "select * from act_ru_task";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("ID_"));
            }
            resultSet.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    private static void test01() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //
            String sql = "select * from act_ru_task";
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()){
                System.out.println(resultSet.getString("ID_"));
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
