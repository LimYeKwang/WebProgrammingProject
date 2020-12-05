
package model;

public class FacilityVO {
    private int facilityid;
    private String name;
    private String managerid;
    private String intro;
    private int sort;
    private String school;
    
    public FacilityVO(){
        System.out.println("FacilityVO is called");
    }
    public FacilityVO(int facilityid, String managerid, String name, String intro,int sort, String school){
        this.facilityid = facilityid;
        this.name = name;
        this.managerid = managerid;
        this.intro = intro;
        this.sort = sort;
        this.school = school;
    }
    

    public int getFacilityid(){
        return this.facilityid;
    }
    public String getName(){
        return this.name;
    }
    public String getManagerid(){
        return this.managerid;
    }
    public String getIntro(){
        return this.intro;
    }
    public int getSort(){
        return this.sort;
    }
    public String getSchool(){
        return this.school;
    }
    
    public void setFacilityid(int facilityid ){
        this.facilityid = facilityid;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setManagerid(String managerid){
        this.managerid = managerid;
    }
    public void setIntro(String intro){
        this.intro = intro;
    }
    public void setSort(int sort){
        this.sort = sort;
    }
    public void setSchool(String school){
        this.school = school;
    }
    
    
}
