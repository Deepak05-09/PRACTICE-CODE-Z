package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;



public class Appointment {
     
    private String patientId;
    private String doctorId;
    private String time;
    //private String status;
    private LocalDate date;
    public static final String slot[]={"9:00Am-9:25Am","9:30Am-9:55Am","10:00Am-10:25Am","02:00Pm-02:25Pm","02:30Pm-02:55Am"};
    public enum Slot{
        slot1("9:00Am-9:25Am"), slot2("9:30Am-9:55Am"), slot3("10:00Am-10:25Am"), slot4("02:00Pm-02:25Pm"), slot5("02:30Pm-02:55Am");
        
        private String time;
        Slot(String time){
           this.time=time;
        }
        public String getTime() {
            return time;
        }
    }
    
    Appointment(String patientId,String doctorId,int time,LocalDate date){
       this.patientId=patientId;
       this.doctorId=doctorId;
       this.time=slot[time];
       this.date=date;
    }
    // public void setStatus(String status) {
    //     this.status = status;
    // }
    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getTime() {
        return time;
    }

    // public String getStatus() {
    //     return status;
    // }
    public LocalDate getDate() {
        return date;
    }

    public String toString(){
        return "Patient id: "+patientId+" Time"+time+" Doctor Id :"+doctorId;
    }
}
