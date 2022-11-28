package Hospital_Management;



import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.UI.HomePage;

public class App {

    
    public static void main(String[] args) throws Exception {
    
      
       
       HomePage homePage=new HomePage();
       homePage.start();
   
    //    Doctor doctor=Doctor.doc;
    //    Appointment[] arr=doctor.ViewAppointment(LocalDate.now().plusDays(0));
    //    System.out.println(arr.toString()); 
     
      
     
      
    }
}
