package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.DoctorDAO;

public class DoctorList {
    

     public static Doctor get(String doctorId){
        return doctorDAO.get(doctorId);
     }
     
     public static ArrayList<Doctor> get(LocalDate date,Department department){
        return doctorDAO.getAvailableDoctors(date, department);
     }
     
     public static ArrayList<Doctor> searchDoctor(String name){
        return doctorDAO.getDoctor(name);
    }

    
    private static DoctorDAO doctorDAO=DoctorDAO.doctorDAO;
}
