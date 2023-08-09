package com.system.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://localhost:3306/university";
        private static final String DB_USERNAME = "chan";
        private static final String DB_PW = "dc3890!Q@";
        public static Connection getConnection(){
            Connection con = null;
            try{
                Class.forName(DB_DRIVER_CLASS);
                con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PW);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (SQLException e){
                e.printStackTrace();
            }

            return con;
        }
}