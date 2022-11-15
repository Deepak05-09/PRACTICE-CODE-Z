package Hospital_Management.UI;


import Hospital_Management.MIDDLE_LAYER.Account;


public class Home {
   
   public static void start(){
    print("\n******* WELCOME *******\n");
    menu();
   }

   static void menu(){
   print("\nplease select below options\n\n1. LOGIN\n2. EXIT");
   printLine();
   print("\nEnter Your Choice :\n");
      switch(Input.getFromUser()){
        case "1" :loginAs();break;
        //case "2" :registerAs();break;
        case "2" :exit(); break;
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

   static void loginAs(){
    print("\nLOGIN AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER\n5. BACK");
    printLine();
    choice();
    switch(Input.getFromUser()){
      case "1": {
                 login();
                 AdminPage.adminFeatures();
               }break;
      case "2": {
                 login();
                 DoctorPage.doctorFeatures();
                }break;
      case "3": {
                 login();
                 ReceptionistPage.receptionistFeatures();
                }break;
      case "4": {
                 login();
                 CashierPage.cashierFeatures();
                }break;
      case "5": menu();break;
      default : print("Invalid choice.....!");loginAs();
       }
   }

   // private static void registerAs(){
   //  print("\nREGISTER AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER");
   //  printLine();
   // }
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
   
   static void employeefeatures(){
    print("\nPlease select the below options\n\n1.LOGOUT\n2. CHECKIN\n3. CHECKOUT\n4. VIEW PROFILE");
   }
   


   
   
   

}
