package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Receptionist extends Employee implements User
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
        setPassword(Password);
    }
    public static Receptionist rec=new Receptionist("Rec name", "RE1", "7777777777",null, 34, Sex.FEMALE, "rec@gmail.com", "rec address", "12th", "Receptionist123");
   
   
    
    @Override
    public  Boolean login(String id,String password)
    {
        if(Storage.storage.existsUser(id))
        {
            if(password.equals(getPassword()))
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
    public void changePassword(String password) 
    {
        this.setPassword(password);
    }

    public void addPatient(String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no,String allergy)
    {
        if(Input.confirmation())
        {
            Patient patient=new Patient(name, age, sex, bloodGroup, weight, height, ph_no,allergy);
            Storage.storage.store(patient);
        }
    }
    
    // public void updateDetails(String patientId,String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no)
    // {
    //        Patient patient=Storage.storage.getPatient(patientId);
    //        if(patient!=null){
    //        if(name!=null&&!name.equals("")) { patient.setName(name);}
    //        if(age>0) { patient.setAge(age);}
    //        if(sex!=null) { patient.setSex(sex);}
    //        if(bloodGroup!=null) { patient.setBloodgroup(bloodGroup);}
    //        if(weight>0) { patient.setWeight(weight);}
    //        if(height>0) { patient.setHeight(height);}
    //        Storage.storage.update(patient);
    //        }
    // }

    public Patient search(String patientid)
    {   
        return Storage.storage.getPatient(patientid);
    }

    // public ArrayList<Doctor> doctorAvailability(LocalDate date)
    // {
        
        
    //     return Storage.storage.availableDoctors.get(date);
        
    // }

    public void addVisitors()
    {
        Visitors visitor=new Visitors(Input.name(),Input.age(), Input.ph_no(),Input.address(),Input.patientId());
        Storage.storage.store(visitor);
    }

    public void createAppointment(LocalDate date,String patientId,String doctorId,int time)
    {  
       Doctor doctor=Storage.storage.doctorList.get(doctorId);
       Appointment[]slot=doctor.appointments.get(date);
    
        Appointment appointment= new Appointment(patientId, doctorId, time,date);
       slot[time]=appointment;
       doctor.appointments.put(date, slot);
       Storage.storage.store(appointment);
       
    }
    
    
    
    public  void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
      Storage.storage.CancelAppointment(date, name, time,doctorId);
    }
    
    // //get all appointment on the given date
    // public  ArrayList<Appointment> getAppointment(LocalDate date){
    //   return  Storage.storage.getAppointment(date);
    // }

    // public ArrayList<Appointment> getAppointment(LocalDate date,String patientId){
    //     return Storage.storage.getAppointment(date, patientId);
    // }

    // public ArrayList<Appointment> getAppointment(String patientId){
    //    return Storage.storage.getAppointment(patientId);
    // }

    // public  Appointment[] getAppointment(Doctor doctor, LocalDate date){
    //     Appointment[] arr=doctor.appointments.get(date);
    //     if(arr==null){
    //         doctor.appointments.put(date, new Appointment[5]);
    //     }
    //     else{
    //         return arr;
    //     }
    //     return getAppointment(doctor, date);
    // }

    public ArrayList<Visitors> showVisitorsList()
    {
        return Storage.storage.getVisitorList();
    }

    public boolean isPatientExists(String id){
        return Storage.storage.isPatientExists(id);
    }

    // public Doctor getDoctor(String id){
    //      return (Doctor)Storage.storage.getEmployee(id);
    // }

    public  String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }
    
}