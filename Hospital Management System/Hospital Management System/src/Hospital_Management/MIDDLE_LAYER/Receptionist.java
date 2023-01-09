package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.PatientDAO;
import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Receptionist extends Employee 
{   
    static int id=1;


    public Receptionist(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String Password){
        setName(name);
        setId("RE"+id++);
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


    public void addPatient(String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no,String allergy)
    {
        if(input.confirmation())
        {
            Patient patient=new Patient(name, age, sex, bloodGroup, weight, height, ph_no,allergy);
            patientDAO.add(patient);
        }
    }

    public ArrayList<Patient> search(String search){
        return patientDAO.get(search);
    }


    public void addVisitors(String name,int age,String mbl,String address,String id)
    {
        Visitors visitor=new Visitors(name, age, mbl, address, id);
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

    private PatientDAO patientDAO=new PatientDAO();
    private Input input=new Input();
}