package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Report;
import Hospital_Management.MIDDLE_LAYER.Utils;

public class DoctorPage {
    
    static void doctorFeatures()
    {
        Home.employeefeatures();
        print("6. GENERATE REPORT\n7. VIEW PATIENT REPORT\n8. STATUS\n9. VIEW APPOINTMENTS");
        Home.printLine();

        choice();

        switch(Input.getFromUser())
        {
            case "1":
            {  
              Account.user=null;
               print("\n......THANK YOU.....");
               Home.menu();
               break;
            }

            case "2":
            {
               checkIn();
               doctorFeatures();
               break;
            }

            case "3":
            {
               checkOut();
               doctorFeatures();
               break;
            }

            case "4":
            {
               ViewProfile(); 
               break;
            }
            
            case "5" :
             {
                  changePassword();
                  doctorFeatures();
                  break;
             }

            case "6":
            {  
               generateReport();
               doctorFeatures();
               break;
            }

            case "7":
            {  
               viewPatientReport();
               doctorFeatures();
               break;
            }
            case "8":
            {
               changeStatus();
               doctorFeatures();
               break;
            }
            case "9" :
            {   
               viewAppointments();
                doctorFeatures();
                break;
            }

            default :
            {  
               print("\nInvalid choice....!");
               doctorFeatures();
            }
  
         }

     }
//---------------------------------------------------------------------------------------------------------------------------------------//

