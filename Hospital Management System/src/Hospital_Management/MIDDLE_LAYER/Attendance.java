package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;


public class Attendance {
   public String user_id;
   public LocalDate date;
   public long checkIn;
   public long checkOut;
   public boolean active;
    
    public Attendance(String id,LocalDate date,long checkIn)
    {
        user_id=id;
        this.checkIn=checkIn;
        active=true;
    }
}
