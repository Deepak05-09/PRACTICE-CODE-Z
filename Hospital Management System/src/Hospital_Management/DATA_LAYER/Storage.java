package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
        availableDoctors=new LinkedHashMap<>();
        userDetails=new HashMap<>();
        patientList=new HashMap<>();
        appointmentList=new HashMap<>();
        visitorList=new ArrayList<>();
        AttendanceReport=new HashMap<>();
        reportsList=new HashMap<>();
        billList=new HashMap<>();
        characterInitialise();     
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
     
    

    private void setAvailableDoctors() {
        
        ArrayList<Doctor> doctors=new ArrayList<>(doctorList.values());
        
        for(int i=0;i<=14;i++){
            availableDoctors.put(LocalDate.now().plusDays(i),doctors);
        }

        
    }
    

    private void characterInitialise(){

        Doctor doc1=new Doctor("Eren Yeager", "9462946793", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "doctor@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.CARDIOLOGIST, "Doctor123",2);
        Doctor doc2=new Doctor("Roronoa Zoro", "8956289465", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "zoro@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.NEUROLOGIST, "Doctor123",4);
        Doctor doc3=new Doctor("Edward Elric", "7453219087", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "edward@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PATHOLOGIST, "Doctor123",3);
        Doctor doc4=new Doctor("Ichigo Kurosaki", "9989768340", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "ichigo@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PSYCHIATRIST, "Doctor123",2);
        Doctor doc5=new Doctor("Katsuki Bakugo", "8734426720", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "bakugo@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.DENTIST, "Doctor123",7);
        Doctor doc6=new Doctor("Satorou Gojo", "8352718936", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "gojo@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.CARDIOLOGIST, "Doctor123",6);
        Doctor doc7=new Doctor("Erza Scarlet", "8642576486", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "erza@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.NEUROLOGIST, "Doctor123",4);
        Doctor doc8=new Doctor("Itachi Uchiha", "9743666227", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "itachi@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PATHOLOGIST, "Doctor123",3);
        Doctor doc9=new Doctor("Nishimiya", "9994466260", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "nishi@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PSYCHIATRIST, "Doctor123",1);
        Doctor doc10=new Doctor("Nezuko kamado", "8978654325", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "nezuko@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.DENTIST, "Doctor123",10);
        Doctor doc11=new Doctor("Himiko Toga", "9361334787", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "toga@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.CARDIOLOGIST, "Doctor123",9);
        Doctor doc12=new Doctor("Nico Robin", "9876543768", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "nicorobin@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.NEUROLOGIST, "Doctor123",8);
        Doctor doc13=new Doctor("Mikasa Ackerman", "9872578965", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "mikasa@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PATHOLOGIST, "Doctor123",5);
        Doctor doc14=new Doctor("Madara Uchiha", "9436787609", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "madara@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PSYCHIATRIST, "Doctor123",6);
        Doctor doc15=new Doctor("Kaneki Ken", "9555988840", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "kaneki@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.DENTIST, "Doctor123",4);
        Doctor doc16=new Doctor("Goku", "9995447879", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "goku@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.CARDIOLOGIST, "Doctor123",5);
        Doctor doc17=new Doctor("Rukia Kuchiki", "6398668812", LocalDate.of(1993, 5, 16), 28, Sex.FEMALE, "rukia@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.NEUROLOGIST, "Doctor123",7);
        Doctor doc18=new Doctor("Saitama", "9368712985", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "saitama@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PATHOLOGIST, "Doctor123",3);
        Doctor doc19=new Doctor("Dazai Osamu", "9846879467", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "dazai@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.PSYCHIATRIST, "Doctor123",12);
        Doctor doc20=new Doctor("Yami sukehiro", "9095048371", LocalDate.of(1993, 5, 16), 28, Sex.MALE, "yami@gmail.com", "40\\1,sivagankai,thirukonam,630611", "MBBS", Department.DENTIST, "Doctor123",5);
        doctorList.put(doc1.getId(),doc1);
        doctorList.put(doc2.getId(),doc2);
        doctorList.put(doc3.getId(),doc3);
        doctorList.put(doc4.getId(),doc4);
        doctorList.put(doc5.getId(),doc5);
        doctorList.put(doc6.getId(),doc6);
        doctorList.put(doc7.getId(),doc7);
        doctorList.put(doc8.getId(),doc8);
        doctorList.put(doc9.getId(),doc9);
        doctorList.put(doc10.getId(),doc10);
        doctorList.put(doc11.getId(),doc11);
        doctorList.put(doc12.getId(),doc12);
        doctorList.put(doc13.getId(),doc13);
        doctorList.put(doc14.getId(),doc14);
        doctorList.put(doc15.getId(),doc15);
        doctorList.put(doc16.getId(),doc16);
        doctorList.put(doc17.getId(),doc17);
        doctorList.put(doc18.getId(),doc18);
        doctorList.put(doc19.getId(),doc19);
        doctorList.put(doc20.getId(),doc20);
        userDetails.put(doc1.getMail(),new User(doc1));
        userDetails.put(doc2.getMail(),new User(doc2));
        userDetails.put(doc3.getMail(),new User(doc3));
        userDetails.put(doc4.getMail(),new User(doc4));
        userDetails.put(doc5.getMail(),new User(doc5));
        userDetails.put(doc6.getMail(),new User(doc6));
        userDetails.put(doc7.getMail(),new User(doc7));
        userDetails.put(doc8.getMail(),new User(doc8));
        userDetails.put(doc9.getMail(),new User(doc9));
        userDetails.put(doc10.getMail(),new User(doc10));
        userDetails.put(doc11.getMail(),new User(doc11));
        userDetails.put(doc12.getMail(),new User(doc12));
        userDetails.put(doc13.getMail(),new User(doc13));
        userDetails.put(doc14.getMail(),new User(doc14));
        userDetails.put(doc15.getMail(),new User(doc15));
        userDetails.put(doc16.getMail(),new User(doc16));
        userDetails.put(doc17.getMail(),new User(doc17));
        userDetails.put(doc18.getMail(),new User(doc18));
        userDetails.put(doc19.getMail(),new User(doc19));
        userDetails.put(doc20.getMail(),new User(doc20));

        Admin admin=new Admin("Deepak", "9999999999",  null, 21, Sex.MALE, "admin@gmail.com", "123,Chinniampalayam,Coimbatore", "B.E-ECE", "Admin123");
        adminList.put(admin.getId(), admin);
        userDetails.put(admin.getMail(),new User(admin));

        Cashier cashier=new Cashier("Cashier", "6666666666", null, 37, Sex.FEMALE, "cashier@gmail.com", "addressbndnbd", "B.com", "Cashier123");
        cashiersList.put(cashier.getId(), cashier);
        userDetails.put(cashier.getMail(), new User(cashier));

        Receptionist rec=new Receptionist("Rec name", "7777777777",null, 34, Sex.FEMALE, "receptionist@gmail.com", "rec address", "12th", "Receptionist123");
        receptionistList.put(rec.getId(), rec);
        userDetails.put(rec.getMail(), new User(rec));
        
        Patient patient1=new Patient("Guhan", 23, Sex.MALE, BloodGroup.O_POSITIVE, 67, 167, "9999999999", "Nil");
        Patient patient2=new Patient("Naveen", 26, Sex.MALE, BloodGroup.B_POSITIVE, 61, 170, "9876543210", "peanut");
        Patient patient3=new Patient("Nagul", 50, Sex.MALE, BloodGroup.AB_POSITIVE, 80, 187, "8967532864", "Nil");
        patientList.put(patient1.getId(),patient1);
        patientList.put(patient2.getId(),patient2);
        patientList.put(patient3.getId(),patient3);
        userDetails.put("123",new User("123","Patient123",patient1));
       
    }
    
   
   
    

    
}