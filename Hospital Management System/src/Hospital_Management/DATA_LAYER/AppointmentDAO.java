package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;


import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Slot;

public class AppointmentDAO {
    
   

    public AppointmentDAO(){
       
    }

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
    
    
    public ArrayList<Appointment> getAppointment(LocalDate date){
           return  Storage.storage.appointmentList.get(date);
    }
    
    
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
       Slot[] slot=doctor.ViewAppointment(date);
       for(int i=0;i<slot.length;i++){
          String T[]=time.split("-");
             if(slot[i].startTime.equals(T[0])&&slot[i].endTime.equals(T[1])){
                slot[i].appointment=null;
                break;
             }
       }

    }


}
