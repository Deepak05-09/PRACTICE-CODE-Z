package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.time.LocalTime;


public class Attendance {
   public String user_id;
   public LocalDate date;
   public LocalTime checkIn;
   public LocalTime checkOut;
    
    public Attendance(String id,LocalDate date,LocalTime checkIn){
        user_id=id;
        this.checkIn=checkIn;
    }
}
