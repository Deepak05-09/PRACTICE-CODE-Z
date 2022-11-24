package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.MIDDLE_LAYER.Account;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Report;
import Hospital_Management.MIDDLE_LAYER.Utils;

public class PatientPage {
      
    
    public static void menu(){
        Home.printLine();
        print("\n1.VIEW PROFILE\n2.CHANGE PASSWORD\n3.BOOK APPOINTMENT\n4.CANCEL APPOINTMENT\n5.VIEW REPORT\n6.LOGOUT");
        Home.printLine();
        
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
                Account.user=null;
                print("\n......LOGGED OUT.....");
                Home.menu();
                break;
            }
            default :{
                print("\nInvalid choice....!");
                menu();
            }
            
        }
    }

        public static void viewProfile()
    {  
        print("--------------- PATIENTS'S DETAILS -----------------");
        print("\n01. ID          :"+((Patient) Account.user).getId());
        print("\n02. Name        :"+((Patient) Account.user).getName());
        print("\n03. Age         :"+((Patient) Account.user).getAge());
        print("\n04. Gender      :"+((Patient) Account.user).getSex());
        print("\n05. Blood Group :"+((Patient) Account.user).getBloodtype());
        print("\n06. Height      :"+((Patient) Account.user).getHeight());
        print("\n07. Weight      :"+((Patient) Account.user).getWeight());
        print("\n08. Phone No    :"+((Patient) Account.user).getPh_no());
        print("\n09. Allergy To  :"+((Patient) Account.user).getAllergyTo());
        print("\nSELECT\n\n1. EDIT PROFILE\n2. BACK");
        Home.printLine();

        switch(Input.getFromUser())
        {
            case "1":updateDetails();break;

            case "2":menu();break;

            default:print("Invalid Option...!\n...THANK YOU....");menu();
        } 
    }

    private static void updateDetails()
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
                ((Patient) Account.user).setName(Input.name());
                print("\nName Updated Successfully...");
                updateDetails();
                break;
            }

            case "3":
            {
                ((Patient) Account.user).setAge(Input.age());
                print("\nAge Updated Successfully...");
                updateDetails();
                break;
            }

            case "4":
            {
                ((Patient) Account.user).setSex(Input.sex());
                print("\nGender Updated Successfully...");
                updateDetails();
                break;
            }

            case "5":
            {
                ((Patient) Account.user).setBloodgroup(Input.bloodGroup());
                print("\nBlood Group Updated Successfully...");
                updateDetails();
                break;
            }

            case "6":
            {
                ((Patient) Account.user).setHeight(Input.height());
                print("\nHeight Updated Successfully...");
                updateDetails();
                break;
            }

            case "7":
            {
                ((Patient) Account.user).setWeight(Input.weight());
                print("\nWeight Updated Successfully...");
                updateDetails();
                break;
            }

            case "8":
            {
                ((Patient) Account.user).setPh_no(Input.ph_no());
                print("\nPhone Number Updated Successfully...");
                updateDetails();
                break;
            }

            case "9":
            {
                ((Patient) Account.user).setAllergyTo(Input.allergies());
                print("\nupdated Successfully....");
                updateDetails();
                break;
            }

            default : print("\nInvalid Option....!"); updateDetails();

        }
    }

    private static void changePassword(){
        print("\nEnter Your Current Password : ");
        if(((Patient) Account.user).getPassword().equals(Input.getFromUser())){
        print("\nEnter new Password :");
        String password=Input.password();
        print("\nRe-Type Your new Password :");
        if(password.equals(Input.getFromUser())){
            ((Patient) Account.user).changePassword(password);
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

    private static void bookAppointment(){
        
        LocalDate date=printDate();
        if(date==null){
        menu();
        }
        else{
        doctorAvailability(date);
        // print("\nEnter Patient ID : ");
        // String patientId=Input.getFromUser();
        // if(!Receptionist.receptionist.isPatientExists(patientId)){
        //    print("\nNo Patient Exists in that ID..");
        // }
        // else{
            print("\nEnter Doctor ID : ");
            String doctorId=Input.getFromUser();

            if(containsDoctorId(doctorId,date)){
                //  print("\nEnter Patient ID : ");
                //  String patientId=Input.getFromUser();

                    int slot=selectSlot(Utils.getDoctor(doctorId), date);

                    if(slot>=0){

                    ((Patient) Account.user).createAppointment(date,((Patient) Account.user).getId(), doctorId,slot);
                    print("\nAppointment created Successfully for patient Id :"+((Patient) Account.user).getId()+" on "+date);
                    }
                    else{
                    print("\nSorry Cannot Book Appointment retry...");
                    }
                }
            else{
                print("Please Enter correct Id..");
            }
            }
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

        ArrayList<Appointment> appointlist= ((Patient) Account.user).viewAppointment();
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
                ((Patient) Account.user).CancelAppointment(appointment.getDate(),appointment.getPatientId(),appointment.getTime(),appointment.getDoctorId());
                }

            }
        }
        

    }

    private static void viewReport()
    {
    
        ArrayList<Report> list=((Patient) Account.user).viewReports();
        
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

    private static  void printReport(Report report)
    {
        print("\n--------------- REPORT ---------------");
        print("\n\nReport ID          :"+report.getId());
        print("\nPatient Id          :"+report.getPatientId());
        print("\nGenerated By        :"+report.getGeneratedBy());
        print("\nDescription         :"+report.getdescription());
        print("\nTreatement Provided :"+report.getTreatementProvided());
        print("\nMedicine Prescribed :"+report.getMedicinePrescribed());
        Home.printLine();
    }


    private static void print(String value){
        System.out.println(value);
    }

}
