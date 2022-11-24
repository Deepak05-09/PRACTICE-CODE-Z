package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Receptionist;
import Hospital_Management.MIDDLE_LAYER.Utils;
import Hospital_Management.MIDDLE_LAYER.Visitors;

public class ReceptionistPage {
    
   static void receptionistFeatures()
   {
      Home.employeefeatures();
      print("6. ADD PATIENT\n7. UPDATE PATIENT DETAILS\n8. DOCTOR AVAILABILITY\n9. VISITOR ENTRY\n10. VIEW VISITORS LIST\n11.CREATE APPOINTMENT\n12.CANCEL APPOINTMENT");
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
            receptionistFeatures();
            break;
         }

         case "3":
         {
            checkOut();
            receptionistFeatures();
            break;
         }

         case "4":
         {
            ViewProfile();
            receptionistFeatures();
            break;
         }
         
         case "5" :
             {
                  changePassword();
                  receptionistFeatures();
                  break;
             }
         case "6":
         {
            ((Receptionist) Account.user).addPatient(Input.name(),Input.age(),Input.sex(), Input.bloodGroup(), Input.weight(), Input.height(), Input.ph_no(),Input.allergies());
            receptionistFeatures();
            break;
         }

         case "7":
         {  
            print("\nEnter  ID to Update Details : "); 
            updatePatientDetails(Input.patientId());
            receptionistFeatures();
            break;
         }

         case "8":
         {
            doctorAvailability(LocalDate.now());
            receptionistFeatures();
            break;
         }

         case "9":
         {
            ((Receptionist) Account.user).addVisitors();
            receptionistFeatures();
            break;
         }

         case "10":
         {
            visitorList();
            receptionistFeatures();
            break;
         }

         case "11":
         {
            createAppointment();
            receptionistFeatures();
            break;
         }
         case "12":
         {
            cancelAppointment();
            receptionistFeatures();
            break;
         }

         default :
         {
            print("\nInvalid choice....!");
            receptionistFeatures(); 
         }

      }

   }
