package Hospital_Management.UI;

import Hospital_Management.MIDDLE_LAYER.Login;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Register;


public class HomePage {
   
   public  void start()
   {
      print("\n******* WELCOME *******\n");
      menu();

   }
//---------------------------------------------------------------------------------------------------------------------------------------//

    void menu()
   {
      print("\nplease select below options\n\n1. LOGIN\n2. REGISTER\n3. EXIT");
      printLine();
      print("\nEnter Your Choice :\n");

      switch( input.getFromUser())
      {
         case "1" :login();break;
         case "2" :register();break;
         case "3" :exit(); break;

         default : print("Invalid choice.....!"); menu();
      }

   }


    void login()
   {
      Login login=new Login();
      print("\nENTER YOUR ID :");

      String id= input.getFromUser();

      if(login.isIdExist(id))
      {
         print("\nENTER YOUR PASSWORD : ");

         if(login.isPasswordCorrect(id, input.getFromUser()))
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

   private  void register(){
        
        Register register=new Register();
        print("\nEnter Username to create an Account");
        String id= input.getFromUser();

        if(!register.isIdExist(id)){
          print("\nENTER PASSWORD: ");
          String password= input.password();
          
          print("\nDo you have a patient Id ?\n\n1. YES\n2. NO");
          switch( input.getFromUser())
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
               menu();
            }
          }

        }
        else{
         print("Username Already Exist in that Id..");
         menu();
        }
   }

   private  void oldPatient(String id,String password,Register register){

      print("Enter your Patient Id :");
      String patiendId= input.getFromUser();
      if(Patient.ispatientExists(patiendId)){

         if(register.isIdConnectedToAcc(patiendId)){

            print("\nOops....It seems that your Patient Id is Already Connected to an Account");
            menu();
         }
         else{

            register.create(id, password, patiendId);
            print("\nAccount restored successfully...\n\nPLEASE LOGIN TO USE YOUR ACCOUNT");
            menu();
         }
      }
      else{

         print("No Details Available for that Id\n Do you want to create new one?\n1.YES\n2. NO ");
         switch( input.getFromUser()){
            case "1" :{
               newPatient(patiendId, password,register);
            }
            default :{
               print("\nThank You");
               menu();
            }
         }
      }
   }

   private  void newPatient(String id,String password,Register register){
      register.create(id,password, input.name(), input.age(), input.sex(),  input.bloodGroup(),  input.weight(),  input.height(),  input.ph_no(), input.allergies());
      print("\nAccount Created Successfully");
      menu();
   }
  
   static void employeefeatures()
   {  
      printLine();
      System.out.println("\n\nMENU\n\nPlease select the below options\n\n1.LOGOUT\n2. CHECKIN\n3. CHECKOUT\n4. VIEW PROFILE\n5. CHANGE PASSWORD");
   }
 
   private  void print(String string)
   {
      System.out.println(string);
   }

   static void printLine()
   {
      System.out.print("____________________________________________________________________________________\n");
   }



   private  void exit()
   {
      print("\n******************** THANK YOU ************************\n\n");
   }

   private  void passwordIncorrect()
   {
      print("\nYOU HAVE ENTERED WRONG PASSWORD , PLEASE TRY AGAIN\n");
   }

   private  void accountNotFound()
   {
      print("\nACCOUNT DOESN'T EXIST\n\nTHANK YOU");
   }

   private  Input input=new Input();

}
