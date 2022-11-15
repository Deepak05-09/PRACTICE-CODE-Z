package Hospital_Management.UI;

import java.util.ArrayList;

import Hospital_Management.MIDDLE_LAYER.Receptionist;
import Hospital_Management.MIDDLE_LAYER.Visitors;

public class ReceptionistPage {
    
    static void receptionistFeatures(){
        Home.employeefeatures();
      print("5. ADD PATIENT\n6. UPDATE PATIENT DETAILS\n7. DOCTOR AVAILABILITY\n8. VISITOR ENTRY\n9. VIEW VISITORS LIST\n10.CREATE APPOINTMENT\n");
      choice();
      switch(Input.getFromUser()){
        
            case "1":{
                      print("\n......THANK YOU.....");Home.menu(); break;
                     } 
           case "2":{
                      checkIn();
                      receptionistFeatures();
                      break;
                    }
           case "3":{
                      checkOut();
                      receptionistFeatures();
                      break;
                    }
           case "4":{
                       print(Receptionist.receptionist.toString()); 
                       receptionistFeatures();
                       break;
                    }
        case "5":{
                  Receptionist.receptionist.addPatient(Input.name(),Input.age(),Input.sex(), Input.bloodGroup(), Input.weight(), Input.height(), Input.ph_no());
                  receptionistFeatures();
                 }break;
        case "6":{
                  Receptionist.receptionist.updateDetails(null, null, 0, null, null, 0, 0, null);
                  receptionistFeatures();
                 }break;
        case "7":{
                 doctorAvailability();
                 }receptionistFeatures();break;
        case "8":{
                  Receptionist.receptionist.addVisitors();receptionistFeatures();
                 }break;
        case "9":{
                  visitorList();
                  receptionistFeatures();
                  break;
                 }
         case "10":{
                   doctorAvailability();
                   Receptionist.receptionist.createAppointment(Input.patientId(), Input.doctorId(), Input.time());
                   print("Appointment created");
                   receptionistFeatures();
         }
        default :{
                  print("\nInvalid choice....!");
                  receptionistFeatures(); 
        }
      }
     }
     
     private static void checkIn(){
      if(Receptionist.receptionist.checkIn()){
         print("\nSuccessfully Checked In\n");}
         else{
            print("\nYOU HAVE ALREADY CHECKED IN\n");
         }
       }
    
    private static void checkOut(){
      if(Receptionist.receptionist.checkOut()){
         print("\nSuccessfully Checked Out");
         }
         else{
            print("\nplease Check In to Check Out");
         }
    }

    private static void doctorAvailability(){
      ArrayList<String> list=Receptionist.receptionist.doctorAvailability();
      if(!list.isEmpty()){
        print("\nAvailable Doctor(s) is/are\n");
      for(String name:Receptionist.receptionist.doctorAvailability()){
        print(name);
        }
       }
       else{
        print("\nNo Doctors Currently Available");
       }
    }

    private static void visitorList(){
      ArrayList<Visitors> list=Receptionist.receptionist.showVisitorsList();
                 if(list.isEmpty()){
                    print("\nNo Visitors visited");
                  }
                 else{
                    for(Visitors visitors : list){
                       print(visitors.toString());
                    }
                  }
                  
    }
     private static void print(String string){
        System.out.println(string);
       }
       private static void choice(){
        print("\nEnter Your Choice :\n");
       }
       private static void save(){
        print("\nSuccessfully saved.....");
       }
}
