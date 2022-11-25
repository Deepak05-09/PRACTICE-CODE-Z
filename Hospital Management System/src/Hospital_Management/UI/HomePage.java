package Hospital_Management.UI;

import Hospital_Management.MIDDLE_LAYER.Login;
import Hospital_Management.MIDDLE_LAYER.Register;


public class HomePage {
   
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
         case "1" :login();break;
         case "2" :register();break;
         case "3" :exit(); break;

         default : print("Invalid choice.....!"); menu();
      }

   }


   static void login()
   {
      Login login=new Login();
      print("\nENTER YOUR ID :");

      String id=Input.getFromUser();

      if(login.isIdExist(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(login.isPasswordCorrect(id,Input.getFromUser()))
         {
            print("\n*...SUCCESSFULLY LOGGED IN *");
            login.login(id);
         }
         else
         {
            passwordIncorrect();
            login();
         }
      }
      else
      {
         accountNotFound();
         menu();
      }

   }

   private static void register(){
        
        Register register=new Register();
        print("\nEnter Username create an Account");
        String id=Input.getFromUser();

        if(register.isIdExist(id)){
          print("\nENTER PASSWORD: ");
          String password=Input.password();
          
          print("\nDo you have a patient Id ?\n\n1. YES\n2. NO");
          switch(Input.getFromUser())
          {
            case "1": {
               oldPatient(id, password,register);
               break;
            }
            case "2":{
               newPatient(id, password,register);
            }
            default :{
               print("Invalid option...");
               HomePage.menu();
            }
          }

        }
        else{
         print("Username Already Exist in that Id..");
         menu();
        }
   }

   private static void oldPatient(String id,String password,Register register){

      print("Enter your Patient Id :");
      String patiendId=Input.getFromUser();
      if(register.isIdExist(patiendId)){
         register.create(id, password, patiendId);
         print("\nAccount restored successfully...");
         HomePage.menu();
      }
      else{
         print("No Details Available for that Id\n Do you want to create new one?\n1.YES\n2. NO ");
         switch(Input.getFromUser()){
            case "1" :{
               newPatient(patiendId, password,register);
            }
            default :{
               print("\nThank You");
               HomePage.menu();
            }
         }
      }
   }

   private static void newPatient(String id,String password,Register register){
      register.create(id,password,Input.name(),Input.age(),Input.sex(), Input.bloodGroup(), Input.weight(), Input.height(), Input.ph_no(),Input.allergies());
      print("\nAccount Created Successfully");
      HomePage.menu();
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
