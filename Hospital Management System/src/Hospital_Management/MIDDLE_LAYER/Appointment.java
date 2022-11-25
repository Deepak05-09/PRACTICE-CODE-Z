package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;



public class Appointment {
     
    private String patientName;
    private String Pmbl_no;
    private String doctorId;
    private String time;
    private LocalDate date;
    public static final String slot[]={"9:00Am-9:25Am","9:30Am-9:55Am","10:00Am-10:25Am","02:00Pm-02:25Pm","02:30Pm-02:55Am"};
    
    Appointment(String patientName,String mbl_no,String doctorId,int time,LocalDate date){
       this.patientName=patientName;
       this.doctorId=doctorId;
       this.time=slot[time];
       this.date=date;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPmbl_no() {
        return Pmbl_no;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString(){
        return "Patient Name: "+patientName+" Patient number :"+Pmbl_no+" Time"+time+" Doctor Id :"+doctorId;
    }

    public static ArrayList<Appointment> getAppointment(LocalDate date){
        return Storage.appointmentList.getAppointment(date);
     }

     public static ArrayList<Appointment> viewAppointment(String name){
        return Storage.appointmentList.getAppointment(name);
     } 

     public static void createAppointment(LocalDate date,String patientName,String mbl_no,String doctorId,int time)
     {  
        Doctor doctor=Storage.doctorList.get(doctorId);
        Appointment[]slot=doctor.appointments.get(date);
     
         Appointment appointment= new Appointment(patientName,mbl_no, doctorId, time,date);
        slot[time]=appointment;
        doctor.appointments.put(date, slot);
        Storage.appointmentList.add(appointment);
        
     }
     
     public static void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
       Storage.appointmentList.CancelAppointment(date, name, time,doctorId);
     }

     
}
