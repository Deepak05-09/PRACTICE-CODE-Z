package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

//import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.DoctorList;
import Hospital_Management.MIDDLE_LAYER.Login;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Report;
import Hospital_Management.MIDDLE_LAYER.Review;
import Hospital_Management.MIDDLE_LAYER.Slot;

public class DoctorPage {
   
   private String id;
   private Doctor user;
   
   public DoctorPage(String id,Doctor doctor){
      this.id=id;
      user=doctor;
   }
   public void doctorFeatures()
   {
      HomePage.employeefeatures();
      print("6. GENERATE REPORT\n7. VIEW PATIENT REPORT\n8. STATUS\n9. VIEW APPOINTMENTS\n10. SLOT CHANGE\n11. VIEW REVIEWS");
      HomePage.printLine();

      choice();

      switch( input.getFromUser())
      {
            case "1":
            {  
               user=null;
               print("\n......THANK YOU.....");
               HomePage homePage=new HomePage();
                  homePage.menu();
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
            case "10" :{
               slotChange();
               doctorFeatures();
               break;
            }
            case "11":{
               viewReviews();
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

//---------------------------------------------------------------------------------------------------------------------------------------//

   private void ViewProfile()
   {
      Doctor doctor=user.viewProfile();
      HomePage.printLine();
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
      HomePage.printLine();

      switch( input.getFromUser())
      {
         case "1":editProfile();break;

         case "2":doctorFeatures();break;

         default:print("\nInvalid Option...!\n...THANK YOU....");doctorFeatures();;
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private void editProfile()
   {  print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch( input.getFromUser())
      {
         case "0":doctorFeatures();break;

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
//---------------------------------------------------------------------------------------------------------------------------------------//
      
   private void generateReport()
   {
         print("\nEnter Patient's Id to Generate report");
               String id= input.getFromUser();
               if(Patient.ispatientExists(id))
               {
            user.generatReport( id,  input.reason(),  input.treatementProvided(), input.prescribe());
               print("\n\nReport Generated SuccessFully" );
               }
               else
               {
                  print("\nOops...!  There is No Patient In That ID.....");
               }
   }

//---------------------------------------------------------------------------------------------------------------------------------------//

   private void viewPatientReport()
   {
      print("\nEnter ID to view Patient's Report");
      String id= input.patientId();
         
      if(Patient.ispatientExists(id))
      {
               ArrayList<Report> list=user.viewPatientReport(id);
               
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
                  String  val=input.getFromUser();
                  if(  validate.onlyNumber( val))
                  {
                     if(Integer.parseInt( val)>0&&Integer.parseInt( val)<=list.size())
                     {
                        printReport(list.get(Integer.parseInt( val)-1));
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
   private  void printReport(Report report)
   {
      print("\n--------------- REPORT ---------------");
      print("\n\nReport ID         :"+report.getId());
      print("\nPatient Id          :"+report.getPatientId());
      print("\nGenerated By        :"+report.getGeneratedBy());
      print("\nDescription         :"+report.getdescription());
      print("\nTreatement Provided :"+report.getTreatementProvided());
      print("\nMedicine Prescribed :"+report.getMedicinePrescribed());
      HomePage.printLine();
   }

   private void changeStatus(){
         print("Note : Only above 7 days availability can be Changed from Current date");
         for(int i=7;i<=13;i++){
         ArrayList<LocalDate>dates= doctorList.DocAvailDateDoctor(user);

         if(dates.contains(LocalDate.now().plusDays(i))){
            print("\n"+(i-6)+". "+LocalDate.now().plusDays(i)+" "+LocalDate.now().plusDays(i).getDayOfWeek()+"  AVAILABLE");
         }
         else{
            print("\n"+(i-6)+". "+LocalDate.now().plusDays(i)+" "+LocalDate.now().plusDays(i).getDayOfWeek()+"  NOT-AVAILABLE");
         }
         }
         print("\nselect options to change availability on the given date :");
            choice();
            switch( input.getFromUser()){
               case "1":
               {
               user.changeAvailability(LocalDate.now().plusDays(7));
                  print("\nStatus Changed  on "+LocalDate.now().plusDays(7));
                  
                  break;
               } 
               case "2":
               {
               user.changeAvailability(LocalDate.now().plusDays(8));
                  print("\nStatus Changed on "+LocalDate.now().plusDays(8));
                  
                  break;
               } 
               case "3":
               {
               user.changeAvailability(LocalDate.now().plusDays(9));
                  print("\nStatus Changed on "+LocalDate.now().plusDays(9));
                  
                  break;
               } 
               case "4":
               {
               user.changeAvailability(LocalDate.now().plusDays(10));
                  print("\nStatus Changed  on "+LocalDate.now().plusDays(10));
               
                  break;
               } 
               case "5":
               {
               user.changeAvailability(LocalDate.now().plusDays(11));
                  print("\nStatus Changed  on "+LocalDate.now().plusDays(11));
               
                  break;
               } 
               case "6":
               {
               user.changeAvailability(LocalDate.now().plusDays(12));
                  print("\nStatus Changed on "+LocalDate.now().plusDays(12));
               
                  break;
               } 
               case "7":
               {
               user.changeAvailability(LocalDate.now().plusDays(13));
                  print("\nStatus Changed  on "+LocalDate.now().plusDays(13));
               
                  break;
               } 
               
               default :
               {
                  print("\nEnter Valid Choice");
               }
            }
   }

   private void viewAppointments(){
         HashMap<LocalDate, Slot[]> AppointDate=user.viewAppointments();
         
         ArrayList<LocalDate> list=new ArrayList<>();
         
         for(int i=0;i<7;i++){
               LocalDate d=LocalDate.now().plusDays(i);
            if(AppointDate.containsKey(d))
            {
               Slot[] slot=AppointDate.get(d);
               for(Slot s: slot){
                  if(s.appointment!=null){
                     list.add(d);
                  }
               }
               
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
            String choice= input.getFromUser();
            if(!  validate.onlyNumber(choice)&&Integer.parseInt(choice)>=list.size()){
               print("\nEnter Valid choice :");
               viewAppointments();
            }
            else{
               LocalDate date=list.get(Integer.parseInt(choice)-1);
               Slot[] appoint=user.ViewAppointment(date);
               for(Slot s:appoint){
                  if(s!=null){
                  Appointment a=s.appointment;
                  if(a!=null)
                  print("Patient id : "+a.getPatientName()+" Mobile no :"+a.getPmbl_no()+" Time : "+a.getTime());
               }
            }
            }  
         }
   }

   private void slotChange(){
         ArrayList<LocalDate>dates= doctorList.DocAvailDateDoctor(user);
         
         for(int i=0;i<dates.size();i++){
            LocalDate date=dates.get(i);
            System.out.println((i+1)+". "+date+" slots :"+user.ViewAppointment(date).length);
         }
         System.out.println("\nSELECT TO CHANGE SLOT");
         String choice=input.getFromUser();

         if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)<=dates.size()&&Integer.parseInt(choice)>0){
            LocalDate date=dates.get(Integer.parseInt(choice)-1);
            System.out.println("\n MIN : 1           MAX: 7");
            System.out.println("\nENTER NO OF SLOTS : ");
            String in=input.getFromUser();
            
            if( validate.onlyNumber(in)&&Integer.parseInt(in)<=7&&Integer.parseInt(in)>0){
               int slot=Integer.parseInt(in);
               user.changeSlot(date, slot);
               System.out.println("\nCHANGED TO "+slot+" SLOT(S) ON "+date);

               for(int i=0;i<slot;i++){
                  System.out.println("\n\nSLOT "+(i+1));
                  System.out.println("\nENTER START TIME :");
                  String startTime=input.getFromUser();
                  System.out.println("\nENTER END TIME :");
                  String endTime=input.getFromUser();
                  user.setSlotTime(date, i, startTime, endTime);
                  System.out.println("TIME UPDATED SUCCESSFULLY FOR SLOT-"+(i+1));
               }
            }

         }
         else{
            System.out.println("\nInvalid  input");
         }
   }

   private void viewReviews(){
     
      ArrayList<Review> reviews=user.viewReviews();
      if(reviews.isEmpty()){
         System.out.println("\nNO REVIEWS HAS POSTED");
      }
      for(Review review: reviews){
         printReview(review);
      }
   }

   private void printReview(Review review){
        System.out.println("\n"+review.getrName()+"\n");
        System.out.print("\nRATINGS : ");
        for(int i=1;i<=review.getStar();i++){
         System.out.print("* ");
        }
        
        if(!review.getPros().equals("")){
         System.out.println("\nPROS :"+review.getPros());
        }
        if(!review.getCons().equals("")){
         System.out.println("\nCONS :"+review.getCons());
        }
        if(!review.getDescription().equals("")){
         System.out.println("\nTHOUGHT :"+review.getDescription());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
   }

//---------------------------------------------------------------------------------------------------------------------------------------//
   private void print(String string)
   {
      System.out.println(string);
   }
//---------------------------------------------------------------------------------------------------------------------------------------//
   
      private void choice()
      {
      print("\nEnter Your Choice :\n");
      }
      private DoctorList doctorList=new DoctorList();
      private  Input input=new Input();
      private Validate validate=new Validate();
}
