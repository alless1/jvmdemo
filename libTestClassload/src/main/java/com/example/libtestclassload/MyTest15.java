package com.example.libtestclassload;

import java.sql.DriverManager;

/**
 * Created by chengjie on 2020-02-24
 * Description:
 */
public class MyTest15 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("","","");
    }
}
