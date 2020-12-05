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
public class ReviewDAO extends DAO{

    
    public ArrayList<ReviewVO> ListReview(int facilityid){
        ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
        try{
            connDB();
            String query = "select * from review where facilityid = '" + facilityid + "'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                int reviewid = rs.getInt("reviewid");
                String memberid = rs.getString("id");
                String date = rs.getString("date");
                String text = rs.getString("text");
                int score = rs.getInt("score");
                
                ReviewVO vo = new ReviewVO(reviewid, facilityid, memberid, date, text, score);
                list.add(vo);
            }
            rs.close();
            stmt.close();
            con.close();
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
     public void AddReview(ReviewVO vo){
        try{
            connDB();
            String query = "INSERT INTO review (facilityid, id, text, score) values("
                    + vo.getFacilityid() + ","
                    + makeString(vo.getId()) + ","
                    + makeString(vo.getText()) + ","
                    + vo.getScore() + ")";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
     
     public void DelReview(int id){
        try{
            connDB();
            String query = "delete from review where reviewid = " + id;
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
     }  
}
