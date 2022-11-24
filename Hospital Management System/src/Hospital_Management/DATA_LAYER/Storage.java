package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.*;

public class Storage
{   
    // private HashMap<String,Employee> employeeList;
    private HashMap<String,Admin> adminList;
    public  HashMap<String,Doctor> doctorList;
    private  HashMap<String,Receptionist> receptionistList;
    private  HashMap<String,Cashier> cashiersList;
    private  HashMap<String,Account> userDetails;
    // private  ArrayList<Room> roomsList;
    private  HashMap<LocalDate,ArrayList<Attendance>> AttendanceReport;
    private  HashMap<String,Patient> patientList;
    private  ArrayList<Visitors> visitorList;
    public HashMap<LocalDate,ArrayList<Doctor>> availableDoctors;
    public HashMap<LocalDate,ArrayList<Appointment>> appoinmentsList;
    public HashMap<String,Report> reportsList;

    private Storage(){
       // employeeList=new HashMap<>();
        adminList=new HashMap<>();
        doctorList=new HashMap<>();
        receptionistList=new HashMap<>();
        cashiersList=new HashMap<>();
        userDetails=new HashMap<>();
       // roomsList=new ArrayList<>();
        patientList=new HashMap<>();
        visitorList=new ArrayList<>();
        AttendanceReport=new HashMap<>();
        availableDoctors=new HashMap<>();
        appoinmentsList=new HashMap<>();
        reportsList=new HashMap<>();
        this.initialize();
    }

    public static Storage storage=new Storage();
    
    public  void initialize()
    {
        adminList.put(Admin.mainAdmin.getId(),Admin.mainAdmin);
        userDetails.put(Admin.mainAdmin.getId(),new Account(Admin.mainAdmin,Admin.mainAdmin.getPassword()));

        doctorList.put(Doctor.doc.getId(),Doctor.doc);
        doctorList.put(Doctor.doc2.getId(),Doctor.doc2);
        doctorList.put(Doctor.doc3.getId(),Doctor.doc3);
        doctorList.put(Doctor.doc4.getId(),Doctor.doc4);
        doctorList.put(Doctor.doc5.getId(),Doctor.doc5);
        userDetails.put(Doctor.doc.getId(),new Account(Doctor.doc,Doctor.doc.getPassword()));
        userDetails.put(Doctor.doc2.getId(),new Account(Doctor.doc2,Doctor.doc2.getPassword()));
        userDetails.put(Doctor.doc3.getId(),new Account(Doctor.doc3,Doctor.doc3.getPassword()));
        userDetails.put(Doctor.doc4.getId(),new Account(Doctor.doc4,Doctor.doc4.getPassword()));
        userDetails.put(Doctor.doc5.getId(),new Account(Doctor.doc5,Doctor.doc5.getPassword()));

        receptionistList.put(Receptionist.rec.getId(), Receptionist.rec);
        userDetails.put(Receptionist.rec.getId(),new Account(Receptionist.rec,Receptionist.rec.getPassword()));

        userDetails.put(Cashier.cashier2.getId(),new Account(Cashier.cashier2,Cashier.cashier2.getPassword()));
        cashiersList.put(Cashier.cashier2.getId(), Cashier.cashier2);

        patientList.put(Patient.patient1.getId(),Patient.patient1);
        userDetails.put("123",new Account(Patient.patient1,"Patient123"));
        patientList.put(Patient.patient2.getId(),Patient.patient2);
        patientList.put(Patient.patient3.getId(),Patient.patient3);


        
        setAvailableDoctors();
    //    roomsList.add(new Room(Floor.GROUND,1,Name.CONSULTING,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.FIRST,4,Name.ICU,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.SECOND,7,Name.DAY,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.GROUND,2,Name.OPERATING_THEATRE,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.SECOND,8,Name.SICK,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.FIRST,5,Name.DELIVERY,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.GROUND,3,Name.CONSULTING,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.SECOND,9,Name.EMERGENCY,RoomType.SINGLE_AC));
    //    roomsList.add(new Room(Floor.FIRST,6,Name.CONSULTING,RoomType.SINGLE_AC));
    }

    private void setAvailableDoctors() {
        Collection<Doctor> list=doctorList.values();
        ArrayList<Doctor> doctors=new ArrayList<>(list);

        for(int i=0;i<=14;i++){
            availableDoctors.put(LocalDate.now().plusDays(i),doctors);
        }
    }

    public void setDoctorAvailability(LocalDate date,ArrayList<Doctor> doctor){
        availableDoctors.replace(date, doctor);
    }

