import java.util.Scanner;

 class EmployeeDetails{
    private String employeeId;
    private String employeeName;
    private String dateOfBirth;
    private String email;
    private String mobileNo;

//console colour code
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_RED = "\u001B[31m";
    final static String ANSI_YELLOW = "\u001B[33m";

//Scanner
    Scanner sc=new Scanner(System.in);

//setter called in default constructor
     EmployeeDetails(){
        setEmployeeId();
        setEmployeeName();
        setdateOfBirth();
        setemail();
        setmobileNo();
    } 

    
//setter id
    public void setEmployeeId(){
        System.out.println("Enter employee Id :");
       String Id=sc.nextLine();
       //To find  input is numerical or not 
       try{
        Integer.parseInt(Id);
        this.employeeId=Id;
       }
       catch(Exception e){
        System.out.println(ANSI_RED+"Enter valid ID !"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"Only in Numbers"+ANSI_RESET);
        setEmployeeId();
       }
       
    }

//setter Name
    public void setEmployeeName(){
        System.out.println("Enter employee Name :");
        this.employeeName=sc.nextLine();
       
    }

//setter DOB
    public void setdateOfBirth(){
        System.out.println("Enter employee Date of Birth :");
        this.dateOfBirth=sc.nextLine();
       
    }

//setter mail
    public void setemail(){
        System.out.println("Enter email id :");
        this.email=sc.nextLine();
       
    }

//setter Mobile no
    public void setmobileNo(){
        System.out.println("Enter mobile number :");
        String No=sc.nextLine();
        //To  check if only numbers are entered
        try{
             Integer.parseInt(No);
             
                if(No.length()<10){
                    System.out.println(ANSI_RED+"ONLY "+ANSI_YELLOW+No.length()+ANSI_RED+" NUMBER IS ENTERED"+ANSI_RESET);
                    setmobileNo();
                }
                if(No.length()>10){
                    System.out.println(ANSI_RED+"MORE NUMBERS ARE ENTERED"+ANSI_RESET);
                    setmobileNo();
                }
                 if(No.length()==10){
                    this.mobileNo=No;
                }
           }
           catch(Exception e){
            System.out.println(ANSI_RED+"Enter valid Number"+ANSI_RESET);
            setmobileNo();
           }
       
    }

//GETTERS START -------------------
    public String getemployeeId(){
        return employeeId;
    }
    public String getemployeeName(){
        return employeeName;
    }
    public String getdateOfBirth(){
        return dateOfBirth;
    }
    public String getemail(){
        return email;
    }
    public String getmobileNo(){
        return mobileNo;
    }
//GETTERS END ----------------------

}
 

public class encapsulation {

    public static void main(String[] args){
      EmployeeDetails emp1=new EmployeeDetails();
      
     System.out.println(emp1.getmobileNo());
    }
}
