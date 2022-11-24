package Hospital_Management.MIDDLE_LAYER;

import java.util.Date;


public class Room
{   
    public static enum Floor{
        GROUND, FIRST, SECOND, THIRD;
    }

    public static enum Name{
        CONSULTING, DAY ,DELIVERY, EMERGENCY, ICU, OPERATING_THEATRE, SICK, WARD;
    }

    public static  enum RoomType {
        GENERAL(1000), SINGLE_NON_AC(2000) ,SINGLE_AC(3000), DELUXE_NON_AC(4000), DELUXE_AC(5000), SUITE(7000);
        
        private final double charge;
        
        RoomType(double charge){
            this.charge=charge;
        }
    
    }

    private int no;
    private Name roomName;
    private Floor floor;
    private RoomType roomType;
    private Patient patientAdmitted;
    private Date admitDate;
    private String availability;

    public Room(Floor floor,int no,Name name,RoomType type){
      this.no=no;
      roomName=name;
      roomType=type;
      this.floor=floor;
      availability="Available";
    }
    
    public double getRoomCharge(RoomType roomtype){
        return roomtype.charge;
    }
    public void setPatientAdmitted(Patient patientAdmitted) {
       this.patientAdmitted = patientAdmitted;
    }
    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getNo() {
        return no;
    }
    public Name getRoomName() {
        return roomName;
    }
    public Floor getFloor() {
        return floor;
    }
    public RoomType getType() {
        return roomType;
    }
    public Patient getPatientAdmitted() {
        return patientAdmitted;
    }
    public Date getAdmitDate(Room room) {
        return admitDate;
    }
    public String getAvailability() {
        return availability;
    }
    public String toString(){
        return "Floor :"+floor+" Room No: "+no+" Room Name :"+roomName+" Availability :"+availability;
    }
    
    
}