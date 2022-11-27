package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.*;

public class Storage
{   
   
     HashMap<String,Admin> adminList;
     HashMap<String,Receptionist> receptionistList;
      HashMap<String,Cashier> cashiersList;
      HashMap<String,Doctor> doctorList;
     HashMap<LocalDate,ArrayList<Doctor>> availableDoctors;
      HashMap<LocalDate,ArrayList<Attendance>> AttendanceReport;
     HashMap<String,User> userDetails;
     HashMap<String,Patient> patientList;
      ArrayList<Visitors> visitorList;
     HashMap<String,Report> reportsList;
     HashMap<LocalDate,ArrayList<Appointment>> appointmentList;
     HashMap<LocalDate,ArrayList<Bill>> billList;

    private Storage(){
       
        adminList=new HashMap<>();
        receptionistList=new HashMap<>();
        cashiersList=new HashMap<>();
        doctorList=new HashMap<>();
        availableDoctors=new HashMap<>();
        userDetails=new HashMap<>();
        patientList=new HashMap<>();
        appointmentList=new HashMap<>();
        visitorList=new ArrayList<>();
        AttendanceReport=new HashMap<>();
        reportsList=new HashMap<>();
        billList=new HashMap<>();
        initialise();
        setAvailableDoctors();
    }

    public static Storage storage=new Storage();
    
    
    

   
    public  ArrayList<Visitors> getVisitorList() {
        return visitorList;
    }
    public HashMap<String, Receptionist> getReceptionistList() {
        return receptionistList;
    }
    public HashMap<String, Cashier> getCashiersList() {
        return cashiersList;
    }
    public  HashMap<LocalDate, ArrayList<Attendance>> getAttendanceReport() {
        return AttendanceReport;
    }
   

    public  HashMap<String, Admin> getAdminList() {
        return adminList;
    }
   

    public  void store( ArrayList<Attendance> list) {
        AttendanceReport.put(LocalDate.now(),list);
    }
     
    public  void store(Admin admin){
        adminList.put(admin.getId(),admin);
    }

    public  void store(Receptionist receptionist){
        receptionistList.put(receptionist.getId(),receptionist);
    }

    public  void store(Cashier cashier){
        cashiersList.put(cashier.getId(),cashier);
    }

    public  void store(Visitors visitor){
        visitorList.add(visitor);
    }

    public Employee getEmployee(String id){
        
        if(adminList.containsKey(id)){
            return adminList.get(id);
        }
        if(doctorList.containsKey(id)){
            return doctorList.get(id);
        }
        if(receptionistList.containsKey(id)){
            return receptionistList.get(id);
        }
        if(cashiersList.containsKey(id)){
            return cashiersList.get(id);
        }
        return null;
    }

    public void removeEmployee(String id){
        if(adminList.containsKey(id)){
           adminList.remove(id);
        }
        if(doctorList.containsKey(id)){
            doctorList.remove(id);
        }
        if(receptionistList.containsKey(id)){
            receptionistList.remove(id);
        }
        if(cashiersList.containsKey(id)){
            cashiersList.remove(id);
        }
        userDetails.remove(id);
    }

    public  HashMap<String,Employee> getAllEmployeeDetails(){
        HashMap<String,Employee> allDetails=new HashMap<>();
        allDetails.putAll(adminList);
        allDetails.putAll(cashiersList);
        allDetails.putAll(receptionistList);
        allDetails.putAll(doctorList);
        return allDetails;
    }
    
    public  void checkIn(String id,LocalDate date,long time){
        ArrayList<Attendance> list=AttendanceReport.get(date);
        if(list==null){
            list=new ArrayList<>();
            list.add(new Attendance(id,date,time));
            store(list);
        }
        else{
            list.add(new Attendance(id,date, time));
        }
    }


    public  void checkOut(String id,LocalDate date,long time){
        ArrayList<Attendance> list=AttendanceReport.get(date);
        for(Attendance attendance: list){
            if(attendance.user_id.equals(id)){
                attendance.checkOut=time;
                attendance.active=false;
            }
        }
        
    }
     
    void initialise(){
        doctorList.put(Doctor.doc.getId(),Doctor.doc);
        doctorList.put(Doctor.doc2.getId(),Doctor.doc2);
        doctorList.put(Doctor.doc3.getId(),Doctor.doc3);
        doctorList.put(Doctor.doc4.getId(),Doctor.doc4);
        doctorList.put(Doctor.doc5.getId(),Doctor.doc5);
        Doctor doc=new Doctor("Infant Akash", "DR6", "9361334787", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "infant@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.CARDIOLOGIST, "Doctor123");
        doctorList.put(doc.getId(),doc);
        Doctor doc1=new Doctor("Saravanan", "DR7", "9364787386", LocalDate.of(1994, 8, 26), 27, Sex.MALE, "saro@gmail.com", "76\\8,veppur,cuddalore,640512", "MBBS", Department.NEUROLOGIST, "Doctor123");
        doctorList.put(doc1.getId(),doc1);
        patientList.put(Patient.patient1.getId(),Patient.patient1);
        patientList.put(Patient.patient2.getId(),Patient.patient2);
        patientList.put(Patient.patient3.getId(),Patient.patient3);

      userDetails.put(Doctor.doc.getMail(),new User(Doctor.doc));
      userDetails.put(Doctor.doc2.getMail(),new User(Doctor.doc2));
      userDetails.put(Doctor.doc3.getMail(),new User(Doctor.doc3));
      userDetails.put(Doctor.doc4.getMail(),new User(Doctor.doc4));
      userDetails.put(Doctor.doc.getMail(),new User(Doctor.doc5));
      userDetails.put(Admin.mainAdmin.getMail(),new User(Admin.mainAdmin));
      userDetails.put(Receptionist.rec.getMail(),new User(Receptionist.rec));
      userDetails.put(Cashier.cashier2.getMail(),new User(Cashier.cashier2));
      userDetails.put("123",new User("123","Patient123",Patient.patient1));
       adminList.put(Admin.mainAdmin.getId(),Admin.mainAdmin);
       receptionistList.put(Receptionist.rec.getId(), Receptionist.rec);
       cashiersList.put(Cashier.cashier2.getId(), Cashier.cashier2);
       
    }

    private void setAvailableDoctors() {
        
        ArrayList<Doctor> doctors=new ArrayList<>(doctorList.values());
        
        for(int i=0;i<=14;i++){
            availableDoctors.put(LocalDate.now().plusDays(i),doctors);
        }
    }

    

    
}