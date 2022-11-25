package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Admin extends Employee
{
     static int id=2;

    public static Admin mainAdmin=new Admin("Deepak", "AD1", "9999999999",  null, 21, Sex.MALE, "admin@gmail.com", "123,Chinniampalayam,Coimbatore", "B.E-ECE", "Admin123");
    
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
        changePassword(password);
        setRole("Admin");
    }
    
    public void createNewAdmin(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(Input.confirmation())
        {
         Admin admin=new Admin(name ,"AD"+id,ph_no,dob,age,sex,mail,address,education,password);
         Storage.storage.store(admin);
         Storage.userDetails.add(new User(admin));

        }

    }

    public void addDoctor(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,Department speciality,String password)
    {
        if(Input.confirmation())
        {
         Doctor doctor=new Doctor(name,"DR"+Doctor.id++, ph_no, dob, age, sex, mail, address, education, speciality, password); 
         Storage.userDetails.add(new User(doctor));
         Storage.doctorList.add(doctor);
        }

    }

    public void addReceptionist(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(Input.confirmation())
        {
         Receptionist receptionist=new Receptionist(name,"RE"+Receptionist.id++, ph_no, dob, age, sex, mail, address, education, password);
         Storage.userDetails.add(new User(receptionist));
         Storage.storage.store(receptionist);
        }

    }

    public void addCashier(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(Input.confirmation())
        {
         Cashier cashier=new Cashier(name,"CA"+Cashier.id++, ph_no, dob, age, sex, mail, address, education, password);
         Storage.userDetails.add(new User(cashier));
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
        return Storage.patientList.getPatient(id);
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

    public String viewprofile()
    {
        return this.toString();
    }

    public HashMap<LocalDate, ArrayList<Attendance>> viewAttendanceReport()
    {
        return Storage.storage.getAttendanceReport();
    }

    public ArrayList<Doctor> searchDoctor(String name){
        return Storage.doctorList.getDoctor(name);
    }
    
    public String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }

   
}