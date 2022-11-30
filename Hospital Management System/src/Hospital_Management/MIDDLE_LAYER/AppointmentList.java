package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.AppointmentDAO;
import Hospital_Management.DATA_LAYER.DoctorDAO;

public class AppointmentList {
    
    public  ArrayList<Appointment> getAppointment(LocalDate date){
        return appointmentDAO.getAppointment(date);
     }

     public  ArrayList<Appointment> viewAppointment(String name){
        return appointmentDAO.getAppointment(name);
     } 

     public  void createAppointment(LocalDate date,String patientName,String mbl_no,String doctorId,int time)
     {  
        Doctor doctor=doctorDAO.get(doctorId);
        Slot[]slot=doctor.ViewAppointment(date);
     
        Appointment appointment= new Appointment(patientName,mbl_no, doctorId,slot[time].startTime+"-"+slot[time].endTime,date);
        slot[time].appointment=appointment;
        doctor.setAppointments(date, slot);
        appointmentDAO.add(appointment);
        
     }
     
     public  void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
        appointmentDAO.CancelAppointment(date, name, time,doctorId);
     }

     private  AppointmentDAO appointmentDAO=new AppointmentDAO();
     private  DoctorDAO doctorDAO=new DoctorDAO();
}
