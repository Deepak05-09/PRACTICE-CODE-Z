package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Receptionist extends Employee 
{   
    static int id=2;


    Receptionist(String name,String id,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String Password){
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
        setRole("Receptionist");
        changePassword(Password);
    }
    public static Receptionist rec=new Receptionist("Rec name", "RE1", "7777777777",null, 34, Sex.FEMALE, "receptionist@gmail.com", "rec address", "12th", "Receptionist123");
   

    public void addPatient(String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no,String allergy)
    {
        if(Input.confirmation())
        {
            Patient patient=new Patient(name, age, sex, bloodGroup, weight, height, ph_no,allergy);
            Storage.patientList.add(patient);
        }
    }
    
   

    public Patient search(String patientid)
    {   
        return Storage.patientList.getPatient(patientid);
    }

    public Patient search(String name,String mbl_no){
        return Storage.patientList.get(name, mbl_no);
    }

    

    public void addVisitors()
    {
        Visitors visitor=new Visitors(Input.name(),Input.age(), Input.ph_no(),Input.address(),Input.patientId());
        Storage.storage.store(visitor);
    }


    public ArrayList<Visitors> showVisitorsList()
    {
        return Storage.storage.getVisitorList();
    }


    public  String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }
    
}