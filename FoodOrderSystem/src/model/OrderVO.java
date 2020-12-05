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
public class OrderVO {
    int id;
    String memberid;
    int facilityid;
    int menuid;
    int price;
    String date;
    String todate;
    int end;
    
    
    public OrderVO(){
        System.out.println("OrderVO is called");
    }
    
    public OrderVO(int id, String mem, int fac, int menu, int pri, String date, String todate, int end){
        System.out.println("OrderVO is called");
        this.id = id;
        this.memberid = mem;
        this.facilityid = fac;
        this.menuid = menu;
        this.price = pri;
        this.date = date;
        this.todate = todate;
        this.end = end;
    }
    
    public int getId(){
        return id;
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
    public int getPrice(){
        return price;
    }
    public String getDate(){
        return date;
    }
    public String getTodate(){
        return todate;
    }
    public int getEnd(){
        return end;
    }
    
    public void setId(int id){
        this.id = id;
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
    public void setPrice(int price){
        this.price = price;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setTodate(String todate){
        this.todate = todate;
    }
    public void setEnd(int end){
        this.end = end;
    }
    
    
    
}
