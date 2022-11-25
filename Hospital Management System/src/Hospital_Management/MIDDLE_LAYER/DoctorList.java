package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;

public class DoctorList {
    

     public static Doctor get(String doctorId){
        return Storage.doctorList.get(doctorId);
     }
     
     public static ArrayList<Doctor> get(LocalDate date,Department department){
        return Storage.doctorList.getAvailableDoctors(date, department);
     }

}
