package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Admin;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.AppointmentList;
import Hospital_Management.MIDDLE_LAYER.Bill;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Employee;
import Hospital_Management.MIDDLE_LAYER.Login;

import Hospital_Management.MIDDLE_LAYER.Slot;



public class AdminPage {
   
      private String id;
      private Admin user;
      
      public AdminPage(String id,Admin admin){
      this.id=id;
      user=admin;
      }
      public void adminFeatures()
      {
         
         HomePage.employeefeatures();

         print("6. ADD ADMIN\n7. ADD DOCTOR\n8. ADD RECEPTIONIST\n9. ADD CASHIER\n10. REMOVE EMPLOYEE\n11. VIEW APPOINTMENT\n12.SEARCH EMPLOYEE\n13.VIEW ALL EMPLOYEE\n14.VIEW BILL");
         HomePage.printLine();
         choice();

         switch(input.getFromUser())
         {
            case "1":
            {
                  print("\n......THANK YOU.....");
                  user=null;
                  HomePage homePage=new HomePage();
                  homePage.menu();
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
               user.createNewAdmin(input.name(), input.ph_no(), input.dateOfBirth(), input.employeeAge(), input.sex(), input.mail(), input.address(), input.education(), input.password());
                  adminFeatures();
                  break;
            }

            case  "7":
            {
               user.addDoctor( input.name(), input.ph_no(), input.dateOfBirth(), input.employeeAge(), input.sex(), input.mail(), input.address(), input.education(), input.speciality(), input.password(),input.experience()); 
                  adminFeatures();
                  break;
            }

            case  "8":
            {
               user.addReceptionist( input.name(), input.ph_no(), input.dateOfBirth(), input.employeeAge(), input.sex(), input.mail(), input.address(), input.education(), input.password());
                  adminFeatures();
                  break;
            }

            case  "9":
            {
               user.addCashier( input.name(), input.ph_no(), input.dateOfBirth(), input.employeeAge(), input.sex(), input.mail(), input.address(), input.education(), input.password());
                  adminFeatures();
            }

            case  "10":
            {
                  if(viewAll())
                  {
                  print("\nENTER EMPLOYEE ID TO REMOVE");
                  print(user.removeEmployee( input.getFromUser()));
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
         Login login=new Login();
         print("\nEnter Your Current Password : ");
         if(login.isPasswordCorrect(id, input.getFromUser())){
            print("\nEnter new Password :");
            String password= input.password();
            print("\nRe-Type Your new Password :");
            if(password.equals( input.getFromUser())){
            
               login.changePassword(id, password);
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
         Employee employee=user.viewEmployee( input.getFromUser());

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

      switch( input.getFromUser())
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

      switch( input.getFromUser())
      {
         case "0":adminFeatures();break;

         case "1":
         {
         user.setName( input.name());
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
         user.setMail( input.mail());
            print("\nMail Updated Successfully....");
            editProfile();
            break;
         }

         case "4":
         {
         user.setPhnNo( input.ph_no());
            print("\nPhone number Updated Successfully....");
            editProfile();
            break;
         }

         case "5":
         {
         user.setDateOfBirth( input.dateOfBirth());
            print("\nDate.Of.Birth Updated Successfully....");
            editProfile();
            break;
         }
         
         case "6":
         {
         user.setAge( input.employeeAge());;
            print("\nAge Updated Successfully....");
            editProfile();
            break;
         }

         case "7":
         {
         user.setSex( input.sex());;
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
         user.setAddress( input.address());;
            print("\nAddress Updated Successfully....");
            editProfile();
            break;
         }

         case "11":
         {
         user.setEducation( input.education());;
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
      switch( input.getFromUser())
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
      LocalDate date=LocalDate.of( input.year(),  input.month(),  input.date());
      ArrayList<Appointment> appointment=appointmentList.getAppointment(date);

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
         String name= input.getFromUser();
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

            String choice= input.getFromUser();

            if(!  validate.onlyNumber(choice)&&Integer.parseInt(choice)>=list.size()){
               print("\nEnter Valid choice :");
               searchByDoctor();
            }
            else{
               Doctor doctor=list.get(Integer.parseInt(choice)-1);
               HashMap<LocalDate,Slot[]> AppointDate=doctor.viewAppointments();
         
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
                  String choice1= input.getFromUser();

                  if(!  validate.onlyNumber(choice1)&&Integer.parseInt(choice1)>=datelist.size()){
                     print("\nEnter Valid choice :");
                     viewAppointments();
                  }
                  else{
                     LocalDate date=datelist.get(Integer.parseInt(choice1)-1);
                     Slot[] appoint=doctor.ViewAppointment(date);

                     for(Slot s:appoint){
                        Appointment a=s.appointment;
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
      String patientId= input.getFromUser();
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

      private  void print(String string)
      {
      System.out.println(string);
      }
      

      private  void choice()
      {
      print("\nEnter Your Choice :\n");
      }

      private AppointmentList appointmentList=new AppointmentList();
      private  Input  input=new Input();
      private Validate validate=new Validate();
}
