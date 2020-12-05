/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lim
 */
public class BasketVO {
    String memberid;
    int facilityid;
    int menuid;
    
    public BasketVO(){
        System.out.println("BasketVO is called");
    }
    
    public BasketVO(String mem, int fac, int menu){
        System.out.println("BasketVO is called");
        this.memberid = mem;
        this.facilityid = fac;
        this.menuid = menu;
    }
    
    public String getMemberid(){
        return memberid;
    }
    public int getFacilityid(){
        return facilityid;
    }
    public int getMenuid(){
        return menuid;
    }
    
    public void setMemberid(String memberid){
        this.memberid = memberid;
    }
    public void setFacilityid(int facilityid){
        this.facilityid = facilityid;
    }
    public void setMenuid(int menuid){
        this.menuid = menuid;
    }
    
    
    
}
