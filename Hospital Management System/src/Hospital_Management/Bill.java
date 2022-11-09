package Hospital_Management;

import java.time.LocalDate;

public class Bill
{
    private String billId;
    private String patientId;
    private LocalDate billGeneratedOn;
    private double roomFees;
    private double ConsultantFees;
    private double MedicineFees;
    private String billGivenBy;
    
    Bill(String patientId,double roomFees,double consultantFees,double medicineFees,String billGivenBy){
       this.patientId=patientId;
       this.roomFees=roomFees;
       this.ConsultantFees=consultantFees;
       this.MedicineFees=medicineFees;
       this.billGivenBy=billGivenBy;
       billGeneratedOn=LocalDate.now();
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public void setBillGeneratedOn(LocalDate billGeneratedOn) {
        this.billGeneratedOn = billGeneratedOn;
    }
    public void setRoomFees(double roomFees) {
        this.roomFees = roomFees;
    }
    public void setConsultantFees(double consultantFees) {
        ConsultantFees = consultantFees;
    }public void setMedicineFees(double medicineFees) {
        MedicineFees = medicineFees;
    }
    public void setBillGivenBy(Cashier billGivenBy) {
        this.billGivenBy = billGivenBy.getName();
    }

}