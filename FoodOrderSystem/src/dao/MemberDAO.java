/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.*;

import model.*;
/**
 *
 * @author Lim
 */
public class MemberDAO extends DAO{
    
    public MemberVO FindMember(String id){
        MemberVO vo = new MemberVO();
        try{
            connDB();
            String query = "select * from member where id = '" + id + "'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                String user_id = rs.getString("id");
                String user_pw = rs.getString("password");
                String name = rs.getString("name");
                String school = rs.getString("school");
                String phone = rs.getString("phone");
                int right = rs.getInt("right");
                
                vo.setId(user_id);
                vo.setPassword(user_pw);
                vo.setName(name);
                vo.setSchool(school);
                vo.setPhone(phone);
                vo.setRight(right);
            }
            rs.close();
            stmt.close();
            con.close();
            return vo;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void AddMember(MemberVO vo){
        try{
            connDB();
            String query = "INSERT INTO member values("
                    + makeString(vo.getId()) + ","
                    + makeString(vo.getPassword()) + ","
                    + makeString(vo.getName()) + ","
                    + makeString(vo.getSchool()) + ","
                    + makeString(vo.getPhone()) + ","
                    + vo.getRight() + ")";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

}
