package Hospital_Management.MIDDLE_LAYER;


import java.time.LocalDate;
import java.util.ArrayList;


import Hospital_Management.DATA_LAYER.DoctorDAO;

public class DoctorList {
    

     public  Doctor get(String doctorId){
        return doctorDAO.get(doctorId);
     }
     
     public  ArrayList<Doctor> get(LocalDate date,Department department){
      ArrayList<Doctor> list=new ArrayList<>();

      for(Doctor doctor : doctorDAO.getAvailableDoctors(date)){
          if(doctor.getSpeciality()==department){
              list.add(doctor);
          }
      }
      return list;
     }
     
     public  ArrayList<Doctor> searchDoctor(String name){

      ArrayList<Doctor> list=new ArrayList<>(doctorDAO.values());
      ArrayList<Doctor> temp=new ArrayList<>();

      if(list!=null){
          for(Doctor doctor:list){
              if(doctor.getName().toLowerCase().contains(name.toLowerCase())){
                  temp.add(doctor);
              }
          }
      }
      return temp;
    }

    public  ArrayList<LocalDate> DocAvailDatePatient(Doctor doc){
        
      ArrayList<LocalDate> list=new ArrayList<>();
       for(int i=0;i<7;i++){
          ArrayList<Doctor> doctors= doctorDAO.getAvailableDoctors(LocalDate.now().plusDays(i));
          if(doctors.contains(doc)){
             list.add(LocalDate.now().plusDays(i));
          }
       }
       return list;
    }

    public  ArrayList<LocalDate> DocAvailDateDoctor(Doctor doc){
        
      ArrayList<LocalDate> list=new ArrayList<>();
       for(int i=7;i<14;i++){
          ArrayList<Doctor> doctors= doctorDAO.getAvailableDoctors(LocalDate.now().plusDays(i));
          if(doctors.contains(doc)){
             list.add(LocalDate.now().plusDays(i));
          }
       }
       return list;
    }

    public void addReview(Review review){
      get(review.getDocId()).addReview(review);
    }


    
    private  DoctorDAO doctorDAO=new DoctorDAO();
}
