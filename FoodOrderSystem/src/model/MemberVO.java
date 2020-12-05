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
public class MemberVO {
    private String id;
    private String password;
    private String name;
    private String school;
    private String phone;
    private int right;
    
    public MemberVO(){
        System.out.println("MemberVO is called");
    }
    public MemberVO(String id, String password, String name, String school, String phone, int right){
        this.id = id;
        this.password = password;
        this.name = name;
        this.school = school;
        this.phone = phone;
        this.right = right;
    }
    
    public String getId(){
        return this.id;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public String getSchool(){
        return this.school;
    }
    public String getPhone(){
        return this.phone;
    }
    public int getRight(){
        return this.right;
    }
    
    public void setId(String id ){
        this.id = id;
    }
    public void setPassword(String password ){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setRight(int right ){
        this.right = right;
    }
    
    
}

