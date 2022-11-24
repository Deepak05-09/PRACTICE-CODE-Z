package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Admin;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Employee;



public class AdminPage {
     
   
      

      static void adminFeatures()
        {
          
          Home.employeefeatures();

          print("6. ADD ADMIN\n7. ADD DOCTOR\n8. ADD RECEPTIONIST\n9. ADD CASHIER\n10. REMOVE EMPLOYEE\n11. VIEW APPOINTMENT\n12.SEARCH EMPLOYEE\n13.VIEW ALL EMPLOYEE\n");
          Home.printLine();
          choice();

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
                  adminFeatures();
                  break;
             }

             case "3":
             {
                  checkOut();
                  adminFeatures();
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
                  adminFeatures();
                  break;
             }

              case "6":
              {
                  ((Admin) Account.user).createNewAdmin(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                  adminFeatures();
                  break;
              }

             case  "7":
             {
                  ((Admin) Account.user).addDoctor(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.speciality(),Input.password()); 
                  adminFeatures();
                  break;
             }

             case  "8":
             {
                  ((Admin) Account.user).addReceptionist(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                  adminFeatures();
                  break;
             }

             case  "9":
             {
                  ((Admin) Account.user).addCashier(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                  adminFeatures();
             }

             case  "10":
             {
                  if(viewAll())
                  {
                  print("\nENTER EMPLOYEE ID TO REMOVE");
                  print(((Admin) Account.user).removeEmployee(Input.getFromUser()));
                  }
                  adminFeatures();
                  break;
             }

             case  "11":
             {
                  viewAppointments();
                  break;
             }

             case  "12":
             {
                  search();
                  adminFeatures();
                  break;
             }

             case "13":
             {
                viewAll();
                adminFeatures();
                break;
             }
            
             default : 
             {
                  print("\nInvalid choice......!");
                  adminFeatures();
             }

           }

        }
//---------------------------------------------------------------------------------------------------------------------------------------//

       private static void checkIn()
       {
         if(((Admin) Account.user).checkIn())
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
         if(((Admin) Account.user).checkOut())
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
         if(((Admin) Account.user).getPassword().equals(Input.getFromUser())){
            print("\nEnter new Password :");
            String password=Input.password();
            print("\nRe-Type Your new Password :");
            if(password.equals(Input.getFromUser())){
               ((Admin) Account.user).changePassword(password);
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

       private static void search()
       {
         print("\nENTER EMPLOYEE ID TO SEARCH : \n");
         Employee employee= ((Admin) Account.user).viewEmployee(Input.getFromUser());

         if(employee==null)
         {
            print("\nNo Employee Available In that ID");
         }
         else
         {
            print(employee.toString());
         }

       }
//---------------------------------------------------------------------------------------------------------------------------------------//

      //  private static void viewRoom()
      //  {
      //    ArrayList<Room> list=((Admin) Account.user).roomStatus();

      //    if(!list.isEmpty())
      //    {
      //       for(Room room:list)
      //       {
      //              Input.print(room.toString());
      //           } 
      //    }
      //    else
      //    {
      //       print("\nNo Rooms");
      //    }
      //  }
//---------------------------------------------------------------------------------------------------------------------------------------//

       private static boolean viewAll()
       {
         ArrayList<Employee> list= ((Admin) Account.user).viewAll();
                if(list.isEmpty()){
                  print("\nNO EMPLOYEE");
                  return false;
                }
                else{
                  for(Employee employee:list)
                  {
                     print(employee.toString());
                  }
                  return true;
                }
       }
//---------------------------------------------------------------------------------------------------------------------------------------//
  
       private static void ViewProfile()
      {
      Home.printLine();
      print("\n01. Name            : "+((Admin) Account.user).getName());
      print("\n02. ID              : "+((Admin) Account.user).getId());
      print("\n03. MAIL            : "+((Admin) Account.user).getMail());
      print("\n04. Ph.No           : "+((Admin) Account.user).getPhnNo());
      print("\n05. Date.of.Birth   : "+((Admin) Account.user).getDateOfBirth());
      print("\n06. Age             : "+((Admin) Account.user).getAge());
      print("\n07. Gender          : "+((Admin) Account.user).getSex());
      print("\n08. Date Joined     : "+((Admin) Account.user).getDateJoined());
      print("\n09. Role            : "+((Admin) Account.user).getRole());
      print("\n10. Address         : "+((Admin) Account.user).getAddress());
      print("\n11. Education       : "+((Admin) Account.user).getEducation());
      print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
      Home.printLine();

      switch(Input.getFromUser())
      {
         case "1":editProfile();break;

         case "2":adminFeatures();break;

         default:print("Invalid Option...!\n...THANK YOU....");adminFeatures();;
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void editProfile()
   {  print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":adminFeatures();break;

         case "1":
         {
            ((Admin) Account.user).setName(Input.name());
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
            ((Admin) Account.user).setMail(Input.mail());
            print("\nMail Updated Successfully....");
            editProfile();
            break;
         }

         case "4":
         {
            ((Admin) Account.user).setPhnNo(Input.ph_no());
            print("\nPhone number Updated Successfully....");
            editProfile();
            break;
         }

         case "5":
         {
            ((Admin) Account.user).setDateOfBirth(Input.dateOfBirth());
            print("\nDate.Of.Birth Updated Successfully....");
            editProfile();
            break;
         }
          
         case "6":
         {
            ((Admin) Account.user).setAge(Input.employeeAge());;
            print("\nAge Updated Successfully....");
            editProfile();
            break;
         }

         case "7":
         {
            ((Admin) Account.user).setSex(Input.sex());;
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
            ((Admin) Account.user).setAddress(Input.address());;
            print("\nAddress Updated Successfully....");
            editProfile();
            break;
         }

         case "11":
         {
            ((Admin) Account.user).setEducation(Input.education());;
            print("\nEducation Updated Successfully....");
            editProfile();
            break;
         }
         
         default : print("\nInvalid Option....!");editProfile();
      }
   }

   private static void viewAppointments(){
      print("\n----------------- VIEW APPOINTMENTS --------------------");
      print("\n1.DATE\n2.DOCTOR\n3.BACK");
      choice();
      switch(Input.getFromUser())
      {
         case "1" :
         {
            searchByDate();
            viewAppointments();
            break;
         }
         case "2" :
         {
            searchByDoctor();
            viewAppointments();
            break;
         }
         case "3":
         {
             adminFeatures();
             break;
         }
         default :
         {
            print("Enter Valid options...");
            viewAppointments();
         }
      }
   }

   private static void searchByDate(){
        print("\n------ Enter The Date -------");
      
       LocalDate.now();
       LocalDate date=LocalDate.of(Input.year(), Input.month(), Input.date());
        ArrayList<Appointment> appointment=((Admin) Account.user).getAppointment(date);

       if(appointment==null||appointment.isEmpty())
       {
         print("\nNO APPOINTMENTS ON THAT DAY");
         viewAppointments();
       }
       else{
           System.out.printf("%-10s %-10s %-10s/n","DOCTOR-ID","PATIENT-ID","TIME");
           for(int i=0;i<appointment.size();i++){
               System.out.printf(" %-10s %-10s %-10s/n ",appointment.get(i).getDoctorId(),appointment.get(i).getPatientId(),appointment.get(i).getTime());
           }
       }
   }

   private static void searchByDoctor(){
      print("\nENTER DOCTOR NAME :");
         String name=Input.getFromUser();
         ArrayList<Doctor> list=((Admin) Account.user).searchDoctor(name);

         if(list==null||list.isEmpty()){
            print("\nNO DOCTORS AVAILABLE IN THAT NAME");
         }

         else{
            print("\nSelect Below Doctor(s) to view their Appointments");
            System.out.printf("%-20s %-20s %-20s","DOCTOR-ID","DOCTOR NAME","SPECIALITY");

            for(int i=0;i<list.size();i++){
               Doctor doc=list.get(i);
               System.out.printf("%-20s %-20s %-20s","\n"+(i+1)+". ",doc.getName(),doc.getId(),doc.getSpeciality());
            }

            String choice=Input.getFromUser();

            if(!Validate.onlyNumber(choice)&&Integer.parseInt(choice)>=list.size()){
               print("\nEnter Valid choice :");
               searchByDoctor();
            }
            else{
               Doctor doctor=list.get(Integer.parseInt(choice)-1);
               HashMap<LocalDate, Appointment[]> AppointDate=doctor.viewAppointments();
          
               ArrayList<LocalDate> datelist=new ArrayList<>();
             
               for(int i=0;i<7;i++){
                  LocalDate d=LocalDate.now().plusDays(i);

                 if(AppointDate.containsKey(d))
                 {
                     datelist.add(d);
                 }
               }
               
               if(datelist.isEmpty()||datelist==null){
                print("\n No Appointments for 7 days");
               }
               else
               {
                  print("Select Below Date To See ");
                  for(int i=0;i<datelist.size();i++){
                     print((i+1)+". "+datelist.get(i));
                  }
                  String choice1=Input.getFromUser();

                  if(!Validate.onlyNumber(choice1)&&Integer.parseInt(choice1)>=datelist.size()){
                     print("\nEnter Valid choice :");
                     viewAppointments();
                  }
                  else{
                     LocalDate date=datelist.get(Integer.parseInt(choice1)-1);
                     Appointment[] appoint=doctor.viewAppointments(date);

                     for(Appointment a:appoint){
                        if(a!=null){
                           print("Patient id : "+a.getPatientId()+" Time : "+a.getTime());
                        }
                     }
                  }  
               }
            }

         }

      
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

       private static void print(String string)
       {
        System.out.println(string);
       }
      

       private static void choice()
       {
        print("\nEnter Your Choice :\n");
       }
//---------------------------------------------------------------------------------------------------------------------------------------//

       
}
