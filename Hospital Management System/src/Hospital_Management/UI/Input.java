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
         if(!Validate.name(name)){
            print("\n\u001b[31mInValid Name...!\u001b[0m");
            name();
         }
        return name;
    }
    public static String employeeId(){
        print("\nEnter employee ID :\n");
       return Input.getFromUser();
    }
    public static String password(){
        print("\nEnter Password :\t");
        String password=getFromUser();
        if(!Validate.password(password)){
            print("\n\u001b[31mInValid Password.....!\u001b[0m");
            password();
         }
        return password;
    }
    public static String ph_no(){
        print("\nEnter Phone Number :");
        String ph_no=getFromUser();
        if(!Validate.ph_no(ph_no)){
            print("\n\u001b[31mInValid Phone Number....!\u001b[0m");
            ph_no();
        }
        return ph_no;
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
    public  static int age(){
        print("\nEnter Age :");
        String age=getFromUser();
        if(!Validate.EmployeeAge(age)){
            print("\n\u001b[31mInValid Age...!\u001b[0m");
            age();
        }
        return Integer.parseInt(age);
    }
    public static Sex sex(){
        print("\nSelect Sex :");
        for(Sex sex: Sex.values()){
            print(sex.toString());
        }
        return Sex.MALE;
    }
    public static String mail(){
        print("\nEnter Mail Id :");
        String mail=getFromUser();
        if(!Validate.email(mail)){
            print("\n\u001b[31mInValid Mail ID...!\u001b[0m");
            mail();
        }
        return mail;
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
        if(!Validate.onlyString(speciality)){
            print("\n\u001b[31mInValid Input...!\u001b[0m");
            speciality();
        }
        return speciality;
    }
    public static String patientId(){
        print("\nEnter Patient's Id :");
        return getFromUser();
    }
    public static double roomFees(){
        print("\nEnter Room Fees :");
        String fees=getFromUser();
        if(!Validate.onlyNumber(fees)){
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
            roomFees();
        }
        return Double.parseDouble(fees);
    }
    public static double consultantFees(){
        print("\nEnter Consultant Fees :");
        String fees=getFromUser();
        if(!Validate.onlyNumber(fees)){
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
            consultantFees();
        }
        return Double.parseDouble(fees);
    }
    public static double medicineFees(){
        print("\nEnter Medicine Fees :");
        String fees=getFromUser();
        if(!Validate.onlyNumber(fees)){
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
            medicineFees();
        }
        return Double.parseDouble(fees);
    }
    public static BloodGroup bloodGroup(){
        print("\nSelect Blood Group :");
        return BloodGroup.O_POSITIVE;
    }
    public static int height(){
        print("\nEnter Height :");
        String height=getFromUser();
        if(!Validate.onlyNumber(height)){
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
            height();
        }
        return Integer.parseInt(height);
    }
    public static int weight(){
        print("\nEnter weight :");
        String weight=getFromUser();
        if(!Validate.onlyNumber(weight)){
            print("\n\u001b[31mInValid Input...!\nONLY NUMBERS ARE ALLOWED\u001b[0m");
            weight();
        }
        return Integer.parseInt(weight);
       
    }
    public static void allergies(){
        print("\nEnter Allergies :");
    }
    public static void reason(){
        print("\nEnter Reason :");
    }
    public static void treatementNeeded(){
        print("\nEnter Treatment(s) Needed :");
    }
    public static void treatementProvided(){
        print("\nEnter Treatment(s) Provided :");
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
    public static void confirmation(){
        
    }

    public  static void print(String string){
        System.out.println(string);
    }

    public static String getFromUser(){
            return scanner.nextLine();
    }
    
}
