package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;




public class Appointment {
     
    private String patientName;
    private String Pmbl_no;
    private String doctorId;
    private String time;
    private LocalDate date;
    private Boolean status;
    
    
    public Appointment(String patientName,String mbl_no,String doctorId,String time,LocalDate date){
       this.patientName=patientName;
       this.doctorId=doctorId;
       this.time=time;
       this.date=date;
       Pmbl_no=mbl_no;
       status=true;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPmbl_no() {
        return Pmbl_no;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString(){
        return "Patient Name: "+patientName+" Patient number :"+Pmbl_no+" Time"+time+" Doctor Id :"+doctorId;
    }

   
}
