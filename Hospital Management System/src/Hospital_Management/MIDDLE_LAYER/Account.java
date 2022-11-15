package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;

public class Account {
    private String id;
    private String password;

    public Account(String id,String password){
      this.id=id;
      this.password=password;
    }

    public static void create(String id,String password){
       Account account=new Account(id,password);
       Storage.storage.addUser(account.id,account.password);
    }

    public static void login(String id){
      
        if(id.contains("AD")){
        Admin.admin=(Admin) Storage.storage.getEmployee(id);
        }
        if(id.contains("DR")){
        Doctor.doctor=(Doctor) Storage.storage.getEmployee(id);
        }
        if(id.contains("RE")){
        Receptionist.receptionist=(Receptionist) Storage.storage.getEmployee(id);
        }
        if(id.contains("CA")){
        Cashier.cashier=(Cashier) Storage.storage.getEmployee(id);
        }
    }
    public static boolean isUserExist(String id){
        return Storage.storage.existsUser(id);
    }

    public static boolean isPasswordCorrect(String id,String password){
        return Storage.storage.userDetails.get(id).equals(password);
    }

   

}
