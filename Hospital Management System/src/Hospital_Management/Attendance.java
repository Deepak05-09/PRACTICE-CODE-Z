package Hospital_Management;

import java.time.LocalDate;
import java.time.LocalTime;


public class Attendance {
    String user_id;
    LocalDate date;
    LocalTime checkIn;
    LocalTime checkOut;
    
    Attendance(String id,LocalDate date,LocalTime checkIn){
        user_id=id;
        this.checkIn=checkIn;
    }
}
