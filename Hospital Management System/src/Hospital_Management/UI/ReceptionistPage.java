package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Department;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.DoctorList;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Receptionist;
import Hospital_Management.MIDDLE_LAYER.Visitors;

public class ReceptionistPage {

   public Receptionist user;
    
    public void receptionistFeatures()
   {
      HomePage.employeefeatures();
      print("6. ADD PATIENT\n7. SEARCH PATIENT\n8. DOCTOR AVAILABILITY\n9. VISITOR ENTRY\n10. VIEW VISITORS LIST\n11.CREATE APPOINTMENT\n12.CANCEL APPOINTMENT");
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
            user.addPatient(Input.name(),Input.age(),Input.sex(), Input.bloodGroup(), Input.weight(), Input.height(), Input.ph_no(),Input.allergies());
            receptionistFeatures();
            break;
         }

         case "7":
         {  
            search();
            receptionistFeatures();
            break;
         }

         case "8":
         {
            LocalDate.now();
            doctorAvailability(LocalDate.of(Input.year(),Input.month(),Input.date()),selectDepartment());
            receptionistFeatures();
            break;
         }

         case "9":
         {
            user.addVisitors();
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

   private void doctorAvailability(LocalDate date,Department department)
   {
      ArrayList<Doctor> list=DoctorList.get(date,department);

      if(!list.isEmpty()&&list!=null)
      {
         print("\nAvailable Doctor(s) is/are\n");

         for(Doctor doctor:list)
         {
            print("ID: "+doctor.getId()+" Name : "+doctor.getName());
         }
      }
      else
      {
         print("\nNo Doctors Available");
      }
   }

   private void visitorList()
   {
      ArrayList<Visitors> list=user.showVisitorsList();

      if(list.isEmpty()||list==null)
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
  

   public void viewPatientDetails(ArrayList<Patient> patients)
   {  
     for(Patient patient:patients){
      System.out.println(patient.getName()+"  "+patient.getId()+"  "+patient.getPh_no());
     }

   }

  

   private void ViewProfile()
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

         case "2":receptionistFeatures();break;

         default:print("\nInvalid Option...!\n...THANK YOU....");receptionistFeatures();
      } 
   }

   private void editProfile()
   {  print("\n\"ID, Date Joined & Role\" Cannot be Edited");
      print("\nSELECT OPTION FROM PROFILE TO EDIT  OR PRESS \"0\" TO BACK");

      switch(Input.getFromUser())
      {
         case "0":receptionistFeatures();break;

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

   private void createAppointment(){

       Department department=selectDepartment();

       if(department!=null){

         LocalDate date=printDate(department);

         if(date!=null){

            doctorAvailability(date,department);
            print("\nEnter Doctor ID : ");
            String doctorId=Input.getFromUser();

               if(containsDoctorId(doctorId,date,department)){

                  print("\nEnter Patient Info  ");
                  String patientName=Input.name();
                  String mbl_no=Input.ph_no();
                  int slot=selectSlot(DoctorList.get(doctorId), date);

                     if(slot>=0){

                       Appointment.createAppointment(date,patientName,mbl_no, doctorId,slot);
                        print("\nAppointment created Successfully for patient  :"+patientName+" on "+date);
                     }
                     else{
                        print("\nSorry Cannot Book Appointment retry...");
                     }
                  }
               }
         }
         else{
            print("\nInvalid Input.");
         }
     
    }
    private Department selectDepartment(){
      print("\nSELECT DEPARTMENT ");

      for(int i=0;i<Department.values().length;i++){
         print("\n"+(i+1)+". "+Department.values()[i]);
      }

      String choice=Input.getFromUser();

      if(Validate.onlyNumber(choice)&&Integer.parseInt(choice)!=0&&Integer.parseInt(choice)<=Department.values().length){
         return Department.values()[Integer.parseInt(choice)-1];
      }
      return null;
    }

    private boolean containsDoctorId(String id,LocalDate date,Department department){
      ArrayList<Doctor> list=DoctorList.get(date,department);
      for(Doctor doctor:list){
         
        if(doctor.getId().equals(id)){
         return true;
        }
      }
      return false;
    }

    private LocalDate printDate(Department department){
       
       boolean flag=false;
       for(int i=0;i<7;i++){
        
         if(DoctorList.get(LocalDate.now().plusDays(i),department).size()!=0){
         flag=true;
         print((i+1)+". "+LocalDate.now().plusDays(i)+" "+LocalDate.now().plusDays(i).getDayOfWeek());
         }
         
       }
       
       if(!flag){
         print("\nSorry No Doctors will be available for 7 days on "+department);

       }
       else{

         print("\nSelect the Above Date to Book Appointments \n");

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
      }
      return null;
    }

    private int selectSlot(Doctor doctor,LocalDate date){
      Appointment[] arr=doctor.ViewAppointment(date);
      
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

    private void cancelAppointment(){
         print("\n---------------  CANCEL APPOINTMENT -------------------");
         print("\nEnter Patient Name :");
         String patientName=Input.getFromUser();
          
         ArrayList<Patient> patients=user.search(patientName);
         ArrayList<Appointment> appointlist=new ArrayList<>();

         for(Patient patient:patients){
            appointlist.addAll(Appointment.viewAppointment(patient.getName()));
         }

         if(appointlist==null||appointlist.isEmpty()){
            print("\nNO APPOINTMENTS FOUND FOR THAT NAME");
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
                  Appointment.CancelAppointment(appointment.getDate(),appointment.getPatientName(),appointment.getTime(),appointment.getDoctorId());
               }

            }
         }
    }

    private void search(){
         
        print("\nEnter Info");
        String search=Input.getFromUser();
       
        ArrayList<Patient> patients= user.search(search);

        if(patients==null||patients.isEmpty()){
            print("\nNO PATIENT FOUND");
        }
        else{
            viewPatientDetails(patients);
        }
    }

   
   private void print(String string)
   {
      System.out.println(string);
   }

   private void choice()
   {
      print("\nEnter Your Choice :\n");
   }

}
