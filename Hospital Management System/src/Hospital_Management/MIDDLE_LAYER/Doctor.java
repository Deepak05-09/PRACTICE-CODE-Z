package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.DATA_LAYER.DoctorDAO;
import Hospital_Management.DATA_LAYER.PatientDAO;


public class Doctor extends Employee 
{
   
    private Department speciality;
   
    public HashMap<LocalDate,Appointment[]> appointments;
    

    static int id=1;
    
   
    public Doctor(String name,String ph_no,LocalDate dob,int age,Sex sex,String mail,String address,String education,Department speciality,String password)
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
        setRole("Doctor");
        //Availability=true;
        appointments=new HashMap<>();
    }



    public void setSpeciality(Department speciality){
        this.speciality=speciality;
    }
   
    public Department getSpeciality(){
        return speciality;
    }

    public void setNonAvailable(LocalDate date){
       
        ArrayList<Doctor> list=new ArrayList<>();
        
            for(Doctor doctor :doctorDAO.getAvailableDoctors(date)){
                if(!doctor.equals(this)){
                    list.add(doctor);
                }
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
    
    public  Appointment[] ViewAppointment( LocalDate date){
        Appointment[] arr=this.appointments.get(date);
        if(arr==null){
            this.appointments.put(date, new Appointment[5]);
        }
        else{
            return arr;
        }
        return ViewAppointment(date);
    }

    
      public HashMap<LocalDate,Appointment[]> viewAppointments(){
         return appointments;
      }
    
   
    public String toString(){
       
        return "Name :"+getName()+"  ID: "+getId()+" Role :"+getRole()+"\n";
    }
    


    private DoctorDAO doctorDAO=DoctorDAO.doctorDAO;
    private PatientDAO patientDAO=PatientDAO.patientDAO;
}