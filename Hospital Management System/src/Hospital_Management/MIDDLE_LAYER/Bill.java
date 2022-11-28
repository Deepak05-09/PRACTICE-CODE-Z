package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bill
{   
    public String billId;
    public String patientId;
    public LocalDate billGeneratedOn;
    public LocalTime time;
    public LocalDate date;
    public double roomFees;
    public double ConsultantFees;
    public double MedicineFees;
    public String billGivenBy;
    public double total;
    public boolean status=false;
    
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
       time=LocalTime.now();
       date=LocalDate.now();
       total=roomFees+consultantFees+medicineFees;
    }

    

}