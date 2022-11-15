package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.Date;

import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.UI.Input;

public class Cashier extends Employee implements User
{   
    static int id=2;
    public static Cashier cashier;
    
    Cashier(String name,String id,String ph_no,Date dob,int age,Sex sex,String mail,String address,String education,String password){
        setName(name);
        setId(id);
        setAge(age);
        setPhnNo(ph_no);
        setDateJoined(LocalDate.now());
        setDateOfBirth(dob);
        setSex(sex);
        setMail(mail);
        setAddress(address);
        setEducation(education);
        setPassword(password);
        setRole("Cashier");
    }
    public static Cashier cashier2=new Cashier("Cashier", "CA1", "6666666666", null, 34, Sex.FEMALE, "cashier@123", "addressbndnbd", "B.com", "Cashier123");
    
    public Cashier() {
    }
    

    
    
    @Override
    public  Boolean login(String id,String password) {
       if(Storage.storage.existsUser(id)){
          if(password.equals(getPassword())){
              return true;
          }
        }
      return false;
    }

    @Override
    public  Boolean logout() {
       return true;
    }

    @Override
    public void changePassword(String password) {
        this.setPassword(password);
        
    }
    
    public Bill generateBill(){
        return new Bill(Input.patientId(),Input.roomFees(),Input.consultantFees(),Input.medicineFees(),this.getName());
    }
    public String toString(){
        return " NAME: "+this.getName()+" ID: "+this.getId()+" ROLE: "+this.getRole()+" AGE: "+this.getAge()+" MAIL: "+this.getMail()+" EDUCATION :"+this.getEducation()+" DATE JOINED :"+this.getDateJoined()+" SEX: "+this.getSex()+" PASSWORD: "+this.getPassword();
    }
}