package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.*;
import Hospital_Management.MIDDLE_LAYER.Room.Floor;
import Hospital_Management.MIDDLE_LAYER.Room.Name;
import Hospital_Management.MIDDLE_LAYER.Room.RoomType;

public class Storage
{   
    
    public  HashMap<String,Admin> adminList;
    public  HashMap<String,Doctor> doctorList;
    private  HashMap<String,Receptionist> receptionistList;
    private  HashMap<String,Cashier> cashiersList;
    public  HashMap<String,String> userDetails;
    public  ArrayList<Room> roomsList;
    private  HashMap<LocalDate,ArrayList<Attendance>> AttendanceReport;
    private  HashMap<String,Patient> patientList;
    private  ArrayList<Visitors> visitorList;

    private Storage(){
        adminList=new HashMap<>();
        doctorList=new HashMap<>();
        receptionistList=new HashMap<>();
        cashiersList=new HashMap<>();
        userDetails=new HashMap<>();
        roomsList=new ArrayList<>();
        patientList=new HashMap<>();
        visitorList=new ArrayList<>();
        AttendanceReport=new HashMap<>();
       
        this.initialize();
    }
    public static Storage storage=new Storage();
    
    public  void initialize(){
        adminList.put(Admin.mainAdmin.getId(),Admin.mainAdmin);
        userDetails.put(Admin.mainAdmin.getId(),Admin.mainAdmin.getPassword());
        doctorList.put(Doctor.doc.getId(),Doctor.doc);
        userDetails.put(Doctor.doc.getId(),Doctor.doc.getPassword());
        receptionistList.put(Receptionist.rec.getId(), Receptionist.rec);
        userDetails.put(Receptionist.rec.getId(),Receptionist.rec.getPassword());
        userDetails.put(Cashier.cashier2.getId(),Cashier.cashier2.getPassword());
        cashiersList.put(Cashier.cashier2.getId(), Cashier.cashier2);
       roomsList.add(new Room(Floor.GROUND,1,Name.CONSULTING,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.FIRST,4,Name.ICU,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.SECOND,7,Name.DAY,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.GROUND,2,Name.OPERATING_THEATRE,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.SECOND,8,Name.SICK,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.FIRST,5,Name.DELIVERY,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.GROUND,3,Name.CONSULTING,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.SECOND,9,Name.EMERGENCY,RoomType.SINGLE_AC));
       roomsList.add(new Room(Floor.FIRST,6,Name.CONSULTING,RoomType.SINGLE_AC));
        }

    

    public  HashMap<String, Doctor> getDoctorList() {
        return doctorList;
    }
    public  ArrayList<Visitors> getVisitorList() {
        return visitorList;
    }

   
    public  HashMap<LocalDate, ArrayList<Attendance>> getAttendanceReport() {
        return AttendanceReport;
    }
    public  ArrayList<Room> getRoomsList() {
        return roomsList;
    }
    public  HashMap<String,String> getUserDetails() {
        return userDetails;
    }
    public  HashMap<String, Admin> getAdminList() {
        return adminList;
    }

    public  Boolean existsUser(String id){
        if(!userDetails.isEmpty()){
            return userDetails.containsKey(id);
        }
    return false;
    }
    
    private  boolean exists(Doctor doctor){
        if(doctorList.values()!=null){
              return doctorList.containsValue(doctor);
            }
        return false;
    }
    private  boolean exists(Admin admin){
        if(adminList.values()!=null){
            return adminList.containsValue(admin);
          }
      return false;
       
    }
    private  boolean exists(Receptionist receptionist){
        if(receptionistList.values()!=null){
            return receptionistList.containsValue(receptionist);
          }
      return false;
    }
    private  boolean exists(Cashier cashier){
        if(cashiersList.values()!=null){
            return cashiersList.containsValue(cashier);
          }
      return false;
    }
    private  boolean exists(Patient patient){
        if(patientList.values()!=null){
            return patientList.containsValue(patient);
          }
      return false;
    }

    public  void store( ArrayList<Attendance> list) {
        AttendanceReport.put(LocalDate.now(),list);
    }
    public  void store(Doctor doctor){
        if(!exists(doctor)){
        doctorList.put(doctor.getId(),doctor);
        addUser(doctor.getId(),doctor.getPassword());
        }
    }
    public  void store(Admin admin){
        if(!exists(admin)){
        adminList.put(admin.getId(),admin);
        addUser(admin.getId(),admin.getPassword());
        }
    }
    public  void store(Receptionist receptionist){
        if(!exists(receptionist)){
        receptionistList.put(receptionist.getId(),receptionist);
        addUser(receptionist.getId(),receptionist.getPassword());
        }
    }
    public  void store(Cashier cashier){
        if(!exists(cashier)){
        cashiersList.put(cashier.getId(),cashier);
        addUser(cashier.getId(),cashier.getPassword());
        }
    }
    public  void store(Patient patient){
        if(!exists(patient)){
        patientList.put(patient.getId(),patient);
        }
    }
    public  void store(Visitors visitor){
        visitorList.add(visitor);
    }

    public  void addUser(String id,String password){
        userDetails.put(id, password);
    }

    public Employee getEmployee(String id){
        
        if(id.contains("AD")){
            return adminList.get(id);
        }
        if(id.contains("DR")){
            return doctorList.get(id);
        }
        if(id.contains("RE")){
            return receptionistList.get(id);
        }
        if(id.contains("CA")){
            return cashiersList.get(id);
        }
        return null;
    }
    public void removeEmployee(String id){
        if(id.contains("AD")){
           adminList.remove(id);
        }
        if(id.contains("DR")){
            doctorList.remove(id);
        }
        if(id.contains("RE")){
            receptionistList.remove(id);
        }
        if(id.contains("CA")){
            cashiersList.remove(id);
        }
    }

    public  Patient getPatient(String id){
        if(patientList.containsKey(id)){
            return patientList.get(id);
        }
        return null;
    }

    public  HashMap<String,Employee> getAllEmployeeDetails(){
        HashMap<String,Employee> allDetails=new HashMap<>();
        allDetails.putAll(adminList);
        allDetails.putAll(cashiersList);
        allDetails.putAll(receptionistList);
        allDetails.putAll(doctorList);
        return allDetails;
    }

    public  void update(Patient patient){
        patientList.replace(patient.getId(), patient);
    }
    
    public  void checkIn(String id){
        ArrayList<Attendance> list=AttendanceReport.get(LocalDate.now());
        if(list==null){
            list=new ArrayList<>();
            list.add(new Attendance(id,LocalDate.now(), LocalTime.now()));
            store(list);
        }
        else{
            list.add(new Attendance(id,LocalDate.now(), LocalTime.now()));
        }
    }


    public  void checkOut(String id){
        ArrayList<Attendance> list=AttendanceReport.get(LocalDate.now());
        for(Attendance attendance: list){
            if(attendance.user_id.equals(id)){
                attendance.checkOut=LocalTime.now();
            }
        }
        
    }
   
    
}