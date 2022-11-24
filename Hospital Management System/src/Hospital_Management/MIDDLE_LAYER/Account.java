package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;


public class Account
{
    public static  Object user;

    public Object user1;
    private String password;


    public Account(Object user){
      this.user1=user;
    }
    public Account(Object user,String password){
        user1=user;
        this.password=password;
    }

     public String getPassword() {
         return password;
     }

    public static void create(String id,String password,String name,int age,Sex sex,BloodGroup type,int height,int weight,String ph_no,String allergy)
    {   
        Patient p=new Patient(name, age, sex, type, weight, height, ph_no, allergy);
        p.changePassword(password);
        Account account=new Account(p,password);
        user=p;
        Storage.storage.store((Patient)user);
        Storage.storage.addUser(id,account);
    }

    public static void create(String id,String password,String patientId)
    {   
        Patient p=Storage.storage.getPatient(patientId);
        p.changePassword(password);
        Account account=new Account(p,password);
        user=p;
        Storage.storage.addUser(id,account);
    }
    
    public static void adminLogin(String id){
       user=Storage.storage.getUser(id).user1;
    }
   public static void doctorLogin(String id){
       user=Storage.storage.getUser(id).user1;
    }
    public static void cashierLogin(String id){
        user=Storage.storage.getUser(id).user1;
    }
    public static void receptionistLogin(String id){
        user=Storage.storage.getUser(id).user1;
    }
    public static void patientLogin(String id){
       user=Storage.storage.getUser(id).user1;
    }

   

  }