//---------------------------------------------------------------------------------------------------------------------------------------//
    
   private static void checkIn()
   {
      if(((Receptionist) Account.user).checkIn())
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
      if(((Receptionist) Account.user).checkOut())
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
      if(((Receptionist) Account.user).getPassword().equals(Input.getFromUser())){
         print("\nEnter new Password :");
         String password=Input.password();
         print("\nRe-Type Your new Password :");
         if(password.equals(Input.getFromUser())){
           ((Receptionist) Account.user).changePassword(password);
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

   private static void doctorAvailability(LocalDate date)
   {
      ArrayList<Doctor> list=Utils.doctorAvailability(date);

      if(!list.isEmpty())
      {
         print("\nAvailable Doctor(s) is/are\n");

         for(Doctor doctor:list)
         {
            print("ID: "+doctor.getId()+" Name : "+doctor.getName());
         }
      }
      else
      {
         print("\nNo Doctors Currently Available");
      }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void visitorList()
   {
      ArrayList<Visitors> list=((Receptionist) Account.user).showVisitorsList();

      if(list.isEmpty())
      {
         print("\nNo Visitors visited");
      }
      else
      {
         for(Visitors visitors : list)
         {
            print(visitors.toString());
         }
      }
                  
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void updatePatientDetails(String id){
       if(((Receptionist) Account.user).isPatientExists(id))
       {
         Patient patient= ((Receptionist) Account.user).search(id);
         viewPatientDetails(patient);
       }
       else
       {
         print("\nNo Patient Found");
       }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   public static void viewPatientDetails(Patient patient)
   {  
      print("--------------- PATIENTS'S DETAILS -----------------");
      print("\n01. Patient's ID          :"+patient.getId());
      print("\n02. Patient's Name        :"+patient.getName());
      print("\n03. Patient's Age         :"+patient.getAge());
      print("\n04. Patient's Gender      :"+patient.getSex());
      print("\n05. Patient's Blood Group :"+patient.getBloodtype());
      print("\n06. Patient's Height      :"+patient.getHeight());
      print("\n07. Patient's Weight      :"+patient.getWeight());
      print("\n08. Patient's Phone No    :"+patient.getPh_no());
      print("\n09. Patient's Allergy To  :"+patient.getAllergyTo());
      print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
      Home.printLine();

      switch(Input.getFromUser())
      {
         case "1":updatePatient(patient);break;

         case "2":receptionistFeatures();break;

         default:print("Invalid Option...!\n...THANK YOU....");receptionistFeatures();
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void updatePatient(Patient patient)
   {
      print("\nNote : \"Patient's ID cannot be Edited\"");
      print("\nSelect from Patient's Details to Edit or PRESS \"0\" to BACK");

      switch(Input.getFromUser())
      {
         case "0":
         {  
            receptionistFeatures();
            break;
         }

         case "1":
         {
            print("\nSorry....! Patient's ID cannot Be Edited...");
            updatePatient(patient);
            break;
         }

         case "2":
         {
             patient.setName(Input.name());
             print("\nName Updated Successfully...");
             updatePatient(patient);
             break;
         }

         case "3":
         {
            patient.setAge(Input.age());
            print("\nAge Updated Successfully...");
            updatePatient(patient);
            break;
         }

         case "4":
         {
            patient.setSex(Input.sex());
            print("\nGender Updated Successfully...");
            updatePatient(patient);
            break;
         }

         case "5":
         {
            patient.setBloodgroup(Input.bloodGroup());
            print("\nBlood Group Updated Successfully...");
            updatePatient(patient);
            break;
         }

         case "6":
         {
            patient.setHeight(Input.height());
            print("\nHeight Updated Successfully...");
            updatePatient(patient);
            break;
         }

         case "7":
         {
            patient.setWeight(Input.weight());
            print("\nWeight Updated Successfully...");
            updatePatient(patient);
            break;
         }

         case "8":
         {
            patient.setPh_no(Input.ph_no());
            print("\nPhone Number Updated Successfully...");
            updatePatient(patient);
            break;
         }

         case "9":
         {
            patient.setAllergyTo(Input.allergies());
            print("\nupdated Successfully....");
            updatePatient(patient);
            break;
         }

         default : print("\nInvalid Option....!"); updatePatient(patient);

      }
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void ViewProfile()
   {
      Home.printLine();
      print("\n01. Name            : "+((Receptionist) Account.user).getName());
      print("\n02. ID              : "+((Receptionist) Account.user).getId());
      print("\n03. MAIL            : "+((Receptionist) Account.user).getMail());
      print("\n04. Ph.No           : "+((Receptionist) Account.user).getPhnNo());
      print("\n05. Date.of.Birth   : "+((Receptionist) Account.user).getDateOfBirth());
      print("\n06. Age             : "+((Receptionist) Account.user).getAge());
      print("\n07. Gender          : "+((Receptionist) Account.user).getSex());
      print("\n08. Date Joined     : "+((Receptionist) Account.user).getDateJoined());
      print("\n09. Role            : "+((Receptionist) Account.user).getRole());
      print("\n10. Address         : "+((Receptionist) Account.user).getAddress());
      print("\n11. Education       : "+((Receptionist) Account.user).getEducation());
      print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
      Home.printLine();

      switch(Input.getFromUser())
      {
         case "1":editProfile();break;

         case "2":receptionistFeatures();break;

         default:print("\nInvalid Option...!\n...THANK YOU....");receptionistFeatures();
      } 
   }
//---------------------------------------------------------------------------------------------------------------------------------------//

   private static void editProfile()
   {  print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":receptionistFeatures();break;

         case "1":
         {
            ((Receptionist) Account.user).setName(Input.name());
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
            ((Receptionist) Account.user).setMail(Input.mail());
            print("\nMail Updated Successfully....");
            editProfile();
            break;
         }

         case "4":
         {
            ((Receptionist) Account.user).setPhnNo(Input.ph_no());
            print("\nPhone number Updated Successfully....");
            editProfile();
            break;
         }

         case "5":
         {
            ((Receptionist) Account.user).setDateOfBirth(Input.dateOfBirth());
            print("\nDate.Of.Birth Updated Successfully....");
            editProfile();
            break;
         }
          
         case "6":
         {
            ((Receptionist) Account.user).setAge(Input.employeeAge());;
            print("\nAge Updated Successfully....");
            editProfile();
            break;
         }

         case "7":
         {
            ((Receptionist) Account.user).setSex(Input.sex());;
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
            ((Receptionist) Account.user).setAddress(Input.address());;
            print("\nAddress Updated Successfully....");
            editProfile();
            break;
         }

         case "11":
         {
            ((Receptionist) Account.user).setEducation(Input.education());;
            print("\nEducation Updated Successfully....");
            editProfile();
            break;
         }

         default : print("\nInvalid Option....!");editProfile();
      }
   }

   private static void createAppointment(){
     
      LocalDate date=printDate();
      if(date==null){
         receptionistFeatures();
      }
      else{
         doctorAvailability(date);
         
            print("\nEnter Doctor ID : ");
            String doctorId=Input.getFromUser();

            if(containsDoctorId(doctorId,date)){
               print("\nEnter Patient ID : ");
               String patientId=Input.getFromUser();

               if(!((Receptionist) Account.user).isPatientExists(patientId)){
                  print("\nNo Patient Exists in that ID..");
               }
               else{
                  int slot=selectSlot(Utils.getDoctor(doctorId), date);

                  if(slot>=0){

                     ((Receptionist) Account.user).createAppointment(date,patientId, doctorId,slot);
                     print("\nAppointment created Successfully for patient Id :"+patientId+" on "+date);
                  }
                  else{
                     print("\nSorry Cannot Book Appointment retry...");
                  }
               }
            }
            else{
               print("Please Enter correct Id..");
            }
         
         }
     // }
     
    }

    private static boolean containsDoctorId(String id,LocalDate date){
      ArrayList<Doctor> list=Utils.doctorAvailability(date);
      for(Doctor doctor:list){
         
        if(doctor.getId().equals(id)){
         return true;
        }
      }
      return false;
    }

    private static LocalDate printDate(){
       print("\nSelect the below Date to Book Appointments \n");
       for(int i=0;i<7;i++){
         print((i+1)+". "+LocalDate.now().plusDays(i)+" "+LocalDate.now().plusDays(i).getDayOfWeek());
       }
       switch(Input.getFromUser()){

         case "1" :
         {
                return LocalDate.now().plusDays(0);
         }
         case "2" :
         {
                return LocalDate.now().plusDays(1);
         }
         case "3" :
         {
                return LocalDate.now().plusDays(2);
         }
         case "4" :
         {
                return LocalDate.now().plusDays(3);
         }
         case "5" :
         {
                return LocalDate.now().plusDays(4);
         }
         case "6" :
         {
                return LocalDate.now().plusDays(5);
         }
         case "7" :
         {
                return LocalDate.now().plusDays(6);
         }
         default : {
                print("\nSelect valid option");
         }
       }
      return null;
    }

    private static int selectSlot(Doctor doctor,LocalDate date){
      Appointment[] arr=Utils.getAppointment(doctor,date);
      
      boolean flag=false;
      print("\nAvailable Slots Are/is :");
       for(int i=0;i<arr.length;i++){
         if(arr[i]==null){
         flag=true;
        
           switch(i)
           {
            case 0 : print("\nSlot no: 1  Time :  9:00Am - 9:25Am"); break;
            case 1 : print("\nSlot no: 2  Time :  9:30Am - 9:55Am"); break;
            case 2 : print("\nSlot no: 3  Time :  10:00Am - 10:25Am"); break;
            case 3 : print("\nSlot no: 4  Time :  2:00Pm - 2:25Pm"); break;
            case 4 : print("\nSlot no: 5  Time :  2:25Pm - 3:00Pm"); break;
           }
         }
       }
       if(!flag){
         print("\nSorry..! Currently No Slots Are Available For This Doctor");
       }
       else{
         print("\nEnter Slot Number :");
         String slot=Input.getFromUser();
         if(Validate.onlyNumber(slot)&&Integer.parseInt(slot)>0&&Integer.parseInt(slot)<=5){
            return Integer.parseInt(slot)-1;
         }
         else{
            print("\nEnter Valid Slot Number");
         }
       }
       return -1;
       
    }

    private static void cancelAppointment(){
         print("\n---------------  CANCEL APPOINTMENT -------------------");
         print("\nEnter Patient id :");
         String patientId=Input.getFromUser();

         ArrayList<Appointment> appointlist= Utils.getAppointment(patientId);
         if(appointlist==null||appointlist.isEmpty()){
            print("\nNO APPOINTMENTS FOUND IN THAT ID");
         }
         else{

            for(int i=0;i<appointlist.size();i++){
               print((i+1)+". Doctor ID : "+appointlist.get(i).getDoctorId()+" Time : "+appointlist.get(i).getTime());
            }

            print("\nSELECT CHOICE TO CANCEL THAT APPOINTMENT");
            String choice=Input.getFromUser();

            if(Validate.onlyNumber(choice)&&Integer.parseInt(choice)-1<appointlist.size()&&Integer.parseInt(choice)>0){
               Appointment appointment=appointlist.get(Integer.parseInt(choice)-1);

               if(Input.CancelAppointment()){
                  ((Receptionist) Account.user).CancelAppointment(appointment.getDate(),appointment.getPatientId(),appointment.getTime(),appointment.getDoctorId());
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
//---------------------------------------------------------------------------------------------------------------------------------------//

}
