package Hospital_Management;

import java.util.Date;
import java.util.HashMap;

public class Admin extends Employee implements User
{
    
    Admin(){ 

    }

    Admin(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String password){
        setName(name);
        setId(id);
        setAge(age);
        setPhnNo(ph_no);
        setDateJoined(joined);
        setDateJoined(dob);
        setSex(sex);
        setMail(mail);
        setAddress(address);
        setEducation(education);
        setPassword(password);
        //Storage.addUser(id);
    }
    
    @Override
    public void checkIn() {
       Storage.checkIn(this.getId());
    }

    @Override
    void checkOut() {
        Storage.checkOut(this.getId());
    }
    
    @Override
    public  Boolean login(String id,String password) {
       if(Storage.existsUser(id)){
          if(password.equals(this.getPassword())){
              return true;
          }
        }
      return false;
    }

    @Override
    public  Boolean logout() {
       return true;
    }

    @Override
    public  void changePassword(String password) {
        this.setPassword(password);
    }
    
    public void createNewAdmin(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String password){
       Admin admin=new Admin(name,id,ph_no,joined,dob,age,sex,mail,address,education,password );
       Storage.store(admin);
       admin=null;
    }

    public void AddDoctor(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String speciality ,String password){
        Doctor doctor=new Doctor(name,id,ph_no,joined,dob,age,sex,mail,address,education,speciality,password );   
        Storage.store(doctor);
        doctor=null;
    }

    public void AddReceptionist(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String password){
        Receptionist receptionist=new Receptionist(name,id,ph_no,joined,dob,age,sex,mail,address,education,password );
        Storage.store(receptionist);
        receptionist=null;
    }

    public void AddCashier(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String password){
        Cashier cashier=new Cashier(name,id,ph_no,joined,dob,age,sex,mail,address,education,password);
        Storage.store(cashier);
        cashier=null;
    }

    public Employee viewEmployee(String id){
        return Storage.getEmployee(id);
    }
    public Patient viewPatient(String id){
        return Storage.getPatient(id);
    }
    
    public HashMap<String,Employee> viewAll(){
        return Storage.getAllEmployeeDetails();
    }

    public HashMap<Integer, Patient> roomStatus(){
        return Storage.getRoomsList();
    }
    
    public String toString(){
        return "Name: "+getName()+" ID: "+getId()+" Role: Admin";
    }

   
}