package Hospital_Management.UI;


import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Utils;


public class Home {
   
   public static void start()
   {
      print("\n******* WELCOME *******\n");
      menu();

   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   static void menu()
   {
      print("\nplease select below options\n\n1. LOGIN\n2. REGISTER\n3. EXIT");
      printLine();
      print("\nEnter Your Choice :\n");

      switch(Input.getFromUser())
      {
         case "1" :loginAs();break;
         case "2" :register();break;
         case "3" :exit(); break;

         default : print("Invalid choice.....!"); menu();
      }

   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   static void loginAs()
   {
      print("\nLOGIN AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER\n5. PATIENT\n6. BACK");
      printLine();
      print("\nSelect Your Option :");
      switch(Input.getFromUser())
      {
         case "1": 
         {
            adminlogin();
            break;
         }

         case "2": 
         {
            doctorlogin();
            break;
         }

         case "3": 
         {
            receptionistlogin();
            break;
         }
                
         case "4": 
         {
            cashierlogin();
            break;
         }
         case "5" :
         {
            patientlogin();
            break;
         }
         case "6": menu();break;

         default : print("Invalid choice.....!");loginAs();

      }

   }
//---------------------------------------------------------------------------------------------------------------------------------------//

    static void adminlogin()
   {
      print("\nENTER YOUR ID :");

      String id=Input.getFromUser();

      if(Utils.isAdminIdExists(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(Utils.isPasswordCorrect(id,Input.getFromUser()))
         {
            Account.adminLogin(id);
            print("\n*...SUCCESSFULLY LOGGED IN AS ADMIN...*");
            AdminPage.adminFeatures();
         }
         else
         {
            passwordIncorrect();
            adminlogin();
         }
      }
      else
      {
         accountNotFound();
         menu();
      }

   }
   static void doctorlogin()
   {
      print("\nENTER YOUR ID :");

      String id=Input.getFromUser();

      if(Utils.isDoctorIdExists(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(Utils.isPasswordCorrect(id,Input.getFromUser()))
         {
            Account.doctorLogin(id);
            print("\n*...SUCCESSFULLY LOGGED IN AS DOCTOR...*");
            DoctorPage.doctorFeatures();
         }
         else
         {
            passwordIncorrect();
            doctorlogin();
         }
      }
      else
      {
         accountNotFound();
         menu();
      }

   }

   static void cashierlogin()
   {
      print("\nENTER YOUR ID :");

      String id=Input.getFromUser();

      if(Utils.isCashierIdExists(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(Utils.isPasswordCorrect(id,Input.getFromUser()))
         {
            Account.cashierLogin(id);
            print("\n*...SUCCESSFULLY LOGGED IN AS CASHIER...*");
            CashierPage.cashierFeatures();
         }
         else
         {
            passwordIncorrect();
            cashierlogin();
         }
      }
      else
      {
         accountNotFound();
         menu();
      }

   }

   static void receptionistlogin()
   {
      print("\nENTER YOUR ID :");

      String id=Input.getFromUser();

      if(Utils.isReceptionistIdExists(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(Utils.isPasswordCorrect(id,Input.getFromUser()))
         {
            Account.receptionistLogin(id);
            print("\n*...SUCCESSFULLY LOGGED IN AS RECEPTIONIST...*");
            ReceptionistPage.receptionistFeatures();
         }
         else
         {
            passwordIncorrect();
            receptionistlogin();
         }
      }
      else
      {
         accountNotFound();
         menu();
      }

   }

   static void patientlogin()
   {
      print("\nENTER YOUR ID :");

      String id=Input.getFromUser();

      if(Utils.isPatientIdExists(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(Utils.isPasswordCorrect(id,Input.getFromUser()))
         {
            Account.patientLogin(id);
            print("\n*...SUCCESSFULLY LOGGED IN AS PATIENT...*");
            PatientPage.menu();
         }
         else
         {
            passwordIncorrect();
            patientlogin();
         }
      }
      else
      {
         accountNotFound();
         menu();
      }

   }

   private static void register(){
        print("\nEnter Username create an Account");
        String id=Input.getFromUser();

        if(!Utils.isPatientIdExists(id)){
          print("\nENTER PASSWORD: ");
          String password=Input.password();
          //Account account=new Account();
         //print("\nAccount Created Successfully.");
          print("\nDo you have a patient Id ?\n\n1. YES\n2. NO");
          switch(Input.getFromUser())
          {
            case "1": {
               oldPatient(id, password);
               break;
            }
            case "2":{
               newPatient(id, password);
            }
            default :{
               print("Invalid option...");
               Home.menu();
            }
          }

        }
        else{
         print("Username Already Exist in that Id..");
         menu();
        }
   }

   private static void oldPatient(String id,String password){

      print("Enter your Patient Id :");
      String patiendId=Input.getFromUser();
      if(Utils.isPatientExists(patiendId)){
         Account.create(id, password, patiendId);
         print("\nAccount restored successfully...");
         Home.menu();
      }
      else{
         print("No Details Available for that Id\n Do you want to create new one?\n1.YES\n2. NO ");
         switch(Input.getFromUser()){
            case "1" :{
               newPatient(patiendId, password);
            }
            default :{
               print("\nThank You");
               Home.menu();
            }
         }
      }
   }

   private static void newPatient(String id,String password){
      Account.create(id,password,Input.name(),Input.age(),Input.sex(), Input.bloodGroup(), Input.weight(), Input.height(), Input.ph_no(),Input.allergies());
      print("\nAccount Created Successfully");
      Home.menu();
   }
 //---------------------------------------------------------------------------------------------------------------------------------------//
  
   static void employeefeatures()
   {  
      printLine();
      print("\n\nMENU\n\nPlease select the below options\n\n1.LOGOUT\n2. CHECKIN\n3. CHECKOUT\n4. VIEW PROFILE\n5. CHANGE PASSWORD");
   }
 //---------------------------------------------------------------------------------------------------------------------------------------//
 
   private static void print(String string)
   {
      System.out.println(string);
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   static void printLine()
   {
      System.out.print("____________________________________________________________________________________\n");
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   // private static void choice()
   // {
   //    print("\nEnter Your Choice :\n");
   // }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void exit()
   {
      print("\n******************** THANK YOU ************************\n\n");
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void passwordIncorrect()
   {
      print("\nYOU HAVE ENTERED WRONG PASSWORD , PLEASE TRY AGAIN\n");
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void accountNotFound()
   {
      print("\nACCOUNT DOESN'T EXIST\n\nTHANK YOU");
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

}
