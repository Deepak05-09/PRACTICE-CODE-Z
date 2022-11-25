package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Department;
import Hospital_Management.MIDDLE_LAYER.Doctor;

public class DoctorDAO {
    
    private  HashMap<String,Doctor> doctorList;
    private HashMap<LocalDate,ArrayList<Doctor>> availableDoctors;

    DoctorDAO(){
        doctorList=new HashMap<>();
        availableDoctors=new HashMap<>();
        initialise();
        setAvailableDoctors();
    }

    public void add(Doctor doctor){
        doctorList.put(doctor.getId(), doctor);
    }

    public Doctor get(String id){
        return doctorList.get(id);
    }

    public boolean isExist(String id){
        return doctorList.containsKey(id);
    }

    public void remove(String id){
        doctorList.remove(id);
    }

    public HashMap<String, Doctor> getAll() {
        return doctorList;
    }

    public ArrayList<Doctor> getDoctor(String name){
        ArrayList<Doctor> list=new ArrayList<>(doctorList.values());
        ArrayList<Doctor> temp=new ArrayList<>();
        if(list!=null){
            for(Doctor doctor:list){
                if(doctor.getName().equalsIgnoreCase(name)){
                    temp.add(doctor);
                }
            }
        }
        return temp;
    }

    private void setAvailableDoctors() {
        
        ArrayList<Doctor> doctors=new ArrayList<>(doctorList.values());

        for(int i=0;i<=14;i++){
            availableDoctors.put(LocalDate.now().plusDays(i),doctors);
        }
    }

    public void setDoctorAvailability(LocalDate date,ArrayList<Doctor> doctor){
        availableDoctors.replace(date, doctor);
    }

    public ArrayList<Doctor> getAvailableDoctors(LocalDate date){
        return availableDoctors.get(date);
    }

    public ArrayList<Doctor> getAvailableDoctors(LocalDate date,Department department){
        
        ArrayList<Doctor> list=new ArrayList<>();

        for(Doctor doctor : availableDoctors.get(date)){
            if(doctor.getSpeciality()==department){
                list.add(doctor);
            }
        }
        return list;
    }



    private void initialise(){
        doctorList.put(Doctor.doc.getId(),Doctor.doc);
        doctorList.put(Doctor.doc2.getId(),Doctor.doc2);
        doctorList.put(Doctor.doc3.getId(),Doctor.doc3);
        doctorList.put(Doctor.doc4.getId(),Doctor.doc4);
        doctorList.put(Doctor.doc5.getId(),Doctor.doc5);
    }

}
