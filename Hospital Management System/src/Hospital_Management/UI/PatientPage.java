package Hospital_Management.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

//import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.MIDDLE_LAYER.Appointment;
import Hospital_Management.MIDDLE_LAYER.AppointmentList;
import Hospital_Management.MIDDLE_LAYER.Bill;
import Hospital_Management.MIDDLE_LAYER.Department;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.DoctorList;
import Hospital_Management.MIDDLE_LAYER.Login;

import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Report;
import Hospital_Management.MIDDLE_LAYER.Slot;


public class PatientPage  {
    
    private String id;
    private Patient user;
    
    public PatientPage(String id,Patient patient){
        this.id=id;
        user=patient;
    }

    enum disease{

        COLD(Department.PATHOLOGIST), STOMACH_PAIN(Department.PATHOLOGIST),DIARRHOEA(Department.PATHOLOGIST),
        FEVER(Department.PATHOLOGIST),PNEUMONIA(Department.PATHOLOGIST),TUBERCULOSIS(Department.PATHOLOGIST),
         HEART_PROBLEMS(Department.CARDIOLOGIST),CHEST_PAIN(Department.CARDIOLOGIST)
        , DENTAL(Department.DENTIST), HEADACHE(Department.NEUROLOGIST), BRAIN(Department.NEUROLOGIST),
         NERVES(Department.NEUROLOGIST), SPINE(Department.NEUROLOGIST);

      private Department department; 
      disease(Department name){
        department=name;
      }
      public Department getDepartment() {
          return department;
      }
    }

    public void menu(){
        HomePage.printLine();
        print("\n1.VIEW PROFILE\n2.CHANGE PASSWORD\n3.BOOK APPOINTMENT\n4.CANCEL APPOINTMENT\n"+
        "5.VIEW REPORT\n6.VIEW BILL\n7.VIEW HISTORY\n8.GIVE REVIEW\n9.LOGOUT");
        HomePage.printLine();
        
        System.out.println("\nENTER YOUR CHOICE :");
        switch( input.getFromUser()){
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
            case "6":{
                ViewBill();
                menu();
                break;
            }
            case "7":{
                viewHistory();
                menu();
                break;
            }

            case "8":{
                giveReview();
                menu();
                break;
            }
            
            case "9" :{
            user=null;
                print("\n......LOGGED OUT.....");
                HomePage homePage=new HomePage();
                homePage.menu();
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

        switch( input.getFromUser())
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

        switch( input.getFromUser())
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
                user.setName( input.name());
                print("\nName Updated Successfully...");
                updateDetails();
                break;
            }

            case "3":
            {
                user.setAge( input.age());
                print("\nAge Updated Successfully...");
                updateDetails();
                break;
            }

            case "4":
            {
                user.setSex( input.sex());
                print("\nGender Updated Successfully...");
                updateDetails();
                break;
            }

            case "5":
            {
                user.setBloodgroup( input.bloodGroup());
                print("\nBlood Group Updated Successfully...");
                updateDetails();
                break;
            }

            case "6":
            {
                user.setHeight( input.height());
                print("\nHeight Updated Successfully...");
                updateDetails();
                break;
            }

            case "7":
            {
                user.setWeight( input.weight());
                print("\nWeight Updated Successfully...");
                updateDetails();
                break;
            }

            case "8":
            {
                user.setPh_no( input.ph_no());
                print("\nPhone Number Updated Successfully...");
                updateDetails();
                break;
            }

            case "9":
            {
                user.setAllergyTo( input.allergies());
                print("\nupdated Successfully....");
                updateDetails();
                break;
            }

            default : print("\nInvalid Option....!"); updateDetails();

        }
    }

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

    private void bookAppointment(){
        System.out.println("\nSELECT \n1. DOCTOR\n2. DEPARTMENT\n3. DISEASE");

        switch( input.getFromUser()){

            case "1" :{
            bookByDoctor();
            break;
            }
            case "2":{
            bookByDepartment();
            break;
            }
            case "3":{
            bookByDisease();
            break;
            }

            default :{
                System.out.println("\nInvalid  input");
            }
        }
    }

