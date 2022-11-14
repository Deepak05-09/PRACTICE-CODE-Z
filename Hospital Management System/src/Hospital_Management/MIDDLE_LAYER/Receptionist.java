package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Receptionist extends Employee implements User
{
    public static Receptionist receptionist;

    Receptionist(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String Password){
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
        setPassword(Password);
    }
    
    @Override
    public void checkIn() {
        ArrayList<Attendance> list=Storage.storage.getAttendanceReport().get(LocalDate.now());
        if(list==null){
            list=new ArrayList<Attendance>();
            list.add(new Attendance(this.getId(),LocalDate.now(), LocalTime.now()));
            Storage.storage.store(list);
        }
        else{
            list.add(new Attendance(this.getId(),LocalDate.now(), LocalTime.now()));
        }
    }
    @Override
    void checkOut() {
        ArrayList<Attendance> list=Storage.storage.getAttendanceReport().get(LocalDate.now());
        for(Attendance attendance: list){
            if(attendance.user_id.equals(this.getId())){
                attendance.checkOut=LocalTime.now();
            }
        }
    }
    
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

    public void AddPatient(){
        Patient patient=new Patient(Input.name(),"1",Input.age(),Input.sex(), Input.bloodGroup(),Input.weight(), Input.height(),Input.ph_no());
            Storage.storage.store(patient);
    }
    
    public void UpdateDetails(String patientId,String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no){
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
            Available_doctors.add(doctor.getName());
         }
       }
        return Available_doctors;
    }
    public void addVisitors(){
        Visitors visitor=new Visitors(Input.name(),Input.age(), Input.ph_no(),Input.address(),Input.patientId());
          Storage.storage.store(visitor);

        
    }
    public ArrayList<Visitors> showVisitorsList(){
         return Storage.storage.getVisitorList();
    }
    
}