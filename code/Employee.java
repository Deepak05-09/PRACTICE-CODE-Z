class Attendance{
    static int totalpresent;
    public static String getAttendanceReport(){
        return "No.of.Employees present today is "+totalpresent;
    }
}

public class Employee {
    
     private void checkIn(){
        Attendance.totalpresent+=1;
    }
    
    public static void main(String[] args) {
      Employee e1=new Employee();
      Employee e2=new Employee();
      Employee e3=new Employee();
      Employee e4=new Employee();
      Employee e5=new Employee();
      Employee e6=new Employee();
      Employee e7=new Employee();
      Employee e8=new Employee();
      e1.checkIn();
      e2.checkIn();
      e3.checkIn();
      e4.checkIn();
      e5.checkIn();
      e6.checkIn();
      e7.checkIn();
      e8.checkIn();
     System.out.println(Attendance.getAttendanceReport());
    }
}