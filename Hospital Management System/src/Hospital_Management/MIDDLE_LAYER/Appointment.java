package Hospital_Management.MIDDLE_LAYER;

public class Appointment {
     
    private String patientId;
    private String doctorId;
    private String time;

    Appointment(String patientId,String doctorId,String time){
       this.patientId=patientId;
       this.doctorId=doctorId;
       this.time=time;
    }
}
