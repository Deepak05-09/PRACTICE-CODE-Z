package Hospital_Management;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

class Storage
{   
    
    private static HashMap<String,Admin> adminList;
    private static HashMap<String,Doctor> doctorList;
    private static HashMap<String,Receptionist> receptionistList;
    private static HashMap<String,Cashier> cashiersList;
    private static ArrayList<String> userDetails;
    private static HashMap<Integer,Patient> roomsList;
    private static HashMap<LocalDate,ArrayList<Attendance>> AttendanceReport;
    private static HashMap<String,Patient> patientList;
    private static ArrayList<Visitors> visitorList;

    Storage(){
        
    }
    
    public static void intialize(){
        adminList=new HashMap<>();
        doctorList=new HashMap<>();
        receptionistList=new HashMap<>();
        cashiersList=new HashMap<>();
        userDetails=new ArrayList<>();
        roomsList=new HashMap<>();
        patientList=new HashMap<>();
        visitorList=new ArrayList<>();

    }
    public static HashMap<String, Doctor> getDoctorList() {
        return doctorList;
    }
    public static ArrayList<Visitors> getVisitorList() {
        return visitorList;
    }

   
    public static HashMap<LocalDate, ArrayList<Attendance>> getAttendanceReport() {
        return AttendanceReport;
    }
    public static HashMap<Integer, Patient> getRoomsList() {
        return roomsList;
    }
    public static ArrayList<String> getUserDetails() {
        return userDetails;
    }

    public static Boolean existsUser(String id){
        return userDetails.contains(id);
    }
    
    private static boolean exists(Doctor doctor){
              return doctorList.containsValue(doctor);
    }
    private static boolean exists(Admin admin){
        return adminList.containsValue(admin);
    }
    private static boolean exists(Receptionist receptionist){
        return receptionistList.containsValue(receptionist);
    }
    private static boolean exists(Cashier cashier){
        return cashiersList.containsValue(cashier);
    }
    private static boolean exists(Patient patient){
        return patientList.containsValue(patient);
    }

    public static void store( ArrayList<Attendance> list) {
        AttendanceReport.put(LocalDate.now(),list);
    }
    public static void store(Doctor doctor){
        if(!exists(doctor)){
        doctorList.put(doctor.getId(),doctor);
        addUser(doctor.getId());
        }
    }
    public static void store(Admin admin){
        if(!exists(admin)){
        adminList.put(admin.getId(),admin);
        addUser(admin.getId());
        }
    }
    public static void store(Receptionist receptionist){
        if(!exists(receptionist)){
        receptionistList.put(receptionist.getId(),receptionist);
        addUser(receptionist.getId());
        }
    }
    public static void store(Cashier cashier){
        if(!exists(cashier)){
        cashiersList.put(cashier.getId(),cashier);
        addUser(cashier.getId());
        }
    }
    public static void store(Patient patient){
        if(!exists(patient)){
        patientList.put(patient.getId(),patient);
        }
    }
    public static void store(Visitors visitor){
        Storage.visitorList.add(visitor);
    }

    public static void addUser(String id){
        Storage.userDetails.add(id);
    }

    public static Employee getEmployee(String id){
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

    public static Patient getPatient(String id){
        if(patientList.containsKey(id)){
            return patientList.get(id);
        }
        return null;
    }

    public static HashMap<String,Employee> getAllEmployeeDetails(){
        HashMap<String,Employee> allDetails=new HashMap<>();
        allDetails.putAll(adminList);
        allDetails.putAll(cashiersList);
        allDetails.putAll(receptionistList);
        allDetails.putAll(cashiersList);
        return allDetails;
    }

    public static void update(Patient patient){
        patientList.replace(patient.getId(), patient);
    }
    
    public static void checkIn(String id){
        ArrayList<Attendance> list=Storage.getAttendanceReport().get(LocalDate.now());
        if(list==null){
            list=new ArrayList<Attendance>();
            list.add(new Attendance(id,LocalDate.now(), LocalTime.now()));
            Storage.store(list);
        }
        else{
            list.add(new Attendance(id,LocalDate.now(), LocalTime.now()));
        }
    }

    public static void checkOut(String id){
        ArrayList<Attendance> list=Storage.getAttendanceReport().get(LocalDate.now());
        for(Attendance attendance: list){
            if(attendance.user_id.equals(id)){
                attendance.checkOut=LocalTime.now();
            }
        }
    }
   
    
}