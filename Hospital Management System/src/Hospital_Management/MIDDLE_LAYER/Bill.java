package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;

public class Bill
{   
    public String billId;
    public String patientId;
    public LocalDate billGeneratedOn;
    public double roomFees;
    public double ConsultantFees;
    public double MedicineFees;
    public String billGivenBy;
    public double total;
    
    static int id=1;
    int n01=(int)Math.random()*100;

    Bill(String patientId,double roomFees,double consultantFees,double medicineFees,String billGivenBy)
    {   
       billId=n01+""+id; 
       this.patientId=patientId;
       this.roomFees=roomFees;
       this.ConsultantFees=consultantFees;
       this.MedicineFees=medicineFees;
       this.billGivenBy=billGivenBy;
       billGeneratedOn=LocalDate.now();
       total=roomFees+consultantFees+medicineFees;
    }

    

}