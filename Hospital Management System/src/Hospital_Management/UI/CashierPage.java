package Hospital_Management.UI;


import Hospital_Management.MIDDLE_LAYER.Bill;
import Hospital_Management.MIDDLE_LAYER.Cashier;
import Hospital_Management.MIDDLE_LAYER.Patient;


public class CashierPage {

   public Cashier user;

    public void cashierFeatures(){

        HomePage.employeefeatures();
        print("6. GENERATE BILL\n");
        HomePage.printLine();

        switch(Input.getFromUser())
        {
            case "1":
            {
                print("\n......THANK YOU.....");
                user=null;
                HomePage.menu();
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

       private void checkIn()
       {
        if(user.checkIn())
        {
           print("\nSuccessfully Checked In\n");
        }
        else
        {
           print("\nYOU HAVE ALREADY CHECKED IN\n");
        }

       }
//---------------------------------------------------------------------------------------------------------------------------------------//
    
      private void checkOut()
      {
        if(user.checkOut())
        {
           print("\nSuccessfully Checked Out");
        }
        else
        {
              print("\nplease Check In to Check Out");
        }

      }
//---------------------------------------------------------------------------------------------------------------------------------------//

      private void changePassword(){
         print("\nEnter Your Current Password : ");
         if(user.getPassword().equals(Input.getFromUser())){
            print("\nEnter new Password :");
            String password=Input.password();
            print("\nRe-Type Your new Password :");
            if(password.equals(Input.getFromUser())){
               user.changePassword(password);
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

      private void ViewProfile(){
      HomePage.printLine();
      print("\n01. Name            : "+user.getName());
      print("\n02. ID              : "+user.getId());
      print("\n03. MAIL            : "+user.getMail());
      print("\n04. Ph.No           : "+user.getPhnNo());
      print("\n05. Date.of.Birth   : "+user.getDateOfBirth());
      print("\n06. Age             : "+user.getAge());
      print("\n07. Gender          : "+user.getSex());
      print("\n08. Date Joined     : "+user.getDateJoined());
      print("\n09. Role            : "+user.getRole());
      print("\n10. Address         : "+user.getAddress());
      print("\n11. Education       : "+user.getEducation());
      print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
      HomePage.printLine();

      switch(Input.getFromUser())
      {
         case "1":editProfile();break;

         case "2":cashierFeatures();break;

         default:print("Invalid Option...!\n...THANK YOU....");cashierFeatures();;
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private void editProfile(){
      print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":cashierFeatures();break;

         case "1":
         {
            user.setName(Input.name());
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
            user.setMail(Input.mail());
            print("\nMail Updated Successfully....");
            editProfile();
            break;
         }

         case "4":
         {
            user.setPhnNo(Input.ph_no());
            print("\nPhone number Updated Successfully....");
            editProfile();
            break;
         }

         case "5":
         {
            user.setDateOfBirth(Input.dateOfBirth());
            print("\nDate.Of.Birth Updated Successfully....");
            editProfile();
            break;
         }
          
         case "6":
         {
            user.setAge(Input.employeeAge());;
            print("\nAge Updated Successfully....");
            editProfile();
            break;
         }

         case "7":
         {
            user.setSex(Input.sex());;
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
            user.setAddress(Input.address());;
            print("\nAddress Updated Successfully....");
            editProfile();
            break;
         }

         case "11":
         {
            user.setEducation(Input.education());;
            print("\nEducation Updated Successfully....");
            editProfile();
            break;
         }
         
         default : print("\nInvalid Option....!");editProfile();
      }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//
   public void printBill(){
      
      print("\nEnter ID to generate Bill :");
      String id=Input.patientId();

      if(Patient.ispatientExists(id)){

         Bill bill=user.generateBill(id,Input.roomFees(),Input.consultantFees(),Input.medicineFees());
         
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

       private void print(String string)
       {
        System.out.println(string);
       }
//---------------------------------------------------------------------------------------------------------------------------------------//

}