    public  HashMap<String, Doctor> getDoctorList() {
        return doctorList;
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
    public HashMap<String, Patient> getPatientList() {
        return patientList;
    }
    

   
    public  HashMap<LocalDate, ArrayList<Attendance>> getAttendanceReport() {
        return AttendanceReport;
    }
    // public  ArrayList<Room> getRoomsList() {
    //     return roomsList;
    // }
    
    public  HashMap<String,Account> getUserDetails() {
        return userDetails;
    }

    public  HashMap<String, Admin> getAdminList() {
        return adminList;
    }

    public ArrayList<Doctor> getAvailableDoctors(LocalDate date){
        return availableDoctors.get(date);
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
     
    //stores doctor in doctorlist and in user
    public  void store(Doctor doctor){
        if(!exists(doctor)){
        doctorList.put(doctor.getId(),doctor);
        //addUser(doctor.getId(),doctor.getPassword());
        }
    }

     //stores admin in adminlist and in user
    public  void store(Admin admin){
        if(!exists(admin)){
        adminList.put(admin.getId(),admin);
        //addUser(admin.getId(),admin.getPassword());
        }
    }

     //stores admin in adminlist and in user
    public  void store(Receptionist receptionist){
        if(!exists(receptionist)){
        receptionistList.put(receptionist.getId(),receptionist);
        //addUser(receptionist.getId(),receptionist.getPassword());
        }
    }

     //stores cashier in cashierlist and in user
    public  void store(Cashier cashier){
        if(!exists(cashier)){
        cashiersList.put(cashier.getId(),cashier);
       // addUser(cashier.getId(),cashier);
        }
    }

     //stores Patient in patientlist 
    public  void store(Patient patient){
        if(!exists(patient)){
        patientList.put(patient.getId(),patient);
        }
    }

    //stores visitor in visitorslist
    public  void store(Visitors visitor){
        visitorList.add(visitor);
    }

    //stores appointment by specified date
    public void store(Appointment appointment){
       ArrayList<Appointment> list=appoinmentsList.get(appointment.getDate());
       if(list==null){
        list=new ArrayList<>();
        list.add(appointment);
       }
       else{
        list.add(appointment);
       }
       appoinmentsList.put(appointment.getDate(), list);
    }
    
    //stores user 
    public  void addUser(String id,Account obj){
        userDetails.put(id, obj);
    }

    public  Account getUser(String id){
        return userDetails.get(id);
    }

    // public void addAppointment(LocalDate date,String id){
    //     Doctor doctor=(Doctor)getEmployee(id);
    //     appoinmentsList.put(date,doctor);
    // }
    
    //returns employee if present else returns null
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

    //removes an employee
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
    
    //returns patient if present else null
    public  Patient getPatient(String id){
        if(patientList.containsKey(id)){
            return patientList.get(id);
        }
        return null;
    }

    public boolean isPatientExists(String id){
       return patientList.containsKey(id);
    }
    
    public Patient getPatient(String name,String mbl_no){
        
        ArrayList<Patient> list=new ArrayList<>(patientList.values());
        if(list!=null){
            for(Patient patient:list){
                if(patient.getName().equals(name)&&patient.getPh_no().equals(mbl_no)){
                    return patient;
                }
            }
        }
        return null;
    }

    public ArrayList<Doctor> getDoctor(String name){
        ArrayList<Doctor> list=new ArrayList<>(doctorList.values());
        ArrayList<Doctor> temp=new ArrayList<>();
        if(list!=null){
            for(Doctor doctor:list){
                if(doctor.getName().equalsIgnoreCase(name)){
                    temp.add(doctor);
                }
            }
        }
        return temp;
    }

    public  HashMap<String,Employee> getAllEmployeeDetails(){
        HashMap<String,Employee> allDetails=new HashMap<>();
        allDetails.putAll(adminList);
        allDetails.putAll(cashiersList);
        allDetails.putAll(receptionistList);
        allDetails.putAll(doctorList);
        return allDetails;
    }
    
    //get all appoinments booked by a single patient
    public ArrayList<Appointment> getAppointment(String patientId){
        ArrayList<Appointment> tempList=new ArrayList<>();
        for(int i=0;i<7;i++){
            ArrayList<Appointment> list=appoinmentsList.get(LocalDate.now().plusDays(i));
            if(list!=null){
                for(Appointment appointment:list){
                    if(appointment.getPatientId().equals(patientId)){
                        tempList.add(appointment);
                    }
                }
            }
        }
        return tempList;
    }
    
    //get all appointments in a specified date
    public ArrayList<Appointment> getAppointment(LocalDate date){
           return appoinmentsList.get(date);
    }
    
    //get appointment by date and id
    public ArrayList<Appointment> getAppointment(LocalDate date,String patientId){
        ArrayList<Appointment> list=appoinmentsList.get(date);

        ArrayList<Appointment> tempList=new ArrayList<>();
        for(Appointment appointment:list){
            if(appointment.getPatientId().equals(patientId)){
                tempList.add(appointment);
            }
        }
        return tempList;
    }


    public  void update(Patient patient){
        patientList.replace(patient.getId(), patient);
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
   

    public  void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
        ArrayList<Appointment> list=appoinmentsList.get(date);
       
        if(list!=null){
            for(Appointment appointment:list){
                if(appointment.getPatientId().equals(name)&&appointment.getTime().equals(time)){
                   list.remove(appointment);
                   break;
                }
            }
        }
       appoinmentsList.replace(date, list);

       Doctor doctor=doctorList.get(doctorId);
       Appointment[]slot=doctor.appointments.get(date);
       for(int i=0;i<Appointment.slot.length;i++){
             if(Appointment.slot[i].equals(time)){
                slot[i]=null;
                break;
             }
       }

    }
        

    
}