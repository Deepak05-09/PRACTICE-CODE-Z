package Hospital_Management;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Employee implements User
{
   
    private String speciality;
    private Boolean Availability;
     
    Doctor(){

    }

    Doctor(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String speciality,String password){
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
        setSpeciality(speciality);
        setPassword(password);
        Availability=true;
    }
    
    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }
    public void setAvailability(Boolean availability) {
        Availability = availability;
    }
    public String getSpeciality(){
        return speciality;
    }
    public Boolean getAvailability() {
        return Availability;
    }

    @Override
    public void checkIn() {
        ArrayList<Attendance> list=Storage.getAttendanceReport().get(LocalDate.now());
        if(list==null){
            list=new ArrayList<Attendance>();
            list.add(new Attendance(this.getId(),LocalDate.now(), LocalTime.now()));
            Storage.store(list);
        }
        else{
            list.add(new Attendance(this.getId(),LocalDate.now(), LocalTime.now()));
        }
    }
    @Override
    void checkOut() {
        ArrayList<Attendance> list=Storage.getAttendanceReport().get(LocalDate.now());
        for(Attendance attendance: list){
            if(attendance.user_id.equals(this.getId())){
                attendance.checkOut=LocalTime.now();
            }
        }
    }
    
    @Override
    public  Boolean login(String id,String password) {
       if(Storage.existsUser(id)){
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

    public void generatReport(String reportId,String patientId,String reason){
        Report report=new Report();
        report.setId(reportId);
        report.setPatientId(patientId);
        report.setReason(reason);
    }

    public Patient ViewDetails(String patientId){
        return Storage.getPatient(patientId);
    }

    public Doctor Viewprofile(){
        return (Doctor)Storage.getEmployee(this.getId());
    }
   
    public String toString(){
        return "Name:"+getName()+" ID: "+getId()+" PH.NO: "+getPhnNo()+" Date Joined: "+getDateJoined()+" Age: "+getAge()+" Speciality: "+getSpeciality()+"\n";
    }
}