package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.DATA_LAYER.Storage;

public class Doctor extends Employee implements User
{
   
    private String speciality;
    // public boolean[] availability={true,true,true,true,true,true,true};
    //Calendar calendar=new Calendar();
    // public Boolean schedule[]={true,true,true,true,true};
    public HashMap<LocalDate,Appointment[]> appointments;
    

    static int id=2;
    
   
    public Doctor(String name,String id,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String speciality,String password)
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
        setSpeciality(speciality);
        setPassword(password);
        setRole("Doctor");
        //Availability=true;
        appointments=new HashMap<>();
    }

    public static Doctor doc=new Doctor("Deepak", "DR1", "9984362576", null, 27, Sex.MALE, "deepak@gmail.com", "address", "edu ca ti on", "Brain", "Doctor123");
    public static Doctor doc2=new Doctor("Dharshu", "DR2", "6396370162", null, 28, Sex.FEMALE, "dharsu@gmail.com", "address", "edu ca ti on", "Heart", "Doctor123");
    public static Doctor doc3=new Doctor("Deva", "DR3", "9034762798", null, 40, Sex.MALE, "deva@gmail.com", "address", "edu ca ti on", "Dental", "Doctor123");
    public static Doctor doc4=new Doctor("Kaviya", "DR4", "9443661043", null, 33, Sex.FEMALE, "kaviya@gmail.com", "address", "edu ca ti on", "Bone", "Doctor123");
    public static Doctor doc5=new Doctor("Ram", "DR5", "9563986498", null, 45, Sex.MALE, "ram@gmail.com", "address", "edu ca ti on", "Hair", "Doctor123");


    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }

    // public void setAvailability(Boolean availability) {
    //     Availability = availability;
    // }

    public String getSpeciality(){
        return speciality;
    }

    // public Boolean getAvailability() {
    //     return Availability;
    // }

   
    
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

    public void setNonAvailable(LocalDate date){
       
        ArrayList<Doctor> list=Storage.storage.getAvailableDoctors(date);
        if(list!=null){
        list.remove(this);
        Storage.storage.setDoctorAvailability(date, list);
        }
        
    }

    public void generatReport(String patientId,String description,String treatementProvided,String medicine)
    {   
        if(Utils.isPatientExists(patientId))
        {   
            Patient patient=Storage.storage.getPatient(patientId);;
            patient.setReport(new Report(patientId, description, treatementProvided, medicine,this.getName()));
        }


    }

    // public Patient viewPatient(String patientId)
    // {
    //     return Storage.storage.getPatient(patientId);
    // }

    public ArrayList<Report> viewPatientReport(String patientId)
    {
        if(Utils.isPatientExists(patientId))
        {   
            Patient patient=Storage.storage.getPatient(patientId);
            return patient.viewReports();
        }
        return null;
    }

    public Doctor viewProfile()
    {
        return this;
    }
    
    // public boolean isPatientExists(String id)
    // {
    //    return Storage.storage.isPatientExists(id);
    // }
   
    // public String toString()
    // {
    //     return " NAME: "+this.getName()+" ID: "+this.getId()+" ROLE: "+this.getRole()+" AGE: "+this.getAge()+" MAIL: "+this.getMail()+" EDUCATION :"+this.getEducation()+" DATE JOINED :"+this.getDateJoined()+" SEX: "+this.getSex()+" PASSWORD: "+this.getPassword()+" Speciality: "+getSpeciality()+"\n";
    // }
    
    public static Appointment[] ViewAppointment(Doctor doctor, LocalDate date){
        Appointment[] arr=doctor.appointments.get(date);
        if(arr==null){
            doctor.appointments.put(date, new Appointment[5]);
        }
        else{
            return arr;
        }
        return ViewAppointment(doctor, date);
    }

    public Appointment[] viewAppointments(LocalDate date){
         return appointments.get(date);
    }
    public HashMap<LocalDate,Appointment[]> viewAppointments(){
        return appointments;
    }
    
   
    public String toString(){
       
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }
    



}