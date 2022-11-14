package Hospital_Management.UI;

import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Receptionist;
import Hospital_Management.MIDDLE_LAYER.Room;
import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Admin;
import Hospital_Management.MIDDLE_LAYER.Cashier;

public class Display {
   
   public static void start(){
    print("\n******* WELCOME *******\n");
    menu();
   }

   private static void menu(){
   print("\nplease select below options\n\n1. LOGIN\n2. REGISTER\n3. EXIT");
   printLine();
   print("\nEnter Your Choice :\n");
      switch(Input.getFromUser()){
        case "1" :loginAs();break;
        case "2" :registerAs();break;
        case "3" :exit(); break;
        default : print("Invalid choice.....!"); menu();
      }
   }

   private static void print(String string){
      System.out.println(string);
   }
//    private static void print(int number){
//     System.out.println(number);
//    }

   private static void printLine(){
    System.out.print("____________________________________________________________________________________\n");
   }
   private static void choice(){
      print("\nEnter Your Choice :\n");
   }

   private static void loginAs(){
    print("\nLOGIN AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER\n5. BACK");
    printLine();
    choice();
    switch(Input.getFromUser()){
      case "1": {
                 login();
                 adminFeatures();
               }break;
      case "2": {
                 login();
                 doctorFeatures();
                }break;
      case "3": {
                 login();
                 receptionistFeatures();
                }break;
      case "4": {
                 login();
                 cashierfeatures();
                }break;
      case "5": menu();break;
      default : print("Invalid choice.....!");loginAs();
       }
   }

   private static void registerAs(){
    print("\nREGISTER AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER");
    printLine();
   }
   private static void exit(){
      print("******************** THANK YOU ************************");
   }

   private static void passwordIncorrect(){
    print("\nYOU HAVE ENTERED WRONG PASSWORD , PLEASE TRY AGAIN\n");
   }

   private static void accountNotFound(){
    print("\nACCOUNT DOESN'T EXIST , PLEASE LOGIN WITH \"DIFFERENT ACCOUNT\" OR \"REGISTER\"");
   }
   
   // private static void accountAlreadyExists(){
   //  print("\nAccount already exixts\n");
   // }

   private static void login(){
       print("\nENTER YOUR ID :");
        String id=Input.getFromUser();
      if(Account.isUserExist(id)){
          print("\nENTER YOUR PASSWORD : ");
         if(Account.isPasswordCorrect(id,Input.getFromUser())){
            Account.login(id);
            print("*...SUCCESSFULLY LOGGED IN...*");
         }
         else{
            passwordIncorrect();
            login();
         }
      }
      else{
      accountNotFound();
      loginAs();
      }
   }
   // private static void logout(){
   //  print("\nSUCCESSFULLY LOGGED OUT\n*********************** THANK YOU ***********************\n");
   // }
   
   private static void employeefeatures(){
    print("\nPlease select the below options\n\n1.LOGOUT\n2. CHECKIN\n3. CHECKOUT\n4. VIEW PROFILE");
   }
   private static void adminFeatures(){
      
      employeefeatures();
    print("\n5. ADD ADMIN\n6. ADD DOCTOR\n7. ADD RECEPTIONIST\n8. ADD CASHIER\n9. REMOVE EMPLOYEE\n10. VIEW ROOM STATUS\n11.SEARCH EMPLOYEE\n12.VIEW ALL EMPLOYEE\n13. SIGN OUT");
    choice();
    switch(Input.getFromUser()){
          case "5":{
                    Admin.admin.createNewAdmin();
                    save();
                    adminFeatures();
                   }break;
         case  "6":{
                    Admin.admin.addDoctor(); 
                    save(); adminFeatures();
                   }break;
         case  "7":{
                     Admin.admin.addReceptionist();
                     save();adminFeatures();
                    }break;
         case  "8":{
                     Admin.admin.addCashier();
                     save(); adminFeatures();
                    }break;
         case  "9":{
                     Admin.admin.addCashier(); 
                     save(); adminFeatures();
                    }break;
         case  "10":{
                     if(Admin.admin.roomStatus()!=null){
                     for(Room room:Admin.admin.roomStatus()){
                        Input.print(room.toString());
                     } }
                     adminFeatures();
                    }break;
         case  "11":{
                     print("\nENTER EMPLOYEE ID TO SEARCH : \n");
                     print(Admin.admin.viewEmployee(Input.getFromUser()));
                     adminFeatures();
                    }break;
         case "12":{
                    Input.print(Admin.admin.viewAll());adminFeatures();break;
                   }
         case "13":{
                    print("......THANK YOU.....");loginAs(); break;
                   }
         default :  {
                     print("Invalid choice......!");
                     adminFeatures();
                    }
    }
   }

   private static void doctorFeatures(){
      employeefeatures();
    print("\n5. VIEW PATIENT\n6. GENERATE REPORT\n");
    choice();
    switch(Input.getFromUser()){
        case "5":{
                   Doctor.doctor.viewPatient(Input.patientId());
                   doctorFeatures();
                 }break;
        case "6":{
                  Doctor.doctor.generatReport(null, null, null, null, null);
                  doctorFeatures();
                }break;
         default :{
            print("Invalid choice....!");
            doctorFeatures();
         }

    }
   }

   private static void receptionistFeatures(){
      employeefeatures();
    print("\n5. ADD PATIENT\n6. UPDATE PATIENT DETAILS\n7. DOCTOR AVAILABILITY\n8. VISITOR ENTRY\n");
    choice();
    switch(Input.getFromUser()){
      case "5":{
                Receptionist.receptionist.AddPatient();save();receptionistFeatures();
               }break;
      case "6":{
                Receptionist.receptionist.UpdateDetails(null, null, 0, null, null, 0, 0, null);
                receptionistFeatures();
               }break;
      case "7":{
                Receptionist.receptionist.doctorAvailability();receptionistFeatures();
               }break;
      case "8":{
                Receptionist.receptionist.addVisitors();receptionistFeatures();
               }break;
      default :{
                print("Invalid choice....!");
                receptionistFeatures(); 
      }
    }
   }
   private static void cashierfeatures(){
    employeefeatures();
    print("\n5. GENERATE BILL\n6. BACK\n ");
    switch(Input.getFromUser()){
      case "5":{
                Cashier.cashier.generateBill();
                cashierfeatures();
               }break;
      case "6":{
                loginAs();
               }break;
    }
   }
   private static void save(){
      print("\nSuccessfully saved.....");
   }

}