    private void bookByDoctor(){
        Doctor doc= selectDoctor();
        if(doc!=null){
            //LocalDate date=printDate(doc.getSpeciality());
            ArrayList<LocalDate> dates=doctorList.DocAvailDatePatient(doc);
            if(!dates.isEmpty()){
                for(int i=0;i<dates.size();i++){
                    System.out.println((i+1)+". "+dates.get(i));
                }
                System.out.println("\nSELECT ABOVE DATE :");
                String choice= input.getFromUser();
                
                LocalDate date=null;
                if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)<=dates.size()&&Integer.parseInt(choice)>0){
                    date=dates.get(Integer.parseInt(choice)-1);
                }
            

            if(date!=null){
                int slot=selectSlot(doc, date);
                if(slot>=0){
                    appointmentList.createAppointment(date,user.getName(), user.getPh_no(),doc.getId(),slot);
                    print("\nAppointment created Successfully on "+date+" with doctor "+doc.getName());
                }
                else{
                    System.out.println("Slot= "+slot);
                }
            }
            else{
            System.out.println("\nInvalid  input");
            }
        }
        else{
            System.out.println("\nSORRY...!!! \n DOCTOR WILL NOT AVAILABLE FOR 7 DAYS");
        }
    }
    }

    private void bookByDepartment(){
        
        Department department=selectDepartment();

        if(department!=null){
          selectDateAndBook(department);
        }
        else{
            print("\nInvalid  input.");
        }
    
    }

    private void bookByDisease() {

        Department department=selectDisese();
        if(department!=null){

            selectDateAndBook(department);
          }
          else{
              print("\nInvalid  input.");
          }

    }

    private void selectDateAndBook(Department department){
        LocalDate date=printDate(department);

        if(date!=null){

            doctorAvailability(date,department);
            print("\nEnter Doctor ID : ");
            String doctorId= input.getFromUser();

                if(containsDoctorId(doctorId,date,department)){

                int slot=selectSlot(doctorList.get(doctorId), date);

                    if(slot>=0){
                        
                        appointmentList.createAppointment(date,user.getName(), user.getPh_no(),doctorId,slot);
                        print("\nAppointment created Successfully on "+date+" with doctor "+doctorList.get(doctorId).getName());
                    }
                    else{
                        print("\nSorry Cannot Book Appointment retry...");
                    }
                }
                }
    }

    private Department selectDisese(){
        disease []names=disease.values();
        print("\n");
        for(int i=0;i<names.length;i++){
            print(i+1+". "+names[i]);
        }
        print("\nSELECT YOUR PROBLEM");

        String choice= input.getFromUser();
        
        if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)!=0&&Integer.parseInt(choice)<=names.length){
        return names[Integer.parseInt(choice)-1].getDepartment();
        }
        else{
            System.out.println("\nInvalid Choice");
        }
        return null;
    }

    private Department selectDepartment(){
        print("\nSELECT DEPARTMENT ");

        for(int i=0;i<Department.values().length;i++){
        print("\n"+(i+1)+". "+Department.values()[i]);
        }

        String choice= input.getFromUser();
        
        if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)!=0&&Integer.parseInt(choice)<=Department.values().length){
        return Department.values()[Integer.parseInt(choice)-1];
        }
        else{
            System.out.println("\nInvalid Choice");
        }
        return null;
    }

    private boolean containsDoctorId(String id,LocalDate date,Department department){
        ArrayList<Doctor> list=doctorList.get(date,department);
        for(Doctor doctor:list){
        
        if(doctor.getId().equals(id)){
        return true;
        }
        }
        return false;
    }



    private void doctorAvailability(LocalDate date,Department department)
    {
        ArrayList<Doctor> list=doctorList.get(date,department);

        if(!list.isEmpty()&&list!=null)
        {
            print("\nAvailable Doctor(s) is/are\n");

            for(Doctor doctor:list)
            {
            print("ID: "+doctor.getId()+"   Name : "+doctor.getName()+"   Experience :"+doctor.getExperience()+"-Years");
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
        
        if(doctorList.get(LocalDate.now().plusDays(i),department).size()!=0){
        flag=true;
        print((i+1)+". "+LocalDate.now().plusDays(i)+" "+LocalDate.now().plusDays(i).getDayOfWeek());
        }
        
        }
        
        if(!flag){
        print("\nSorry No Doctors will be available for 7 days on "+department);

        }
        else{

        print("\nSelect the Above Date to Book Appointments \n");

        switch( input.getFromUser()){

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
    Slot[] arr=doctor.ViewAppointment(date);
    
    boolean flag=false;
    print("\nAvailable Slots Are/is :");
        for(int i=0;i<arr.length;i++){
        if(arr[i].appointment==null){
        flag=true;
            System.out.println("Slot no :"+(i+1)+" Start Time : "+arr[i].startTime+" End Time : "+arr[i].endTime);
        }
        }
        if(!flag){
        print("\nSorry..! Currently No Slots Are Available For This Doctor");
        return -1;
        }
        else{
        print("\nEnter Slot Number :");
        String slot= input.getFromUser();
        if(  validate.onlyNumber(slot)&&Integer.parseInt(slot)>0&&Integer.parseInt(slot)<=arr.length&&arr[Integer.parseInt(slot)-1].appointment==null){
            return Integer.parseInt(slot)-1;
        }
        else{
            print("\nEnter Valid Slot Number");
            return -1;
        }
        }
        
        
    }

    private void cancelAppointment(){
        print("\n---------------  CANCEL APPOINTMENT -------------------");

        ArrayList<Appointment> appointlist= appointmentList.viewAppointment(user.getName());
        if(appointlist==null||appointlist.isEmpty()){
            print("\nNO APPOINTMENTS FOUND ");
        }
        else{

            for(int i=0;i<appointlist.size();i++){
                print("\n"+(i+1)+" Name :"+doctorList.get(appointlist.get(i).getDoctorId()).getName()+" Doctor ID : "+appointlist.get(i).getDoctorId()+" Time : "+appointlist.get(i).getTime());
            }

            print("\nSELECT CHOICE TO CANCEL THAT APPOINTMENT");
            String choice= input.getFromUser();

            if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)-1<appointlist.size()&&Integer.parseInt(choice)>0){
                Appointment appointment=appointlist.get(Integer.parseInt(choice)-1);

                if( input.CancelAppointment()){
                    appointmentList.CancelAppointment(appointment.getDate(),appointment.getPatientName(),appointment.getTime(),appointment.getDoctorId());

                }

            }
        }
        

    }

    private Doctor selectDoctor(){
        
        System.out.println("\nEnter Doctor's Name to Book Appointment : ");
        String name= input.getFromUser();

        ArrayList<Doctor> doctors=doctorList.searchDoctor(name);

        if(doctors.isEmpty()){
            System.out.println("\nNO DOCTORS FOUND IN THAT NAME");
        }
        else{
            for(int i=0;i<doctors.size();i++){
                System.out.println((i+1)+". "+doctors.get(i).getName()+" ID : "+doctors.get(i).getId()+" Department : "+doctors.get(i).getSpeciality());
            }

            System.out.println("\nENTER YOUR CHOICE :");
            String choice= input.getFromUser();

            if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)<=doctors.size()&&Integer.parseInt(choice)>0){
                return doctors.get(Integer.parseInt(choice)-1);
            }
            else{
                System.out.println("\nInvalid  input");
            }
        }
        return null;

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
            String  in= input.getFromUser();
            if(  validate.onlyNumber( in))
            {
                if(Integer.parseInt( in)>0&&Integer.parseInt( in)<=list.size())
                {
                printReport(list.get(Integer.parseInt( in)-1));
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

    private void ViewBill(){
        System.out.println("\n1. VIEW ALL BILL\n2. VIEW PENDING \n\nOR \nPRESS ANY KEY TO EXIT");
        String choice= input.getFromUser();
        switch(choice){
            case "1":{
                allBills();
                break;
            }
            case "2":{
                viewPendingBill();
                break;
            }
            default:{
                System.out.println("\nTHANK YOU");
            }
        }

    }

    private void allBills(){
        ArrayList<Bill> bills=user.viewBill();
        
        if(bills.isEmpty()){
            System.out.println("\nNO BILL HISTORY AVAILABLE");
        }
        else{
            for(int i=0;i<bills.size();i++){
                Bill bill=bills.get(i);
                String s;

                if(bill.status==true){
                s="PAID";
                }
                else{
                    s="PENDING";
                }

                System.out.println((i+1)+". date : "+bill.date+" total amount : "+bill.total+" status : "+s);
            }
        }
    }

    private void viewPendingBill(){
        ArrayList<Bill> bills=user.viewBill();
        ArrayList<Bill> temp=new ArrayList<>();

        if(!bills.isEmpty()){
            for(Bill bill:bills){
                if(bill.status==false){
                    temp.add(bill);
                }
            }
        }
        if(!temp.isEmpty()){
            System.out.println("\nPENDING BILLS");
            for(int i=0;i<temp.size();i++){
                Bill b=temp.get(i);
                System.out.println((i+1)+". Date: "+b.date+" Total fees :"+b.total);
            }
            String choice= input.getFromUser();

            if(  validate.onlyNumber(choice)&&Integer.parseInt(choice)<=temp.size()&&Integer.parseInt(choice)>0){
            Bill bill=temp.get(Integer.parseInt(choice)-1);
            viewBill(bill);
            
            }
            else{
                System.out.println("\nInvalid  input");
            }
        }
        else{
            System.out.println("\nHurray....!!!\n\nNO PENDING BILLS TO PAY");
        }


    }

    private void viewBill(Bill bill){
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
        payBill(bill);
    }

    private void payBill(Bill bill){
        System.out.println("\nPRESS ANY KEY TO EXIT \n1.PAY BILL ");
        String  in= input.getFromUser();
        if( in.equals("1")){
            payementMode(bill);
        }
        else{
            System.out.println("\nThank You...");
        }
    }

    private void payementMode(Bill bill){
        System.out.println("\nCHOOSE YOUR PAYEMENT TYPE\n1. NET BANKING\n2. GPAY\n3. CARD\n4. EXIT");
        String  in= input.getFromUser();
        if( in.equals("1")|| in.equals("2")|| in.equals("3")){
            bill.status=true;
            System.out.println("\nPAYEMENT SUCCESSFULL\nTHANK YOU");
        }

    }

    private void viewHistory(){
        ArrayList<Appointment> appointlist= appointmentList.viewAppointment(user.getName());

        if(!appointlist.isEmpty()){
            for(Appointment appointment:appointlist){
                String status;
                if(appointment.getStatus()){
                  status="completed";
                }
                else{
                    status="Incompleted";
                }

                print("Date        :"+appointment.getDate()+
                    "\nTime        :"+appointment.getTime()+
                    "\nDoctor Id   :"+appointment.getDoctorId()+
                    "\nDoctor Name :"+doctorList.get(appointment.getDoctorId()).getName()+
                    "\nDepartment  :"+doctorList.get(appointment.getDoctorId()).getSpeciality()+
                    "\nStatus      :"+status+
                    "\n\n");
            }
        }
        else{
            print("\nNO HISTORY AVAILABLE");
        }
    }

    private void giveReview(){
        ArrayList<Appointment> appointlist= appointmentList.viewAppointment(user.getName());
        
        if(!appointlist.isEmpty()){

            Set<Doctor> temp=new LinkedHashSet<>();

            for(Appointment appointment: appointlist){
                if(appointment.getStatus()){
                    temp.add(doctorList.get(appointment.getDoctorId()));
                }
            }

            ArrayList<Doctor> doctors=new ArrayList<>(temp);
            for(int i=0;i<doctors.size();i++){
                Doctor doctor=doctors.get(i);
                System.out.println("\n"+(i+1)+". Name : "+doctor.getName()+"  Department :"+doctor.getSpeciality());
            }

            System.out.println("\nSELECT ABOVE DOCTOR TO GIVE REVIEW ABOUT THEM :");
            String choice=input.getFromUser();
            if( validate.onlyNumber(choice)&&Integer.parseInt(choice)<=doctors.size()&&Integer.parseInt(choice)>0){
                Doctor doctor=doctors.get(Integer.parseInt(choice)-1);
                 createReview(doctor);
                }
        }
        else{
            System.out.println("\nConsult Doctors to Give Review");
        }




    }

    private void createReview(Doctor doctor){
          
           String name=revieweeName();
           int rating=ratings();
           if(rating!=-1){
           System.out.println("\nGIVE YOUR PROS ABOUT THE DOCTOR :");
           String pros=input.getFromUser();
           System.out.println("\nGIVE YOUR CONS ABOUT THE DOCTOR :");
           String cons=input.getFromUser();
           System.out.println("\nENTER YOUR EXPERIENCE WITH THE DOCTOR :");
           String experience=input.getFromUser();

           user.giveReview(doctor.getId(),doctor.getName(),name,LocalDateTime.now(), rating,pros,cons,experience);
           System.out.println("\nREVIEW GIVEN SUCCESSFULLY");
           }
           else{
            System.out.println("\nEXITED...");
           }

    }
    
    private String revieweeName(){
        System.out.println("\nDO YOU WANT TO GIVE REVIEW AS ANONYMOUS ?\n1.YES \n2.NO");
        if(input.getFromUser().equals("2")){
          return user.getName();
        }
        else{
         return "Anonymous";
        }
    }

    private int ratings(){
        System.out.println("\nGIVE YOUR RATINGS FOR THE DOCTOR \n1 2 3 4 5\n");
        String rating=input.getFromUser();
        if(validate.onlyNumber(rating)&&Integer.parseInt(rating)>0&&Integer.parseInt(rating)<=5){
            return Integer.parseInt(rating);
        }
        else{
            return -1;
        }
    }


    private void print(String value){
        System.out.println(value);
    }
    private AppointmentList appointmentList=new AppointmentList();
    private DoctorList doctorList=new DoctorList();
    private  Input input=new Input();
    private   Validate   validate=new Validate();
}
