package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Admin;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Bill;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Employee;



public class AdminPage {
     
      
      public Admin user;

       public void adminFeatures()
        {
          
          HomePage.employeefeatures();

          print("6. ADD ADMIN\n7. ADD DOCTOR\n8. ADD RECEPTIONIST\n9. ADD CASHIER\n10. REMOVE EMPLOYEE\n11. VIEW APPOINTMENT\n12.SEARCH EMPLOYEE\n13.VIEW ALL EMPLOYEE\n14.VIEW BILL");
          HomePage.printLine();
          choice();

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
                 user.createNewAdmin(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                  adminFeatures();
                  break;
              }

             case  "7":
             {
                 user.addDoctor(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.speciality(),Input.password()); 
                  adminFeatures();
                  break;
             }

             case  "8":
             {
                 user.addReceptionist(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                  adminFeatures();
                  break;
             }

             case  "9":
             {
                 user.addCashier(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                  adminFeatures();
             }

             case  "10":
             {
                  if(viewAll())
                  {
                  print("\nENTER EMPLOYEE ID TO REMOVE");
                  print(user.removeEmployee(Input.getFromUser()));
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

             case "14" :
             {
                viewBill();
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

       private  void checkIn()
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
      
       private  void checkOut()
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
      
      private  void changePassword(){
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

       private  void search()
       {
         print("\nENTER EMPLOYEE ID TO SEARCH : \n");
         Employee employee=user.viewEmployee(Input.getFromUser());

         if(employee==null)
         {
            print("\nNo Employee Available In that ID");
         }
         else
         {
            print(employee.toString());
         }

       }


       private  boolean viewAll()
       {
         ArrayList<Employee> list=user.viewAll();
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
  
       private  void ViewProfile()
      {
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

         case "2":adminFeatures();break;

         default:print("Invalid Option...!\n...THANK YOU....");adminFeatures();;
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private  void editProfile()
   {  print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":adminFeatures();break;

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

   private  void viewAppointments(){
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

   private  void searchByDate(){
        print("\n------ Enter The Date -------");
      
       LocalDate.now();
       LocalDate date=LocalDate.of(Input.year(), Input.month(), Input.date());
        ArrayList<Appointment> appointment=Appointment.getAppointment(date);

       if(appointment==null||appointment.isEmpty())
       {
         print("\nNO APPOINTMENTS ON THAT DAY");
         viewAppointments();
       }
       else{
           System.out.printf("%-10s %-10s %-10s %-10s/n","DOCTOR-ID","PATIENT-NAME","MOBILE ","TIME");
           for(int i=0;i<appointment.size();i++){
               System.out.printf(" %-10s %-10s %-10s/n ",appointment.get(i).getDoctorId(),appointment.get(i).getPatientName(),appointment.get(i).getPmbl_no(),appointment.get(i).getTime());
           }
       }
   }

   private  void searchByDoctor(){
      print("\nENTER DOCTOR NAME :");
         String name=Input.getFromUser();
         ArrayList<Doctor> list=user.searchDoctor(name);

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
                     Appointment[] appoint=doctor.ViewAppointment(date);

                     for(Appointment a:appoint){
                        if(a!=null){
                           print("Patient id : "+a.getPatientName()+" Mobile no :"+a.getPmbl_no()+" Time : "+a.getTime());
                        }
                     }
                  }  
               }
            }

         }

      
   }

   private void viewBill(){
       print("\nEnter Patient Id to  view All Bill  ");
       LocalDate.now();
       String patientId=Input.getFromUser();
       ArrayList<Bill> bills=user.viewBill(patientId);

       if(bills!=null&&!bills.isEmpty()){
           for(Bill bill:bills){
              print("\n Date :"+bill.billGeneratedOn+" Time : "+bill.time+" Total fees "+bill.total);
           }
       }
       else{
         System.out.println("\nNo BIll records Found");
       }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

       private  void print(String string)
       {
        System.out.println(string);
       }
      

       private  void choice()
       {
        print("\nEnter Your Choice :\n");
       }
//---------------------------------------------------------------------------------------------------------------------------------------//

       
}
