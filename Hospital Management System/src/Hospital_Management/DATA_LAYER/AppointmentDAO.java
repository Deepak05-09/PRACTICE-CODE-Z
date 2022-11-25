package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;

public class AppointmentDAO {
    
    private HashMap<LocalDate,ArrayList<Appointment>> appoinmentsList;

    AppointmentDAO(){
        appoinmentsList=new HashMap<>();
    }


    public void add(Appointment appointment){
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

      //get all appoinments booked by a single patient
    public ArrayList<Appointment> getAppointment(String patientName){
        ArrayList<Appointment> tempList=new ArrayList<>();
        for(int i=0;i<7;i++){
            ArrayList<Appointment> list=appoinmentsList.get(LocalDate.now().plusDays(i));
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
           return appoinmentsList.get(date);
    }
    
    //get appointment by date and name
    public ArrayList<Appointment> getAppointment(LocalDate date,String patientName){
        ArrayList<Appointment> list=appoinmentsList.get(date);

        ArrayList<Appointment> tempList=new ArrayList<>();
        for(Appointment appointment:list){
            if(appointment.getPatientName().equals(patientName)){
                tempList.add(appointment);
            }
        }
        return tempList;
    }

    public  void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
        ArrayList<Appointment> list=appoinmentsList.get(date);
       
        if(list!=null){
            for(Appointment appointment:list){
                if(appointment.getPatientName().equals(name)&&appointment.getTime().equals(time)){
                   list.remove(appointment);
                   break;
                }
            }
        }
       appoinmentsList.replace(date, list);

       Doctor doctor=Storage.doctorList.get(doctorId);
       Appointment[]slot=doctor.appointments.get(date);
       for(int i=0;i<Appointment.slot.length;i++){
             if(Appointment.slot[i].equals(time)){
                slot[i]=null;
                break;
             }
       }

    }


}
