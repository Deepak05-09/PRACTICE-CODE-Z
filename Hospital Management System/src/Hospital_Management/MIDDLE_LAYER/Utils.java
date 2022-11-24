package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;

public class Utils {
    

    public static boolean isPatientExists(String id)
    {
       return Storage.storage.isPatientExists(id);
    }

    public static boolean isAdminIdExists(String id){
        return Storage.storage.getAdminList().containsKey(id);
     }
     
     public static boolean isDoctorIdExists(String id){
        return Storage.storage.getDoctorList().containsKey(id);
     }
 
     public static boolean isReceptionistIdExists(String id){
        return Storage.storage.getReceptionistList().containsKey(id);
     }
 
     public static boolean isCashierIdExists(String id){
         return Storage.storage.getCashiersList().containsKey(id);
     }
 
     public static boolean isPatientIdExists(String id){
         return Storage.storage.getUserDetails().containsKey(id);
     }
 
    //  public static boolean isPasswordCorrect(String id,String password)
    //  {  
    //      return Storage.storage.getUserDetails().get(id).equals(password);
    //  }

     public static boolean isPasswordCorrect(String id,String password){
        return Storage.storage.getUserDetails().get(id).getPassword().equals(password);
        //return account.getPassword().equals(password);
     }

    public static ArrayList<Doctor> doctorAvailability(LocalDate date)
    { 
        return Storage.storage.availableDoctors.get(date);
    }

    public static Doctor getDoctor(String id){

        return (Doctor)Storage.storage.getEmployee(id);
   }

    //get all appointment on the given date
    public static ArrayList<Appointment> getAppointment(LocalDate date){
        return  Storage.storage.getAppointment(date);
      }
  
      public static ArrayList<Appointment> getAppointment(LocalDate date,String patientId){
          return Storage.storage.getAppointment(date, patientId);
      }
  
      public static  ArrayList<Appointment> getAppointment(String patientId){
         return Storage.storage.getAppointment(patientId);
      }
  
      public static Appointment[] getAppointment(Doctor doctor, LocalDate date){
          Appointment[] arr=doctor.appointments.get(date);
          if(arr==null){
              doctor.appointments.put(date, new Appointment[5]);
          }
          else{
              return arr;
          }
          return getAppointment(doctor, date);
      }
}
