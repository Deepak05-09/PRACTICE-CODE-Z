package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Receptionist extends Employee implements User
{   
    static int id=2;
    public static Receptionist receptionist;

    Receptionist(String name,String id,String ph_no,Date dob,int age,Sex sex,String mail,String address,String education,String Password){
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
    public  Boolean login(String id,String password) {
       if(Storage.storage.existsUser(id)){
          if(password.equals(getPassword())){
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
    public void changePassword(String password) {
        this.setPassword(password);
    }

    public void addPatient(String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no){
        if(Input.confirmation()){
           Patient patient=new Patient(name, age, sex, bloodGroup, weight, height, ph_no);
           Storage.storage.store(patient);
        }
    }
    
    public void updateDetails(String patientId,String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no){
           Patient patient=Storage.storage.getPatient(patientId);
           if(patient!=null){
           if(name!=null&&!name.equals("")) { patient.setName(name);}
           if(age>0) { patient.setAge(age);}
           if(sex!=null) { patient.setSex(sex);}
           if(bloodGroup!=null) { patient.setBloodgroup(bloodGroup);}
           if(weight>0) { patient.setWeight(weight);}
           if(height>0) { patient.setHeight(height);}
           Storage.storage.update(patient);
           }
    }

    public Patient search(String patientid){
       return Storage.storage.getPatient(patientid);
    }

    public ArrayList<String> doctorAvailability(){
        ArrayList<String> Available_doctors=new ArrayList<>();
        for(Doctor doctor: Storage.storage.getDoctorList().values()){
         if(doctor.getAvailability()==true){
          Available_doctors.add(doctor.getName()+" ID: "+doctor.getId());
         }
       }
     return Available_doctors;
    }
    public void addVisitors(){
        Visitors visitor=new Visitors(Input.name(),Input.age(), Input.ph_no(),Input.address(),Input.patientId());
        Storage.storage.store(visitor);
    }

    public void createAppointment(String patientId,String doctorId,String time){
       Doctor doctor=Storage.storage.doctorList.get(doctorId);
       doctor.appoinments.add(new Appointment(patientId, doctorId, time));
    }

    public ArrayList<Visitors> showVisitorsList(){
         return Storage.storage.getVisitorList();
    }

    public  String toString(){
        return " NAME: "+this.getName()+" ID: "+this.getId()+" ROLE: "+this.getRole()+" AGE: "+this.getAge()+" MAIL: "+this.getMail()+" EDUCATION :"+this.getEducation()+" DATE JOINED :"+this.getDateJoined()+" SEX: "+this.getSex()+" PASSWORD: "+this.getPassword();
    }
    
}