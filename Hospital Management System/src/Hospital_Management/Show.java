package Hospital_Management;

public class Show {
    
   public static void welcome(){
    print("******* WELCOME *******\n");
   }

   public static void start(){
   print("\nplease select below options\n\n1. LOGIN\n2. REGISTER\n");
   printLine();
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

   public static void loginAs(){
    print("\nLOGIN AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER");
    printLine();
   }

   public static void registerAs(){
    print("\nREGISTER AS\n\n1. ADMIN\n2. DOCTOR\n3. RECEPTIONIST\n4. CASHIER");
    printLine();
   }

   public static void passwordIncorrect(){
    print("\nYOU HAVE ENTERED WRONG PASSWORD , PLEASE TRY AGAIN\n");
   }

   public static void accountNotFound(){
    print("ACCOUNT DOESN'T EXIST , PLEASE LOGIN WITH \"DIFFERENT ACCOUNT\" OR \"REGISTER\"");
   }
   
   public static void accountAlreadyExists(){
    print("\nAccount already exixts\n");
   }
   public static void logout(){
    print("\nSUCCESSFULLY LOGGED OUT\n*********************** THANK YOU ***********************\n");
   }
   
   public static void employeefeatures(){
    print("\nPlease select the below options\n\n1.LOGOUT\n2. CHECKIN\n3. CHECKOUT\n4. VIEW PROFILE\n");
   }
   public static void adminFeatures(){
    print("5. ADD ADMIN\n6. ADD DOCTOR\n7. ADD RECEPTIONIST\n8. ADD CASHIER\n9. REMOVE EMPLOYEE\n10. VIEW ROOM STATUS\n11.SEARCH EMPLOYEE ");
   }

   public static void doctorFeatures(){
    print("\n5. VIEW PATIENT\n6. GENERATE REPORT\n");
   }

   public static void receptionistFeatures(){
    print("5. ADD PATIENT\n6. UPDATE PATIENT DETAILS\n7. DOCTOR AVAILABILITY\n8. VISITOR ENTRY\n");
   }


}
