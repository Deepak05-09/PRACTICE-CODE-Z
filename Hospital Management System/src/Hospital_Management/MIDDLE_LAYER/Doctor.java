package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.DATA_LAYER.DoctorDAO;
import Hospital_Management.DATA_LAYER.PatientDAO;


public class Doctor extends Employee 
{
   
    private Department speciality;
    private int experience;
    private HashMap<LocalDate,Slot[]> appointments;
    private ArrayList<Review> reviews;
    private int slot=5;
   
    
    static int id=1;
    
   
    public Doctor(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,Department speciality,String password,int experience)
    {
        setName(name);
        setId("DR"+id++);
        setAge(age);
        setPhnNo(ph_no);
        setDateJoined(LocalDate.now());
        setDateOfBirth(dob);
        setSex(sex);
        setMail(mail);
        setAddress(address);
        setEducation(education);
        setSpeciality(speciality);
        changePassword(password);
        this.experience=experience;
        setRole("Doctor");
        appointments=new HashMap<>();
        reviews=new ArrayList<>();
    }



    public void setSpeciality(Department speciality){
        this.speciality=speciality;
    }
   
    public Department getSpeciality(){
        return speciality;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getSlot() {
        return slot;
    }

    public int getExperience() {
        return experience;
    }
    
    public void setAppointments(LocalDate date, Slot[] slot) {
       appointments.put(date, slot);
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public ArrayList<Review> viewReviews(){
        return reviews;
    }

    public void changeAvailability(LocalDate date){
       
        ArrayList<Doctor> list=new ArrayList<>();
        ArrayList<Doctor> doctors=doctorDAO.getAvailableDoctors(date);

        if(doctors.contains(this)){
            for(Doctor doctor :doctors){
                if(!doctor.equals(this)){
                    list.add(doctor);
                }
            }
        } 
        else{
            list=doctors;
            list.add(this);
        } 
        doctorDAO.setDoctorAvailability(date, list);
        }
        

    public void generatReport(String patientId,String description,String treatementProvided,String medicine)
    {   
        if(doctorDAO.isExist(patientId))
        {   
            Patient patient=patientDAO.getPatient(patientId);;
            patient.setReport(new Report(patientId, description, treatementProvided, medicine,this.getName()));
        }

    }

    public ArrayList<Report> viewPatientReport(String patientId)
    {
        if(doctorDAO.isExist(patientId))
        {   
            Patient patient=patientDAO.getPatient(patientId);
            return patient.viewReports();
        }
        return null;
    }

    public Doctor viewProfile()
    {
        return this;
    }

    public void changeSlot(LocalDate date,int noOfSlot){
        Slot slot[]= new Slot[noOfSlot];
        for(int i=0;i<slot.length;i++){
            slot[i]=new Slot();
        }
        appointments.put(date, slot);
    }
    
    public  Slot[] ViewAppointment( LocalDate date){
        Slot[] arr=appointments.get(date);
        if(arr==null){
            appointments.put(date, defaultSlot());
        }
        else{
            return arr;
        }
        return ViewAppointment(date);
        
    }

    
    public HashMap<LocalDate,Slot[]> viewAppointments(){
        return appointments;
    }

    public void setSlotTime(LocalDate date,int index,String startTime,String endTime){
        Slot[] slot= appointments.get(date);
        slot[index].startTime=startTime;
        slot[index].endTime=endTime;
    }

    private Slot[] defaultSlot(){
          Slot[] arr=new Slot[5];
          String Time[]={"9:00Am-9:25Am","9:30Am-9:55Am","10:00Am-10:25Am","02:00Pm-02:25Pm","02:30Pm-02:55Am"};
          for(int i=0;i<arr.length;i++){
            String t[]=Time[i].split("-");
            arr[i]=new Slot();
             arr[i].startTime=t[0];
             arr[i].endTime=t[1];
          }
          return arr;
    }
    
   
    public String toString(){
       
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }
    


    private DoctorDAO doctorDAO=new DoctorDAO();
    private PatientDAO patientDAO=new PatientDAO();
}