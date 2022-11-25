package Hospital_Management.MIDDLE_LAYER;
import java.time.LocalDate;
import java.util.ArrayList;


import Hospital_Management.DATA_LAYER.Storage;

public abstract class Employee 
{
    private String name;
    private  String id;
    private String password;
    private String ph_no;
    private LocalDate joined;
    private LocalDate dateOfBirth;
    private int age;
    private Sex sex;
    private String mail;
    private String address;
    private String education;
    private String role;
    
    
    

    /*-------------------SETTERS-----------------------*/
    public void setName(String name){
        this.name=name;
    }
    public void setId(String id){
        this.id=id;
    }
    public void changePassword(String password){
        this.password=password;
    }
    public void setPhnNo(String ph_no){
        this.ph_no=ph_no;
    }
    public void setDateJoined(LocalDate localDate){
        this.joined=localDate;
    }
    public void setDateOfBirth(LocalDate date){
        this.dateOfBirth=date;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setSex(Sex sex){
        this.sex=sex;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setEducation(String education){
        this.education=education;
    }
    public void setRole(String role){
       this.role=role;
    }
    /*-------------------------------------------*/
    
   /*-------------------GETTERS------------------------*/
    public String getName(){
        return this.name;
    }
    public String getId(){
       return this.id;
    }
    public String getPassword(){
        return this.password;
    }
    public String getPhnNo(){
        return this.ph_no;
    }
    public LocalDate getDateJoined(){
        return this.joined;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public int getAge(){
        return this.age;
    }
    public Sex getSex(){
        return this.sex;
    }
    public String getMail(){
        return this.mail;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEducation(){
        return this.education;
    }
    public String getRole(){
        return this.role;
    }
   
    public Boolean checkIn() 
    {
        if(!isCheckedIn())
        {
            Storage.storage.checkIn(this.getId(),LocalDate.now(),System.currentTimeMillis());
            return true;
        }

        return false;
    }

    
    public boolean checkOut()
     {
        if(isCheckedIn())
        {
            Storage.storage.checkOut(this.getId(),LocalDate.now(),System.currentTimeMillis());
            return true;
        }

        return false;   
    }

    private boolean isCheckedIn()
    {
        ArrayList<Attendance> list=Storage.storage.getAttendanceReport().get(LocalDate.now());

        if(list!=null)
        {
            for(Attendance attendance: list)
            {
                if(attendance.user_id.equals(this.getId()))
                {
                    if(attendance.active==true)
                    {
                        return true;
                    }
                }
            }
        }
    
        return false;
    }
    /*-------------------------------------------*/
}