     private static void checkIn()
     {
        if(((Doctor) Account.user).checkIn())
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
        if(((Doctor) Account.user).checkOut())
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
      if(((Doctor) Account.user).getPassword().equals(Input.getFromUser())){
         print("\nEnter new Password :");
         String password=Input.password();
         print("\nRe-Type Your new Password :");
         if(password.equals(Input.getFromUser())){
          ((Doctor) Account.user).changePassword(password);
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

   //  private static void viewPatient()
   //  {
   //     String id=Input.patientId();

   //    if(((Doctor) Account.user).isPatientExists(id))
   //    {
   //       Patient patient=((Doctor) Account.user).viewPatient(id);
   //       ReceptionistPage.viewPatientDetails(patient);
   //    }
   //    else
   //    {
   //       print("\nOops....!   There is No Patient in That ID");
   //    }

   //  }
//---------------------------------------------------------------------------------------------------------------------------------------//

    private static void ViewProfile()
   {
      Doctor doctor=((Doctor) Account.user).viewProfile();
      Home.printLine();
      print("\n01. Name            : "+doctor.getName());
      print("\n02. ID              : "+doctor.getId());
      print("\n03. MAIL            : "+doctor.getMail());
      print("\n04. Ph.No           : "+doctor.getPhnNo());
      print("\n05. Date.of.Birth   : "+doctor.getDateOfBirth());
      print("\n06. Age             : "+doctor.getAge());
      print("\n07. Gender          : "+doctor.getSex());
      print("\n08. Date Joined     : "+doctor.getDateJoined());
      print("\n09. Role            : "+doctor.getRole());
      print("\n10. Address         : "+doctor.getAddress());
      print("\n11. Education       : "+doctor.getEducation());
      print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
      Home.printLine();

      switch(Input.getFromUser())
      {
         case "1":editProfile();break;

         case "2":doctorFeatures();break;

         default:print("\nInvalid Option...!\n...THANK YOU....");doctorFeatures();;
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void editProfile()
   {  print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":doctorFeatures();break;

         case "1":
         {
           ((Doctor) Account.user).setName(Input.name());
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
           ((Doctor) Account.user).setMail(Input.mail());
            print("\nMail Updated Successfully....");
            editProfile();
            break;
         }

         case "4":
         {
           ((Doctor) Account.user).setPhnNo(Input.ph_no());
            print("\nPhone number Updated Successfully....");
            editProfile();
            break;
         }

         case "5":
         {
           ((Doctor) Account.user).setDateOfBirth(Input.dateOfBirth());
            print("\nDate.Of.Birth Updated Successfully....");
            editProfile();
            break;
         }
          
         case "6":
         {
           ((Doctor) Account.user).setAge(Input.employeeAge());;
            print("\nAge Updated Successfully....");
            editProfile();
            break;
         }

         case "7":
         {
           ((Doctor) Account.user).setSex(Input.sex());;
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
           ((Doctor) Account.user).setAddress(Input.address());;
            print("\nAddress Updated Successfully....");
            editProfile();
            break;
         }

         case "11":
         {
           ((Doctor) Account.user).setEducation(Input.education());;
            print("\nEducation Updated Successfully....");
            editProfile();
            break;
         }
         
         default : print("\nInvalid Option....!");editProfile();
      }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//
      
     private static void generateReport()
     {
         print("\nEnter Patient's Id to Generate report");
               String id=Input.getFromUser();
               if(Utils.isPatientExists(id))
               {
              ((Doctor) Account.user).generatReport( id, Input.reason(), Input.treatementProvided(),Input.prescribe());
               print("\n\nReport Generated SuccessFully" );
               }
               else
               {
                  print("\nOops...!  There is No Patient In That ID.....");
               }
     }

//---------------------------------------------------------------------------------------------------------------------------------------//

     private static void viewPatientReport()
     {
      print("\nEnter ID to view Patient's Report");
      String id=Input.patientId();
         
      if(Utils.isPatientExists(id))
      {
               ArrayList<Report> list=((Doctor) Account.user).viewPatientReport(id);
               
               if(list.isEmpty()||list==null){
                  print("\nNo Reports Available For this Patient");
               }
               else
               {  
                  print("\n--------------PATIENT'S REPORT-------------\n");
                  for(int i=1;i<=list.size();i++)
                  {
                     print("\n"+i+". "+list.get(i-1).toString());
                  }

                  print("\nselect Options to View Report");
                  String input=Input.getFromUser();
                  if(Validate.onlyNumber(input))
                  {
                     if(Integer.parseInt(input)>0&&Integer.parseInt(input)<=list.size())
                     {
                        printReport(list.get(Integer.parseInt(input)-1));
                     }
                     else
                     {
                        print("\nInvalid Option.....!");
                     }
                  }
                  else
                  {
                     print("\nInvalid Option.....!");
                  }
               }
      }
      else
      {
         print("\nOops...! There is No Patient in That Id..");
      }
     }
//---------------------------------------------------------------------------------------------------------------------------------------//
     private static  void printReport(Report report)
     {
        print("\n--------------- REPORT ---------------");
        print("\n\nReport ID         :"+report.getId());
        print("\nPatient Id          :"+report.getPatientId());
        print("\nGenerated By        :"+report.getGeneratedBy());
        print("\nDescription         :"+report.getdescription());
        print("\nTreatement Provided :"+report.getTreatementProvided());
        print("\nMedicine Prescribed :"+report.getMedicinePrescribed());
        Home.printLine();
     }

     private static void changeStatus(){
           print("Note : Only above 7 days availability can be Changed from Current date");
           print("\n1. "+LocalDate.now().plusDays(7)+" "+LocalDate.now().plusDays(7).getDayOfWeek());
           print("\n2. "+LocalDate.now().plusDays(8)+" "+LocalDate.now().plusDays(8).getDayOfWeek());
           print("\n3. "+LocalDate.now().plusDays(9)+" "+LocalDate.now().plusDays(9).getDayOfWeek());
           print("\n4. "+LocalDate.now().plusDays(10)+" "+LocalDate.now().plusDays(10).getDayOfWeek());
           print("\n5. "+LocalDate.now().plusDays(11)+" "+LocalDate.now().plusDays(11).getDayOfWeek());
           print("\n6. "+LocalDate.now().plusDays(12)+" "+LocalDate.now().plusDays(12).getDayOfWeek());
           print("\n7. "+LocalDate.now().plusDays(13)+" "+LocalDate.now().plusDays(13).getDayOfWeek());
           print("\nselect options to change availability on the given date :");
            choice();
            switch(Input.getFromUser()){
               case "1":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(7));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(7));
                  
                  break;
               } 
               case "2":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(8));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(8));
                  
                  break;
               } 
               case "3":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(9));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(9));
                  
                  break;
               } 
               case "4":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(10));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(10));
                 
                  break;
               } 
               case "5":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(11));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(11));
                 
                  break;
               } 
               case "6":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(12));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(12));
                 
                  break;
               } 
               case "7":
               {
                 ((Doctor) Account.user).setNonAvailable(LocalDate.now().plusDays(13));
                  print("\nStatus Changed to Not Available on "+LocalDate.now().plusDays(13));
                 
                  break;
               } 
               
               default :
               {
                   print("\nEnter Valid Choice");
               }
            }
     }

     private static void viewAppointments(){
           HashMap<LocalDate, Appointment[]> AppointDate=((Doctor) Account.user).viewAppointments();
          
           ArrayList<LocalDate> list=new ArrayList<>();
         
           for(int i=0;i<7;i++){
               LocalDate d=LocalDate.now().plusDays(i);
             if(AppointDate.containsKey(d))
             {
               list.add(d);
             }
            }
           
           if(list.isEmpty()||list==null){
            print("\n No Appointments for 7 days");
           }
           else
           {
            print("Select Below Date To See ");
            for(int i=0;i<list.size();i++){
               print((i+1)+". "+list.get(i));
            }
            String choice=Input.getFromUser();
            if(!Validate.onlyNumber(choice)&&Integer.parseInt(choice)>=list.size()){
               print("\nEnter Valid choice :");
               viewAppointments();
            }
            else{
               LocalDate date=list.get(Integer.parseInt(choice)-1);
               Appointment[] appoint=((Doctor) Account.user).viewAppointments(date);
               for(Appointment a:appoint){
                  if(a!=null)
                  print("Patient id : "+a.getPatientId()+" Time : "+a.getTime());
               }
            }  
         }
     }

//---------------------------------------------------------------------------------------------------------------------------------------//
     private static void print(String string)
     {
        System.out.println(string);
     }
//---------------------------------------------------------------------------------------------------------------------------------------//
   
      private static void choice()
      {
        print("\nEnter Your Choice :\n");
      }
}
