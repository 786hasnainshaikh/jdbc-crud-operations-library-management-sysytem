package com.jdbcconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectivity {
    public static Connection con;
    public static Connection Connection () {
        try {
            final String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3307/liberary_data";
            final String user_name = "root";
            final String user_password = "admin";
            Class.forName(driver);  // loaded the driver
            con = DriverManager.getConnection(url, user_name, user_password); // get the connection
        } catch (Exception e) {
            System.out.println(e);
        }

      return con;
    }
}

