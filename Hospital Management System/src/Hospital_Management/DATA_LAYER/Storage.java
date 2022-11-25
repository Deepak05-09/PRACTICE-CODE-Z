package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.*;

public class Storage
{   
   
    private HashMap<String,Admin> adminList;
   
    private  HashMap<String,Receptionist> receptionistList;
    private  HashMap<String,Cashier> cashiersList;
    private  HashMap<LocalDate,ArrayList<Attendance>> AttendanceReport;
    private  ArrayList<Visitors> visitorList;
    public HashMap<String,Report> reportsList;

    private Storage(){
       
        adminList=new HashMap<>();
        receptionistList=new HashMap<>();
        cashiersList=new HashMap<>();
        visitorList=new ArrayList<>();
        AttendanceReport=new HashMap<>();
        reportsList=new HashMap<>();
        this.initialize();
    }

    public static Storage storage=new Storage();
    public static AppointmentDAO appointmentList=new AppointmentDAO();
    public static DoctorDAO doctorList=new DoctorDAO();
    public static PatientDAO patientList=new PatientDAO();
    public static UserDAO userDetails=new UserDAO();
    
    public  void initialize()
    {
        adminList.put(Admin.mainAdmin.getId(),Admin.mainAdmin);
        receptionistList.put(Receptionist.rec.getId(), Receptionist.rec);
        cashiersList.put(Cashier.cashier2.getId(), Cashier.cashier2);
    }

   
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
        if(doctorList.isExist(id)){
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
        if(doctorList.isExist(id)){
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
        allDetails.putAll(doctorList.getAll());
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
   

    

    
}