package Hospital_Management.UI;

import Hospital_Management.MIDDLE_LAYER.Cashier;
import Hospital_Management.MIDDLE_LAYER.Receptionist;

public class CashierPage {

    public static void cashierFeatures(){
        Home.employeefeatures();
        print("5. GENERATE BILL\n6. BACK\n ");
        switch(Input.getFromUser()){
            case "1":{
                print("\n......THANK YOU.....");Home.menu(); break;
               } 
     case "2":{
                checkIn();
                cashierFeatures();
                break;
              }
     case "3":{
                checkOut();
                cashierFeatures();
                 break;
              }
     case "4":{
                 print(Cashier.cashier.toString()); 
                 cashierFeatures();
                 break;
              }
          case "5":{
                    Cashier.cashier.generateBill();
                    cashierFeatures();
                   }break;
          case "6":{
                    Home.loginAs();
                   }break;
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
       private static void print(String string){
        System.out.println(string);
       }
}
