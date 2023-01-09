package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.BillDAO;
import Hospital_Management.DATA_LAYER.DoctorDAO;
import Hospital_Management.DATA_LAYER.PatientDAO;
import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.DATA_LAYER.UserDAO;
import Hospital_Management.UI.Input;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Admin extends Employee
{
     static int id=1;
     

    
    public Admin(String name ,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        setName(name);
        setId("AD"+id++);
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
        if(input.confirmation())
        {
         Admin admin=new Admin(name ,ph_no,dob,age,sex,mail,address,education,password);
         Storage.storage.store(admin);
         userDAO.add(new User(admin));

        }

    }

    public void addDoctor(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,Department speciality,String password,int experience)
    {
        if(input.confirmation())
        {
         Doctor doctor=new Doctor(name, ph_no, dob, age, sex, mail, address, education, speciality, password,experience); 
         userDAO.add(new User(doctor));
         doctorDAO.add(doctor);
        }

    }

    public void addReceptionist(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(input.confirmation())
        {
         Receptionist receptionist=new Receptionist(name, ph_no, dob, age, sex, mail, address, education, password);
         userDAO.add(new User(receptionist));
         Storage.storage.store(receptionist);
        }

    }

    public void addCashier(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        if(input.confirmation())
        {
         Cashier cashier=new Cashier(name, ph_no, dob, age, sex, mail, address, education, password);
         userDAO.add(new User(cashier));
         Storage.storage.store(cashier);
        }

    }

    public String removeEmployee(String id)
    {
        Employee employee=Storage.storage.getEmployee(id);

        if(employee!=null)
        {
         input.print(Storage.storage.getEmployee(id).toString());
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
        return patientDAO.getPatient(id);
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
        return doctorDAO.getDoctor(name);
    }
    
    public ArrayList<Bill> viewBill(String patientId){
        return billDAO.get(patientId);
    }
    public double viewAmount(LocalDate date){
        return billDAO.getAmmount(date);
    }


    
    public String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }

    private DoctorDAO doctorDAO=new DoctorDAO();
    private BillDAO billDAO=new BillDAO();
    private PatientDAO patientDAO=new PatientDAO();
    private UserDAO userDAO=new UserDAO();
    private Input input=new Input();

   
}