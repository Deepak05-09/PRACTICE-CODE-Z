package Hospital_Management.UI;

import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Bill;
import Hospital_Management.MIDDLE_LAYER.Cashier;


public class CashierPage {

    public static void cashierFeatures(){

        Home.employeefeatures();
        print("6. GENERATE BILL\n");
        Home.printLine();

        switch(Input.getFromUser())
        {
            case "1":
            {
                print("\n......THANK YOU.....");
                Account.user=null;
                Home.menu();
                 break;
            } 

            case "2":
            {
                checkIn();
                cashierFeatures();
                break;
            }
            
            case "3":
            {
                checkOut();
                cashierFeatures();
                break;
            }

            case "4":
            {
                ViewProfile(); 
                cashierFeatures();
                break;
            }
            
            case "5" :
             {
                  changePassword();
                  cashierFeatures();
                  break;
             }
            case "6":
            {
                printBill();
                cashierFeatures();
                break;
            }

            default : {
               print("Invalid Choice");
               cashierFeatures();
            }
        }

       }
//---------------------------------------------------------------------------------------------------------------------------------------//

       private static void checkIn()
       {
        if(((Cashier) Account.user).checkIn())
        {
           print("\nSuccessfully Checked In\n");
        }
        else
        {
           print("\nYOU HAVE ALREADY CHECKED IN\n");
        }

       }
//---------------------------------------------------------------------------------------------------------------------------------------//
    
      private static void checkOut()
      {
        if(((Cashier) Account.user).checkOut())
        {
           print("\nSuccessfully Checked Out");
        }
        else
        {
              print("\nplease Check In to Check Out");
        }

      }
//---------------------------------------------------------------------------------------------------------------------------------------//

      private static void changePassword(){
         print("\nEnter Your Current Password : ");
         if(((Cashier) Account.user).getPassword().equals(Input.getFromUser())){
            print("\nEnter new Password :");
            String password=Input.password();
            print("\nRe-Type Your new Password :");
            if(password.equals(Input.getFromUser())){
               ((Cashier) Account.user).changePassword(password);
               print("\nPassWord Changed Successfully");
            }
            else{
               print("\nPassword Doesn't Match");
            }

         }
         else{
            print("\nPassword is InCorrect");
         }
      }
//---------------------------------------------------------------------------------------------------------------------------------------//

      private static void ViewProfile(){
      Home.printLine();
      print("\n01. Name            : "+((Cashier) Account.user).getName());
      print("\n02. ID              : "+((Cashier) Account.user).getId());
      print("\n03. MAIL            : "+((Cashier) Account.user).getMail());
      print("\n04. Ph.No           : "+((Cashier) Account.user).getPhnNo());
      print("\n05. Date.of.Birth   : "+((Cashier) Account.user).getDateOfBirth());
      print("\n06. Age             : "+((Cashier) Account.user).getAge());
      print("\n07. Gender          : "+((Cashier) Account.user).getSex());
      print("\n08. Date Joined     : "+((Cashier) Account.user).getDateJoined());
      print("\n09. Role            : "+((Cashier) Account.user).getRole());
      print("\n10. Address         : "+((Cashier) Account.user).getAddress());
      print("\n11. Education       : "+((Cashier) Account.user).getEducation());
      print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
      Home.printLine();

      switch(Input.getFromUser())
      {
         case "1":editProfile();break;

         case "2":cashierFeatures();break;

         default:print("Invalid Option...!\n...THANK YOU....");cashierFeatures();;
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void editProfile(){
      print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":cashierFeatures();break;

         case "1":
         {
            ((Cashier) Account.user).setName(Input.name());
            print("\nName Updated Successfully....");
            editProfile();
            break;
         }

         case "2":
         {
            print("\nSorry...! ID cannot be edited...");
            editProfile();
            break;
         }

         case "3":
         {
            ((Cashier) Account.user).setMail(Input.mail());
            print("\nMail Updated Successfully....");
            editProfile();
            break;
         }

         case "4":
         {
            ((Cashier) Account.user).setPhnNo(Input.ph_no());
            print("\nPhone number Updated Successfully....");
            editProfile();
            break;
         }

         case "5":
         {
            ((Cashier) Account.user).setDateOfBirth(Input.dateOfBirth());
            print("\nDate.Of.Birth Updated Successfully....");
            editProfile();
            break;
         }
          
         case "6":
         {
            ((Cashier) Account.user).setAge(Input.employeeAge());;
            print("\nAge Updated Successfully....");
            editProfile();
            break;
         }

         case "7":
         {
            ((Cashier) Account.user).setSex(Input.sex());;
            print("\nGender Updated Successfully....");
            editProfile();
            break;
         }

         case "8":
         {
            print("\nSorry...! Date Joined cannot be Edited..");
            editProfile();
            break;
         }

         case "9":
         {
            print("\nSorry....! Role Cannot Be Edited..");
            editProfile();
            break;
         }

         case "10":
         {
            ((Cashier) Account.user).setAddress(Input.address());;
            print("\nAddress Updated Successfully....");
            editProfile();
            break;
         }

         case "11":
         {
            ((Cashier) Account.user).setEducation(Input.education());;
            print("\nEducation Updated Successfully....");
            editProfile();
            break;
         }
         
         default : print("\nInvalid Option....!");editProfile();
      }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//
   public static void printBill(){
      
      print("\nEnter ID to generate Bill :");
      String id=Input.patientId();

      if(((Cashier) Account.user).isPatientExists(id)){

         Bill bill=((Cashier) Account.user).generateBill(id,Input.roomFees(),Input.consultantFees(),Input.medicineFees());
         
         print("\n----------------------------- BILL -----------------------------");
         print("\n\nBill id           : "+bill.billId);
         print("\nPatient Id        :"+bill.patientId);
         print("\nGenerated on      :"+bill.billGeneratedOn);
         print("\nGenerated by      : "+bill.billGivenBy);
         print("\nConsultant fees   :"+bill.ConsultantFees+"/-");
         print("\nRoom fees         :"+bill.roomFees+"/-");
         print("\nMedicine fees     :"+bill.MedicineFees+"/-");
         print("\n================================================================");
         print("\nTotal fees        : Rs."+bill.total+"/- Only");
         print("\n================================================================");
      }
      else{
         print("\nOops.....! There is No Patient in that ID");
      }

   }
//---------------------------------------------------------------------------------------------------------------------------------------//

       private static void print(String string)
       {
        System.out.println(string);
       }
//---------------------------------------------------------------------------------------------------------------------------------------//

}
