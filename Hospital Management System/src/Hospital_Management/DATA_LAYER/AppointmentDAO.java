package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;


import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;

public class AppointmentDAO {
    
   

    private AppointmentDAO(){
       
    }

    public static AppointmentDAO appointmentDAO=new AppointmentDAO();


    public void add(Appointment appointment){
        ArrayList<Appointment> list= Storage.storage.appointmentList.get(appointment.getDate());
        if(list==null){
         list=new ArrayList<>();
         list.add(appointment);
        }
        else{
         list.add(appointment);
        }
        Storage.storage.appointmentList.put(appointment.getDate(), list);
     }

      //get all appoinments booked by a single patient
    public ArrayList<Appointment> getAppointment(String patientName){
        ArrayList<Appointment> tempList=new ArrayList<>();
        for(int i=0;i<7;i++){
            ArrayList<Appointment> list= Storage.storage.appointmentList.get(LocalDate.now().plusDays(i));
            if(list!=null){
                for(Appointment appointment:list){
                    if(appointment.getPatientName().equals(patientName)){
                        tempList.add(appointment);
                    }
                }
            }
        }
        return tempList;
    }
    
    //get all appointments in a specified date
    public ArrayList<Appointment> getAppointment(LocalDate date){
           return  Storage.storage.appointmentList.get(date);
    }
    
    //get appointment by date and name
    public ArrayList<Appointment> getAppointment(LocalDate date,String patientName){
        ArrayList<Appointment> list= Storage.storage.appointmentList.get(date);

        ArrayList<Appointment> tempList=new ArrayList<>();
        for(Appointment appointment:list){
            if(appointment.getPatientName().equals(patientName)){
                tempList.add(appointment);
            }
        }
        return tempList;
    }

    public  void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
        ArrayList<Appointment> list= Storage.storage.appointmentList.get(date);
       
        if(list!=null){
            for(Appointment appointment:list){
                if(appointment.getPatientName().toLowerCase().equals(name.toLowerCase())&&appointment.getTime().equals(time)){
                   list.remove(appointment);
                   break;
                }
            }
        }
        Storage.storage.appointmentList.replace(date, list);

       Doctor doctor= Storage.storage.doctorList.get(doctorId);
       Appointment[]slot=doctor.appointments.get(date);
       for(int i=0;i<Appointment.slot.length;i++){
             if(Appointment.slot[i].equals(time)){
                slot[i]=null;
                break;
             }
       }

    }


}
