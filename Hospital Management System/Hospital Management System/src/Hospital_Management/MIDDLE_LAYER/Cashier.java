package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;

import Hospital_Management.DATA_LAYER.BillDAO;


public class Cashier extends Employee 
{   
    static int id=1;
    
    
    public Cashier(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,String password)
    {
        setName(name);
        setId("CA"+id++);
        setAge(age);
        setPhnNo(ph_no);
        setDateJoined(LocalDate.now());
        setDateOfBirth(dob);
        setSex(sex);
        setMail(mail);
        setAddress(address);
        setEducation(education);
        changePassword(password);
        setRole("Cashier");
    }
    
    public Cashier() 
    {

    }
    
    public Bill generateBill(String patientId,double roomFees,double consultantFees,double medicineFees)
    {   
        Bill bill=new Bill(patientId, roomFees, consultantFees, medicineFees,this.getName() );
        billDAO.add(LocalDate.now(), bill);
        return bill;
    }
    
    

    public String toString()
    {
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }

    private BillDAO billDAO=new BillDAO();
}