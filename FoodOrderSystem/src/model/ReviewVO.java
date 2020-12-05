/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Lim
 */
public class ReviewVO {
    private int reviewid;
    private int facilityid;
    private String id;
    private int score;
    private String text;
    private String date;
    
    public ReviewVO(){
        System.out.println("ReviewVO is called");
    }
    public ReviewVO(int reviewid,int facilityid, String id, String date,String text, int score){
        this.reviewid = reviewid;
        this.facilityid = facilityid;
        this.id = id;
        this.score = score;
        this.text = text;
        this.date = date;
    }
    

    public int getFacilityid(){
        return this.facilityid;
    }
    public String getId(){
        return this.id;
    }
    public int getScore(){
        return this.score;
    }
    public String getText(){
        return this.text;
    }
    public int getReviewid(){
        return this.reviewid;
    }
    public String getDate(){
        return this.date;
    }
    
    public void setFacilityid(int facilityid ){
        this.facilityid = facilityid;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setText(String text){
        this.text = text;
    }
    public void setReviewid(int reviewid){
        this.reviewid = reviewid;
    }
    public void setDate(String date){
        this.date = date;
    }
}
