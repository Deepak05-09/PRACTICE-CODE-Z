package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;

//import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Department;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.DoctorList;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Report;


public class PatientPage {
      
    public Patient user;

    public void menu(){
        HomePage.printLine();
        print("\n1.VIEW PROFILE\n2.CHANGE PASSWORD\n3.BOOK APPOINTMENT\n4.CANCEL APPOINTMENT\n5.VIEW REPORT\n6.LOGOUT");
        HomePage.printLine();
        
        System.out.println("\nENTER YOUR CHOICE :");
        switch(Input.getFromUser()){
            case "1" :{
                viewProfile();
                menu();
                break;
            }
            case "2" :{
                changePassword();
                menu();
                break;
            }
            case "3" :{
                bookAppointment();
                menu();
                break;
            }
            case "4" :{
                cancelAppointment();
                menu();
                break;
            }
            case "5" :{
                viewReport();
                menu();
                break;
            }
            
            case "6" :{
               user=null;
                print("\n......LOGGED OUT.....");
                HomePage.menu();
                break;
            }
            default :{
                print("\nInvalid choice....!");
                menu();
            }
            
        }
    }

        public void viewProfile()
    {  
        print("--------------- PATIENTS'S DETAILS -----------------");
        print("\n01. ID          :"+user.getId());
        print("\n02. Name        :"+user.getName());
        print("\n03. Age         :"+user.getAge());
        print("\n04. Gender      :"+user.getSex());
        print("\n05. Blood Group :"+user.getBloodtype());
        print("\n06. Height      :"+user.getHeight());
        print("\n07. Weight      :"+user.getWeight());
        print("\n08. Phone No    :"+user.getPh_no());
        print("\n09. Allergy To  :"+user.getAllergyTo());
        print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
        HomePage.printLine();

        switch(Input.getFromUser())
        {
            case "1":updateDetails();break;

            case "2":menu();break;

            default:print("Invalid Option...!\n...THANK YOU....");menu();
        } 
    }

    private void updateDetails()
    {
        print("\nNote : \" ID cannot be Edited\"");
        print("\nSelect from Profile to Edit or PRESS \"0\" to BACK");

        switch(Input.getFromUser())
        {
            case "0":
            {  
                menu();
                break;
            }

            case "1":
            {
                print("\nSorry....! ID cannot Be Edited...");
                updateDetails();
                break;
            }

            case "2":
            {
                user.setName(Input.name());
                print("\nName Updated Successfully...");
                updateDetails();
                break;
            }

            case "3":
            {
                user.setAge(Input.age());
                print("\nAge Updated Successfully...");
                updateDetails();
                break;
            }

            case "4":
            {
                user.setSex(Input.sex());
                print("\nGender Updated Successfully...");
                updateDetails();
                break;
            }

            case "5":
            {
                user.setBloodgroup(Input.bloodGroup());
                print("\nBlood Group Updated Successfully...");
                updateDetails();
                break;
            }

            case "6":
            {
                user.setHeight(Input.height());
                print("\nHeight Updated Successfully...");
                updateDetails();
                break;
            }

            case "7":
            {
                user.setWeight(Input.weight());
                print("\nWeight Updated Successfully...");
                updateDetails();
                break;
            }

            case "8":
            {
                user.setPh_no(Input.ph_no());
                print("\nPhone Number Updated Successfully...");
                updateDetails();
                break;
            }

            case "9":
            {
                user.setAllergyTo(Input.allergies());
                print("\nupdated Successfully....");
                updateDetails();
                break;
            }

            default : print("\nInvalid Option....!"); updateDetails();

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

    private void bookAppointment(){
        
        Department department=selectDepartment();

        if(department!=null){
 
          LocalDate date=printDate(department);
 
          if(date!=null){
 
             doctorAvailability(date,department);
             print("\nEnter Doctor ID : ");
             String doctorId=Input.getFromUser();
 
                if(containsDoctorId(doctorId,date,department)){
 
                   int slot=selectSlot(DoctorList.get(doctorId), date);
 
                      if(slot>=0){
 
                         Appointment.createAppointment(date,user.getName(), user.getPh_no(),doctorId,slot);
                         print("\nAppointment created Successfully on "+date);
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

        ArrayList<Appointment> appointlist= Appointment.viewAppointment(user.getName());
        if(appointlist==null||appointlist.isEmpty()){
            print("\nNO APPOINTMENTS FOUND ");
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

    private void viewReport()
    {
    
        ArrayList<Report> list=user.viewReports();
        
        if(list.isEmpty()||list==null){
            print("\nNo Reports Available ");
        }
        else
        {  
            print("\n-------------- REPORT-------------\n");
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

    private  void printReport(Report report)
    {
        print("\n--------------- REPORT ---------------");
        print("\n\nReport ID          :"+report.getId());
        print("\nPatient Id          :"+report.getPatientId());
        print("\nGenerated By        :"+report.getGeneratedBy());
        print("\nDescription         :"+report.getdescription());
        print("\nTreatement Provided :"+report.getTreatementProvided());
        print("\nMedicine Prescribed :"+report.getMedicinePrescribed());
        HomePage.printLine();
    }


    private void print(String value){
        System.out.println(value);
    }

}
