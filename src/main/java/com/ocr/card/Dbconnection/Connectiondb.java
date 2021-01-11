package com.ocr.card.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectiondb {
    Connection conn = null;
    public static  Connection connectdb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbscanner","root","");
            return conn ;
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("erreur");
            return null;
        }
    }
}
