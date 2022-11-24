package Hospital_Management.MIDDLE_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;

import Hospital_Management.DATA_LAYER.Storage;

public class Patient
{
    private String name;
    private String id;
    private int age;
    private Sex sex;
    private BloodGroup Bloodgroup;
    private int weight;
    private int height;
    private String ph_no;
    private String allergyTo;
    private ArrayList<Report> report;
    private String password;
    
    static int p_id=1;
    
    Patient(String password){
       id="PT"+p_id++;
       this.password=password;
    }

    Patient(String name,int age,Sex sex,BloodGroup bloodGroup,int weight,int height,String ph_no,String allergy)
    {

        this.id="PT"+p_id++;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.Bloodgroup=bloodGroup;
        this.height=height;
        this.weight=weight;
        this.ph_no=ph_no;
        allergyTo=allergy;
        report=new ArrayList<>();
        password=ph_no;
    }
   
   

    public static Patient patient1=new Patient("Guhan", 23, Sex.MALE, BloodGroup.O_POSITIVE, 67, 167, "9999999999", "Nil");
    public static Patient patient2=new Patient("Naveen", 26, Sex.MALE, BloodGroup.B_POSITIVE, 61, 170, "9876543210", "peanut");
    public static Patient patient3=new Patient("Nagul", 50, Sex.MALE, BloodGroup.AB_POSITIVE, 80, 187, "8967532864", "Nil");
    

    
    /*-----------------SETTERS--------------------------*/
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public void setBloodgroup(BloodGroup bloodtype) {
        Bloodgroup = bloodtype;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
    public void setAllergyTo(String allergyTo) {
        this.allergyTo = allergyTo;
    }
    public void setReport(Report report) {
        this.report.add(report);
    }
    public void changePassword(String password) {
        this.password = password;
    }
    
    /*------------------GETTERS-------------------------*/
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public Sex getSex() {
        return sex;
    }
    public BloodGroup getBloodtype() {
        return Bloodgroup;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public String getPh_no() {
        return ph_no;
    }
    public String getAllergyTo() {
        return allergyTo;
    }
    public String getPassword() {
        return password;
    }
    /*-------------------------------------------*/

    public Patient viewProfile(){
        return this;
    }

    public void createAppointment(LocalDate date,String patientId,String doctorId,int time)
    {  
       Doctor doctor=Storage.storage.doctorList.get(doctorId);
       Appointment[]slot=doctor.appointments.get(date);
   
        Appointment appointment= new Appointment(patientId, doctorId, time,date);
       slot[time]=appointment;
       doctor.appointments.put(date, slot);
       Storage.storage.store(appointment);
    }

    public  void CancelAppointment(LocalDate date,String name,String time,String doctorId) {
        Storage.storage.CancelAppointment(date, name, time,doctorId);
      }

      public ArrayList<Appointment> viewAppointment(){
        return Storage.storage.getAppointment(id);
     }

      public ArrayList<Report> viewReports() {
        return this.report;
     }


}