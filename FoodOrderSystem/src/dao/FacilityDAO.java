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
public class FacilityDAO extends DAO {
    
    public ArrayList<FacilityVO> ListFacility(String school,int sort){
        ArrayList<FacilityVO> list = new ArrayList<FacilityVO>();
        try{
            connDB();
            String query = "select * from facility where school = '" + school + "' and sort = " + sort;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                FacilityVO vo = new FacilityVO();
                int facilityid = rs.getInt("facilityid");
                String managerid = rs.getString("managerid");
                String name = rs.getString("name");
                String intro = rs.getString("intro");
                
                vo.setFacilityid(facilityid);
                vo.setManagerid(managerid);
                vo.setName(name);
                vo.setIntro(intro);
                vo.setSort(sort);
                vo.setSchool(school);
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
    
        public ArrayList<FacilityVO> ListFacility_manage(String managerid){
        ArrayList<FacilityVO> list = new ArrayList<FacilityVO>();
        try{
            connDB();
            String query = "select * from facility where managerid = '" + managerid + "'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                FacilityVO vo = new FacilityVO();
                int facilityid = rs.getInt("facilityid");
                String school = rs.getString("school");
                String name = rs.getString("name");
                String intro = rs.getString("intro");
                int sort = rs.getInt("sort");
                
                vo.setFacilityid(facilityid);
                vo.setManagerid(managerid);
                vo.setName(name);
                vo.setIntro(intro);
                vo.setSort(sort);
                vo.setSchool(school);
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
    
    public FacilityVO FindFacility(int facilityid){
        FacilityVO vo = new FacilityVO();
        try{
            connDB();
            String query = "select * from facility where facilityid = '" + facilityid + "'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                String managerid = rs.getString("managerid");
                String name = rs.getString("name");
                String intro = rs.getString("intro");
                int sort = rs.getInt("sort");
                String school = rs.getString("school");
                
                vo.setFacilityid(facilityid);
                vo.setManagerid(managerid);
                vo.setName(name);
                vo.setIntro(intro);
                vo.setSort(sort);
                vo.setSchool(school);
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
    
    public void AddFacility(FacilityVO vo){
        try{
            connDB();
            String query = "INSERT INTO facility(managerid, name, intro, sort, school) values("
                    + makeString(vo.getManagerid()) + ","
                    + makeString(vo.getName()) + ","
                    + makeString(vo.getIntro()) + ","
                    + vo.getSort() + ","
                    + makeString(vo.getSchool()) + ")";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void DelFacility(int id){
        try{
            connDB();
            String query = "delete from facility where facilityid = " + id;
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
         
     }
}
