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
    
    Bill(String patientId,double roomFees,double consultantFees,double medicineFees,String billGivenBy){
       this.patientId=patientId;
       this.roomFees=roomFees;
       this.ConsultantFees=consultantFees;
       this.MedicineFees=medicineFees;
       this.billGivenBy=billGivenBy;
       billGeneratedOn=LocalDate.now();
    }

    

}