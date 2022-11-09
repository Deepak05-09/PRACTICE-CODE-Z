package Hospital_Management;

import java.util.ArrayList;

public class Patient
{
    private String name;
    private String id;
    private int age;
    private Sex sex;
    private BloodGroup Bloodgroup;
    private int weight;
    private int height;
    private String ph_no;
    private ArrayList<String> allergyTo;
    private Report report;

    Patient(String name,String id,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no){
        this.id=id;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.Bloodgroup=bloodGroup;
        this.height=height;
        this.weight=weight;
        this.ph_no=ph_no;
    }
    
    /*-----------------SETTERS--------------------------*/
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public void setBloodgroup(BloodGroup bloodtype) {
        Bloodgroup = bloodtype;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
    public void setAllergyTo(ArrayList<String> allergyTo) {
        this.allergyTo = allergyTo;
    }
    public void setReport(Report report) {
        this.report = report;
    }
    
    /*------------------GETTERS-------------------------*/
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public Sex getSex() {
        return sex;
    }
    public BloodGroup getBloodtype() {
        return Bloodgroup;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public String getPh_no() {
        return ph_no;
    }
    public ArrayList<String> getAllergyTo() {
        return allergyTo;
    }
    public Report getReport() {
        return report;
    }
    /*-------------------------------------------*/
}