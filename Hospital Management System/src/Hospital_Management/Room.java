package Hospital_Management;

import java.util.Date;

public class Room
{   
    private enum Floor{
        GROUND, FIRST, SECOND, THIRD;
    }

    private enum Name{
        CONSULTING, DAY ,DELIVERY, EMERGENCY, ICU, OPERATING_THEATRE, SICK, WARD;
    }

    private enum RoomType {
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
    private Boolean Availability;

    Room(Floor floor,int no,Name name,RoomType type){
      this.no=no;
      roomName=name;
      roomType=type;
      this.floor=floor;
    }
    public double getRoomCharge(RoomType roomtype){
        return roomtype.charge;
    }
    public void setPatientAdmitted(Room room,Patient patientAdmitted) {
        room.patientAdmitted = patientAdmitted;
    }
    public void setAdmitDate(Room room,Date admitDate) {
        room.admitDate = admitDate;
    }
    public void setAvailability(Boolean availability) {
        Availability = availability;
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
    public Boolean getAvailability() {
        return Availability;
    }
    
    public static void initialize(){
    Room G1=new Room(Floor.GROUND,1,Name.CONSULTING,RoomType.SINGLE_AC);
    Room G2=new Room(Floor.GROUND,1,Name.ICU,RoomType.SINGLE_AC);
    Room G3=new Room(Floor.GROUND,1,Name.DAY,RoomType.SINGLE_AC);
    Room F1=new Room(Floor.GROUND,1,Name.OPERATING_THEATRE,RoomType.SINGLE_AC);
    Room F2=new Room(Floor.GROUND,1,Name.SICK,RoomType.SINGLE_AC);
    Room F3=new Room(Floor.GROUND,1,Name.DELIVERY,RoomType.SINGLE_AC);
    Room S1=new Room(Floor.GROUND,1,Name.CONSULTING,RoomType.SINGLE_AC);
    Room S2=new Room(Floor.GROUND,1,Name.EMERGENCY,RoomType.SINGLE_AC);
    Room S3=new Room(Floor.GROUND,1,Name.CONSULTING,RoomType.SINGLE_AC);
    }
}