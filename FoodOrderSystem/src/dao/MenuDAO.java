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
public class MenuDAO extends DAO {
	
    public MenuVO FindMenu(int menuid){
        MenuVO vo = new MenuVO();
        try{
            connDB();
            String query = "select * from menu where menuid = " + menuid;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("name");
                String intro = rs.getString("intro");
                int price = rs.getInt("price");
                int facilityid = rs.getInt("facilityid");
                
                vo.setFacilityid(facilityid);
                vo.setIntro(intro);
                vo.setMenuid(menuid);
                vo.setName(name);
                vo.setPrice(price);
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
    
    public void DelMenu(int id){
        try{
            connDB();
            String query = "delete from menu where menuid = " + id;
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
     }
    
    public void AddMenu(MenuVO vo){
        try{
            connDB();
            String query = "INSERT INTO menu (name, intro, price, facilityid) values("
                    + makeString(vo.getName()) + ","
                    + makeString(vo.getIntro()) + ","
                    + vo.getPrice() + ","
                    + vo.getFacilityid()
                    + ")";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    
    public ArrayList<MenuVO> ListMenu(int facilityid){
        ArrayList<MenuVO> list = new ArrayList<MenuVO>();
        try{
            connDB();
            String query = "select * from menu where facilityid = " + facilityid;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                MenuVO vo = new MenuVO();
                int menuid = rs.getInt("menuid");
                String name = rs.getString("name");
                String intro = rs.getString("intro");
                int price = rs.getInt("price");
                
                vo.setFacilityid(facilityid);
                vo.setIntro(intro);
                vo.setMenuid(menuid);
                vo.setName(name);
                vo.setPrice(price);
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
}
