package Hospital_Management.UI;

import java.util.Date;
import java.util.Scanner;

import Hospital_Management.MIDDLE_LAYER.BloodGroup;
import Hospital_Management.MIDDLE_LAYER.Sex;


public class Input {
    
      static Scanner scanner = new Scanner(System.in);
    public static String name(){
        print("\nEnter Name :\t");
        String name=getFromUser();
        if(Validate.name(name)){
            return name;
        }
         else{
            print("\n\u001b[31mInValid Name...!\u001b[0m");
         }
        return name();
    }
    public static String employeeId(){
        print("\nEnter employee ID :\n");
       return Input.getFromUser();
    }
    public static String password(){
        print("\nPassword must contains at least 8 characters and at most 20 characters");
        print("\nMust contains at least one digit");
        print("\nMust contains at least one upper case alphabet and lower case alphabet");
        print("\n Must contains at least one special character which includes !@#$%&*()-+=^");
        print("\nPassword should not contain any white space\n\nENTER PASSWORD: ");
        String password=getFromUser();
        if(Validate.password(password)){
            return password;
        }
        else{
            print("\n\u001b[31mInValid Password.....!\u001b[0m");
         }
        return password();
    }
    public static String ph_no(){
        print("\nEnter Phone Number :");
        String ph_no=getFromUser();
        if(Validate.ph_no(ph_no)){
            return ph_no;
        }
        if(!Validate.ph_no(ph_no)){
            print("\n\u001b[31mInValid Phone Number....!\u001b[0m");
        }
        return ph_no();
    }
    public static Date dateOfBirth(){
        print("\nEnter Date Of Birth :");
        Date date=new Date();
        return date;
    }
    public static Date DateJoined(){
        print("\nEnter Date Of Joining :");
        Date date=new Date();
        return date;
    }
    public  static int employeeAge(){
        print("\nEnter Age :");
        String age=getFromUser();
        if(Validate.employeeAge(age)){
            return Integer.parseInt(age);
        }
       else{
            print("\n\u001b[31mInValid Age...!\nEMPLOYEE AGE SHOULD BE BETWEEN 22 AND 60 \u001b[0m");
        }
        return age();
    }
    public  static int age(){
        print("\nEnter Age :");
        String age=getFromUser();
        if(Validate.patientAge(age)){
            return Integer.parseInt(age);
        }
        else{
            print("\n\u001b[31mInValid Age...!\u001b[0m");
        }
        return age();
    }
    public static Sex sex(){
        print("\nSelect Sex :");
        for(Sex sex: Sex.values()){
            print(sex.value()+". "+sex.toString());}
            switch(getFromUser()){
                case "1":return Sex.MALE;
                case "2":return Sex.FEMALE;
                case "3":return Sex.TRANSGENDER;
                default: {
                          print("Enter valid Option....");
                          sex();
                         }
            }
        
        return Sex.MALE;
    }
    public static String mail(){
        print("\nEnter Mail Id :");
        String mail=getFromUser();
        if(Validate.email(mail)){
            return mail;
        }
        else{
            print("\n\u001b[31mInValid Mail ID...!\u001b[0m");
        }
        return mail();
    }
    public static String address(){
        print("\nEnter Address :");
        String address=getFromUser();
        return address;
    }
    public static String  education(){
        print("\nEnter Education Details :");
        String edu=getFromUser();
        return edu;
    }
    public static String speciality(){
        print("\nEnter Doctor's Speciality :");
        String speciality=getFromUser();
        if(Validate.onlyString(speciality)){
            return speciality;
        }
        else{
            print("\n\u001b[31mInValid Input...!\u001b[0m");
        }
        return speciality();
    }
    public static String patientId(){
        print("\nEnter Patient's Id :");
        return getFromUser();
    }
    public static String doctorId(){
        print("\nEnter Doctor's's Id to book appoinment:");
        return getFromUser();
    }
    public static String time(){
        print("Enter Time to book appointment");
        return getFromUser();
    }
    public static double roomFees(){
        print("\nEnter Room Fees :");
        String fees=getFromUser();
        if(Validate.onlyNumber(fees)){
            return Double.parseDouble(fees);
        }
        else{
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }
        return roomFees();
    }
    public static double consultantFees(){
        print("\nEnter Consultant Fees :");
        String fees=getFromUser();
        if(Validate.onlyNumber(fees)){
            return Double.parseDouble(fees);
        }
        else{
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }
         return consultantFees();
    }
    public static double medicineFees(){
        print("\nEnter Medicine Fees :");
        String fees=getFromUser();
        if(Validate.onlyNumber(fees)){
            return Double.parseDouble(fees);
        }
        else{
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }
        return medicineFees();
    }
    public static BloodGroup bloodGroup(){
        print("\nSelect Blood Group :");
        for(BloodGroup bloodGroup:BloodGroup.values()){
            print(bloodGroup.value()+". "+bloodGroup);
        }
        switch(getFromUser()){
            case "1":return BloodGroup.O_POSITIVE;
            case "2":return BloodGroup.A_POSITIVE;
            case "3":return BloodGroup.B_POSITIVE;
            case "4":return BloodGroup.AB_POSITIVE;
            case "5":return BloodGroup.O_NEGATIVE;
            case "6":return BloodGroup.A_NEGATIVE;
            case "7":return BloodGroup.B_NEGATIVE;
            case "8":return BloodGroup.AB_NEGATIVE;
            default: {
                print("Invalid option....!");
                bloodGroup();
            }
        }
        return BloodGroup.O_POSITIVE;
    }
    public static int height(){
        print("\nEnter Height :");
        String height=getFromUser();
        if(Validate.onlyNumber(height)){
            return Integer.parseInt(height);
        }
        else{
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }
        return height();
    }
    public static int weight(){
        print("\nEnter weight :");
        String weight=getFromUser();
        if(Validate.onlyNumber(weight)){
            return Integer.parseInt(weight);
        }
        else{
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
        }
        return weight();
       
    }
    public static String allergies(){
        print("\nEnter Allergies :");
        return getFromUser();
    }
    public static String reason(){
        print("\nEnter Reason :");
        return getFromUser();
    }
    public static String treatementNeeded(){
        print("\nEnter Treatment(s) Needed :");
        return getFromUser();
    }
    public static String treatementProvided(){
        print("\nEnter Treatment(s) Provided :");
        return getFromUser();
    }
    public static Boolean needRoom(){
        print("\nDoes Patient Need To Admit ?\nPRESS\n1--->YES\n2--->NO");
        switch(getFromUser()){
            case "1": return true;
            case "2": return false;
            default: print("\u001b[31mInValid Choice...!\u001b[0m");needRoom();
        }
        return false;
    }
    public static Boolean confirmation(){
        print ("\nplease confirm to Save\nPRESS\n1--->YES\n2--->NO");
        switch(getFromUser()){
            case "1": print("SUCCESSFULLY SAVED"); return true;
            case "2": return false;
            default: print("\u001b[31mInValid Choice...!\u001b[0m");
        }
        return confirmation();
    }

    public  static void print(String string){
        System.out.println(string);
    }

    public static String getFromUser(){
            return scanner.nextLine();
    }
    
    
}
