package Hospital_Management.UI;

import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Patient;

public class DoctorPage {
    
    static void doctorFeatures(){
        Home.employeefeatures();
      print("5. VIEW PATIENT\n6. GENERATE REPORT\n");
      choice();
switch(Input.getFromUser()){
    case "1":{
            print("\n......THANK YOU.....");Home.menu();
             break;
    } 
 case "2":{
            checkIn();
            doctorFeatures();
            break;
   }
 case "3":{
             checkOut();
             doctorFeatures();
             break;
   }
 case "4":{
             print(Doctor.doctor.toString()); 
             doctorFeatures();
             break;
   }
 case "5":{
           viewPatient();
          doctorFeatures();
          break;
   } 
   case "6":{
             Doctor.doctor.generatReport(null, Input.patientId(), Input.reason(), Input.treatementNeeded(), Input.treatementProvided());
             doctorFeatures();
             break;
   }
   default :{
             print("\nInvalid choice....!");
              doctorFeatures();
   }
  
      }
     }
     private static void checkIn(){
      if(Doctor.doctor.checkIn()){
         print("\nSuccessfully Checked In\n");}
         else{
            print("\nYOU HAVE ALREADY CHECKED IN\n");
         }
       }
    
    private static void checkOut(){
      if(Doctor.doctor.checkOut()){
         print("\nSuccessfully Checked Out");
         }
         else{
            print("\nplease Check In to Check Out");
         }
    }
    private static void viewPatient(){
      Patient patient=Doctor.doctor.viewPatient(Input.patientId());
            if(patient!=null){
               print(patient.toString());
            }
            else{
               print("\nNO Patient in That ID");
            }
    }
     private static void print(String string){
        System.out.println(string);
     }
      private static void choice(){
        print("\nEnter Your Choice :\n");
      }
}
