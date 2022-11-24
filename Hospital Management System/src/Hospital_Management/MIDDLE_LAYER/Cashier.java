package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;


import Hospital_Management.DATA_LAYER.Storage;


public class Cashier extends Employee implements User
{   
    static int id=2;
    
    
    Cashier(String name,String id,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
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
    
    public Cashier() 
    {

    }
    

    
    
    @Override
    public  Boolean login(String id,String password) 
    {
       if(Storage.storage.existsUser(id))
       {
            if(password.equals(getPassword()))
            {
                return true;
            }
        }
      return false;
    }

    @Override
    public  Boolean logout()
    {
       return true;
    }

    @Override
    public void changePassword(String password)
    {
        this.setPassword(password);
    }
    
    public Bill generateBill(String patientId,double roomFees,double consultantFees,double medicineFees)
    {   
        
        return new Bill(patientId, roomFees, consultantFees, medicineFees,this.getName() );
    }
    
    public boolean isPatientExists(String id)
    {
       return Storage.storage.isPatientExists(id);
    }

    public String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }
}