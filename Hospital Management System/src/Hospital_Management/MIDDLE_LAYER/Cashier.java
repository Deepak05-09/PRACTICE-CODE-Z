package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Cashier extends Employee implements User
{ 
    public static Cashier cashier;
    
    Cashier(String name,String id,String ph_no,Date joined,Date dob,int age,Sex sex,String mail,String address,String education,String password){
        setName(name);
        setId(id);
        setAge(age);
        setPhnNo(ph_no);
        setDateJoined(joined);
        setDateOfBirth(dob);
        setSex(sex);
        setMail(mail);
        setAddress(address);
        setEducation(education);
        setPassword(education);
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
    
    public Bill generateBill(){
        return new Bill(Input.patientId(),Input.roomFees(),Input.consultantFees(),Input.medicineFees(),this.getName());
    }
}