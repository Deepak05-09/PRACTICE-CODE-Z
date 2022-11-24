package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Admin extends Employee implements User
{
     static int id=2;
   
    

    public static Admin mainAdmin=new Admin("Deepak", "AD1", "9999999999",  null, 21, Sex.MALE, "deepak@gmail.com", "123,Chinniampalayam,Coimbatore", "B.E-ECE", "Admin123");
    
    public Admin(String name ,String id,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        setName(name);
        setId(id);
        setAge(age);
        setPhnNo(ph_no);
        setDateJoined(LocalDate.now());
        setDateOfBirth(dob);
        setSex(sex);
        setMail(mail);
        setAddress(address);
        setEducation(education);
        setPassword(password);
        setRole("Admin");
    }
    
   
    
    @Override
    public  Boolean login(String id,String password)
    {
       if(Storage.storage.existsUser(id))
       {
          if(password.equals(this.getPassword()))
          {
            return true;
          }
        }

      return false;
    }

    @Override
    public  Boolean logout() 
    {
       return true;
    }

    @Override
    public  void changePassword(String password) 
    {
        this.setPassword(password);
    }
    
    public void createNewAdmin(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(Input.confirmation())
        {
         Admin admin=new Admin(name ,"AD"+id,ph_no,dob,age,sex,mail,address,education,password);
         Account account=new Account(admin, password);
         Storage.storage.store(admin);
         Storage.storage.addUser(admin.getId(),account);

        }

    }

    public void addDoctor(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String speciality,String password)
    {
        if(Input.confirmation())
        {
         Doctor doctor=new Doctor(name,"DR"+Doctor.id++, ph_no, dob, age, sex, mail, address, education, speciality, password); 
         Account account=new Account(doctor, password);
         Storage.storage.addUser(doctor.getId(),account);
         Storage.storage.store(doctor);
        }

    }

    public void addReceptionist(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(Input.confirmation())
        {
         Receptionist receptionist=new Receptionist(name,"RE"+Receptionist.id++, ph_no, dob, age, sex, mail, address, education, password);
         Account account=new Account(receptionist, password);
         Storage.storage.addUser(receptionist.getId(),account);
         Storage.storage.store(receptionist);
        }

    }

    public void addCashier(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(Input.confirmation())
        {
         Cashier cashier=new Cashier(name,"CA"+Cashier.id++, ph_no, dob, age, sex, mail, address, education, password);
         Account account=new Account(cashier, password);
         Storage.storage.addUser(cashier.getId(),account);
         Storage.storage.store(cashier);
        }

    }

    public String removeEmployee(String id)
    {
        Employee employee=Storage.storage.getEmployee(id);

        if(employee!=null)
        {
         Input.print(Storage.storage.getEmployee(id).toString());
         Storage.storage.removeEmployee(id);
         return "Successfully removed";
        }

        return "NO EMPLOYEE FOUND";
    }

    public Employee viewEmployee(String id)
    {
        return Storage.storage.getEmployee(id);
    }

    public Patient viewPatient(String id)
    {
        return Storage.storage.getPatient(id);
    }
    
    public  ArrayList<Employee>viewAll()
    {
       ArrayList<Employee> list=new ArrayList<>();
        for(Employee employee:Storage.storage.getAllEmployeeDetails().values())
        {
          list.add(employee);
        }

        return list;
    }

    // public ArrayList<Room> roomStatus()
    // {
    //     return Storage.storage.getRoomsList();
    // }

    public String viewprofile()
    {
        return this.toString();
    }

    public HashMap<LocalDate, ArrayList<Attendance>> viewAttendanceReport()
    {
        return Storage.storage.getAttendanceReport();
    }

    // public static boolean confirmation(boolean value){
    //     return value;
    // }

    public ArrayList<Appointment> getAppointment(LocalDate date){
       return Storage.storage.getAppointment(date);
    }

    public ArrayList<Doctor> searchDoctor(String name){
        return Storage.storage.getDoctor(name);
    }
    
    public String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }

   
}