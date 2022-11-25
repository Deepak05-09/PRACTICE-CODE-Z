package Hospital_Management.UI;

import java.time.LocalDate;
import java.util.Scanner;

import Hospital_Management.MIDDLE_LAYER.BloodGroup;
import Hospital_Management.MIDDLE_LAYER.Department;
import Hospital_Management.MIDDLE_LAYER.Sex;


public class Input {
    
    static Scanner scanner = new Scanner(System.in);

    public static String name()
    {
        print("\nEnter Name :\t");

        String name=getFromUser();

        if(Validate.name(name))
        {
            return name;
        }
        else
        {
            print("\n\u001b[31mInValid Name...!\u001b[0m");
        }

        return name();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String employeeId()
    {
        print("\nEnter employee ID :\n");

       return Input.getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String password()
    {
        print("\nPassword must contains at least 8 characters and at most 20 characters");
        print("\nMust contains at least one digit");
        print("\nMust contains at least one upper case alphabet and lower case alphabet");
        print("\nMust contains at least one special character which includes !@#$%&*()-+=^");
        print("\nPassword should not contain any white space\n\nENTER PASSWORD: ");

        String password=getFromUser();

        if(Validate.password(password))
        {
            return password;
        }
        else{
            print("\n\u001b[31mInValid Password.....!\u001b[0m");
        }

        return password();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String ph_no()
    {
        print("\nEnter Phone Number :");

        String ph_no=getFromUser();

        if(Validate.ph_no(ph_no))
        {
            return ph_no;
        }
        else
        {
            print("\n\u001b[31mInValid Phone Number....!\u001b[0m");
        }

        return ph_no();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static LocalDate dateOfBirth()
    {
        print("\nEnter Date Of Birth :");
        
        return LocalDate.of(year(), month(), date());
    }

//---------------------------------------------------------------------------------------------------------------------------------------//

    public static LocalDate DateJoined()
    {
        print("\nEnter Date Of Joining :");
        LocalDate.now();
        LocalDate date=LocalDate.of(year(), month(), date());

        return date;
    }

    public static int date(){

        print("\nEnter date : ");
        String date=Input.getFromUser();

        if(Validate.onlyNumber(date)){
            if(Integer.parseInt(date)<=31&&Integer.parseInt(date)>0){
                return Integer.parseInt(date);
            }
            else{
                print("\nEnter valid date");
            }
          
        }
        else{
            print("\nInput invalid");
        }
        return date();
    }
     
    public static int month(){

        print("Enter Month : ");
        String month=Input.getFromUser();

        if(Validate.onlyNumber(month)){
            if(Integer.parseInt(month)<=31&&Integer.parseInt(month)>0){
                return Integer.parseInt(month);
            }
            else{
                print("\nEnter valid Month");
            }
        }
        else{
            print("\nInput invalid");
        }
        return month();
    }

    public static int year(){

        print("Enter Year : ");
        String year=Input.getFromUser();

        if(Validate.onlyNumber(year)){
            if(Integer.parseInt(year)<=9999&&Integer.parseInt(year)>0){
                return Integer.parseInt(year);
            }
            else{
                print("\nEnter valid year");
            }
        }
        else{
            print("\nInput invali");
        }
        return year();
    }

//---------------------------------------------------------------------------------------------------------------------------------------//

    public  static int employeeAge()
    {
        print("\nEnter Age :");

        String age=getFromUser();

        if(Validate.employeeAge(age))
        {
            return Integer.parseInt(age);
        }
        else
        {
            print("\n\u001b[31mInValid Age...!\nEMPLOYEE AGE SHOULD BE BETWEEN 22 AND 60 \u001b[0m");
        }

        return age();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  static int age()
    {
        print("\nEnter Age :");

        String age=getFromUser();

        if(Validate.patientAge(age))
        {
            return Integer.parseInt(age);
        }
        else
        {
            print("\n\u001b[31mInValid Age...!\u001b[0m");
        }

        return age();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static Sex sex()
    {
        print("\nSelect Sex :");

        for(Sex sex: Sex.values())
        {
            print(sex.value()+". "+sex.toString());
        }

            switch(getFromUser())
            {
                case "1":return Sex.MALE;

                case "2":return Sex.FEMALE;

                case "3":return Sex.TRANSGENDER;

                default: 
                {
                    print("Enter valid Option....");
                }
            }
        
        return sex();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String mail()
    {
        print("\nEnter Mail Id :");

        String mail=getFromUser();

        if(Validate.email(mail))
        {
            return mail;
        }
        else
        {
            print("\n\u001b[31mInValid Mail ID...!\u001b[0m");
        }

        return mail();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String address()
    {
        print("\n----Enter Address---");
        String address=doorNo()+", "+addressLine1()+", "+city()+", "+state()+", "+country()+" Zip code : "+postCode();
        return address;
    }
//---------------------------------------------------------------------------------------------------------------------------------------//
    
    private static String doorNo(){
        print("\nEnter door no :");
       return getFromUser();
    }
    private static String addressLine1(){
        print("\nEnter Address First Line :");
        return getFromUser();
    }
    private static String city(){
        print("\nEnter City : ");
        return getFromUser();
    }
    private static String state(){
        print("\nEnter state : ");
        return getFromUser();
    }
    private static String country(){
        print("\nEnter Country : ");
        return getFromUser();
    }
    private static String postCode(){
        print("\nEnter Zip Code :");
        String code=getFromUser();
        if(Validate.onlyNumber(code)&&code.length()==6){
            return code;
        }
        else{
            print("Enter Valid Zip Code");
        }
        return postCode();
    }




//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String  education()
    {
        print("\nEnter Education Details :");
        String edu=getFromUser();

        return edu;
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static Department speciality()
    {
        print("\nChoose Doctor's Speciality ");
        for(int i=0;i<Department.values().length;i++){
            print("\n"+(i+1)+". "+Department.values()[i]);
        }
        String speciality=getFromUser();

        if(Validate.onlyNumber(speciality)&&Integer.parseInt(speciality)!=0&&Integer.parseInt(speciality)<=Department.values().length)
        {
            return Department.values()[Integer.parseInt(speciality)-1];
        }
        else
        {
            print("\n\u001b[31mInValid Input...!\u001b[0m");
        }

        return speciality();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String patientId()
    {
        print("\nEnter Patient's Id :");

        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String doctorId()
    {
        print("\nEnter Doctor's's Id to book appoinment:");

        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//
    public static String prescribe()
    {
        print("Prescribe Medicine(s) :");
        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String time()
    {
        print("Enter Time to book appointment");

        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static double roomFees()
    {
        print("\nEnter Room Fees :");
        String fees=getFromUser();

        if(Validate.onlyNumber(fees))
        {
            return Double.parseDouble(fees);
        }
        else
        {
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }

        return roomFees();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static double consultantFees()
    {
        print("\nEnter Consultant Fees :");
        String fees=getFromUser();

        if(Validate.onlyNumber(fees))
        {
            return Double.parseDouble(fees);
        }
        else{
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }

        return consultantFees();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static double medicineFees()
    {
        print("\nEnter Medicine Fees :");
        String fees=getFromUser();

        if(Validate.onlyNumber(fees))
        {
            return Double.parseDouble(fees);
        }
        else
        {
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }

        return medicineFees();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static BloodGroup bloodGroup()
    {
        print("\nSelect Blood Group :");

        for(BloodGroup bloodGroup:BloodGroup.values())
        {
            print(bloodGroup.value()+". "+bloodGroup);
        }

        switch(getFromUser())
        {
            case "1":return BloodGroup.O_POSITIVE;

            case "2":return BloodGroup.A_POSITIVE;

            case "3":return BloodGroup.B_POSITIVE;

            case "4":return BloodGroup.AB_POSITIVE;

            case "5":return BloodGroup.O_NEGATIVE;

            case "6":return BloodGroup.A_NEGATIVE;

            case "7":return BloodGroup.B_NEGATIVE;

            case "8":return BloodGroup.AB_NEGATIVE;

            default: 
            {
                print("Invalid option....!");
            }

        }

        return bloodGroup();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static int height()
    {
        print("\nEnter Height :");
        String height=getFromUser();

        try{
            int n=Integer.parseInt(height);
            return n;
        }
        catch(Exception exception){
            print("\nInvalid Input");
        }

        return height();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static int weight()
    {
        print("\nEnter weight :");
        String weight=getFromUser();

        try{
            int n=Integer.parseInt(weight);
            return n;
        }
        catch(Exception exception){
            print("\nInvalid Input");
        }

        return weight();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String allergies()
    {
        print("\nEnter Allergies :");
        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String reason()
    {
        print("\nEnter Reason :");
        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String treatementNeeded()
    {
        print("\nEnter Treatment(s) Needed :");
        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String treatementProvided()
    {
        print("\nEnter Treatment(s) Provided :");
        return getFromUser();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static Boolean needRoom()
    {
        print("\nDoes Patient Need To Admit ?\nPRESS\n1--->YES\n2--->NO");

        switch(getFromUser())
        {
            case "1": return true;

            case "2": return false;

            default: print("\u001b[31mInValid Choice...!\u001b[0m");needRoom();

        }

        return false;
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static Boolean confirmation()
    {
        print ("\nplease confirm to Save\nPRESS\n1--->YES\n2--->NO");

        switch(getFromUser())
        {
            case "1": print("SUCCESSFULLY SAVED"); return true;

            case "2": return false;

            default: print("\u001b[31mInValid Choice...!\u001b[0m");

        }

        return confirmation();
    }

    public static Boolean CancelAppointment()
    {
        print ("\nplease confirm Cancel Appointment\nPRESS\n1--->YES\n2--->NO");

        switch(getFromUser())
        {
            case "1": print("APPOINTMENT CANCELLED SUCCESSFULLY"); return true;

            case "2": return false;

            default: print("\u001b[31mInValid Choice...!\u001b[0m");

        }

        return CancelAppointment();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  static void print(String string)
    {
        System.out.println(string);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public static String getFromUser(){
            return scanner.nextLine();
    }
//---------------------------------------------------------------------------------------------------------------------------------------//
  
    
}
