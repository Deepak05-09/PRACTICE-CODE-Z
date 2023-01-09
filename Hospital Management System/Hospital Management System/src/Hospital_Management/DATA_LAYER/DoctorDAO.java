package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Department;
import Hospital_Management.MIDDLE_LAYER.Doctor;

public class DoctorDAO {
    
   
    

    public DoctorDAO(){

    }

    

    public void add(Doctor doctor){
        Storage.storage.doctorList.put(doctor.getId(), doctor);
    }

    public Collection<Doctor> values(){
        return Storage.storage.doctorList.values();
    }

    public Doctor get(String id){
        return Storage.storage.doctorList.get(id);
    }

    public ArrayList<Doctor> getAvailableDoctors(LocalDate date){
        return Storage.storage.availableDoctors.get(date);
    }

    public boolean isExist(String id){
        return Storage.storage.doctorList.containsKey(id);
    }

    public void remove(String id){
        Storage.storage.doctorList.remove(id);
    }

    public HashMap<String, Doctor> getAll() {
        return Storage.storage.doctorList;
    }

    public ArrayList<Doctor> getDoctor(String name){
        ArrayList<Doctor> list=new ArrayList<>(Storage.storage.doctorList.values());
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

   

    public void setDoctorAvailability(LocalDate date,ArrayList<Doctor> doctor){
        Storage.storage.availableDoctors.replace(date, doctor);
    }

    public Collection<ArrayList<Doctor>> getAvailableDoctors(){
       return Storage.storage.availableDoctors.values();
    }


    public ArrayList<Doctor> getAvailableDoctors(LocalDate date,Department department){
        ArrayList<Doctor> list=new ArrayList<>();

        for(Doctor doctor : Storage.storage.availableDoctors.get(date)){
            if(doctor.getSpeciality()==department){
                list.add(doctor);
            }
        }
        return list;
    }



   

}
