package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;
//import Hospital_Management.UI.Display;
import Hospital_Management.UI.Input;

import java.util.ArrayList;
import java.util.Date;


public class Admin extends Employee implements User
{
    
   
    public static  Admin admin;

    public static Admin mainAdmin=new Admin("Deepak", "AD1", "9999999999", null, null, 21, Sex.MALE, "deepak@gmail.com", "123,Chinniampalayam,Coimbatore", "B.E-ECE", "Admin123");
    
    public Admin(String name ,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String password){
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
       Storage.storage.checkIn(this.getId());
    }

    @Override
    public void checkOut() {
        Storage.storage.checkOut(this.getId());
    }
    
    @Override
    public  Boolean login(String id,String password) {
       if(Storage.storage.existsUser(id)){
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
    
    public void createNewAdmin(){
       Admin admin=new Admin(Input.name(),"AD2",Input.ph_no(),Input.DateJoined(),Input.dateOfBirth(),Input.age(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
       Storage.storage.store(admin);
       admin=null;
    }

    public void addDoctor(){
        Doctor doctor=new Doctor(Input.name(),"DR2",Input.ph_no(),Input.DateJoined(),Input.dateOfBirth(),Input.age(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.speciality(),Input.password() );   
        Storage.storage.store(doctor);
        doctor=null;
    }

    public void addReceptionist(){
        Receptionist receptionist=new Receptionist(Input.name(),"RE2",Input.ph_no(),Input.DateJoined(),Input.dateOfBirth(),Input.age(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
        Storage.storage.store(receptionist);
        receptionist=null;
    }

    public void addCashier(){
        Cashier cashier=new Cashier(Input.name(),"CA2",Input.ph_no(),Input.DateJoined(),Input.dateOfBirth(),Input.age(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
        Storage.storage.store(cashier);
        cashier=null;
    }
    public String removeEmployee(String id){
        if(Storage.storage.getEmployee(id)!=null){
            Input.print(Storage.storage.getEmployee(id).toString());
            return "Successfully removed";
        }
         return "NO EMPLOYEE FOUND";
    }

    public String viewEmployee(String id){
        return Storage.storage.getEmployee(id).toString();
    }
    public Patient viewPatient(String id){
        return Storage.storage.getPatient(id);
    }
    
    public String viewAll(){
        String s="";
        for(Employee employee:Storage.storage.getAllEmployeeDetails().values()){
            s+=employee+"\n";
        }
        return s;
    }

    public ArrayList<Room> roomStatus(){
        return Storage.storage.getRoomsList();
    }

    public String viewprofile(){
        return this.toString();
    }
    
    public String toString(){
        return "Name: "+this.getName()+" ID: "+this.getId()+" Role: Admin"+" age: "+this.getAge()+" DOB: "+this.getDateOfBirth()+" password: "+this.getPassword()+" sex :"+this.getSex();
    }

   
}