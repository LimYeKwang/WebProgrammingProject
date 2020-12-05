package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    void connDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8","root","saej1028");
            stmt = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    String makeString(String e){
        return "'" + e + "'";
    }

}
