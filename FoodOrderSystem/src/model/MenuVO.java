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
public class MenuVO {
    private int menuid;
    private int facilityid;
    private String name;
    private int price;
    private String intro;
    
    public MenuVO(){
        System.out.println("MenuVO is called");
    }
    public MenuVO(int menuid, String name, String intro, int price, int facilityid){
        this.menuid = menuid;
        this.facilityid = facilityid;
        this.name = name;
        this.price = price;
        this.intro = intro;
    }
    

    public int getFacilityid(){
        return this.facilityid;
    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public String getIntro(){
        return this.intro;
    }
    public int getMenuid(){
        return this.menuid;
    }
    
    public void setFacilityid(int facilityid ){
        this.facilityid = facilityid;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setIntro(String intro){
        this.intro = intro;
    }
    public void setMenuid(int menuid){
        this.menuid = menuid;
    }
}
