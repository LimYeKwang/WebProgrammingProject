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
public class OrderDAO extends DAO {

	
    public ArrayList<OrderVO> ListOrder(String memberid){
        ArrayList<OrderVO> list = new ArrayList<OrderVO>();
        try{
            connDB();
            String query = "select * from `order` where memberid = '" + memberid + "'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                int facilityid = rs.getInt("facilityid");
                int menuid = rs.getInt("menuid");
                int price = rs.getInt("price");
                String date = rs.getString("date");
                String todate = rs.getString("todate");
                int end = rs.getInt("end");
                
                OrderVO vo = new OrderVO(id, memberid, facilityid, menuid, price, date, todate, end);
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
    
    public ArrayList<OrderVO> ListOrder(int facilityid){
        ArrayList<OrderVO> list = new ArrayList<OrderVO>();
        try{
            connDB();
            String query = "select * from `order` where facilityid = '" + facilityid + "'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String memberid = rs.getString("memberid");
                int menuid = rs.getInt("menuid");
                int price = rs.getInt("price");
                String date = rs.getString("date");
                String todate = rs.getString("todate");
                int end = rs.getInt("end");
                
                OrderVO vo = new OrderVO(id, memberid, facilityid, menuid, price, date, todate, end);
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
    
     public void AddOrder(OrderVO vo){
        try{
            connDB();
            String query = "INSERT INTO `order`(memberid, facilityid, menuid, price, todate, `end`) values("
                    + makeString(vo.getMemberid()) + ","
                    + vo.getFacilityid() + ","
                    + vo.getMenuid() + ","
                    + vo.getPrice() + ","
                    + makeString(vo.getTodate()) + ","
                    + vo.getEnd() + ")";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
     
     public void DelOrder(int id){
        try{
            connDB();
            String query = "delete from `order` where id = " + id;
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
     }
     
    public void EndMenu(int id){
        try{
            connDB();
            String query = "update `order` set end = 0 where id = " + id;
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
     }
    
}
