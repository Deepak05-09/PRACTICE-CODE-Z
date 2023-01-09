package Hospital_Management.DATA_LAYER;

import java.util.ArrayList;

import Hospital_Management.MIDDLE_LAYER.Patient;

public class PatientDAO {
     
    

    public PatientDAO(){
        
       
    }

    
    public void add(Patient patient){
        Storage.storage.patientList.put(patient.getId(), patient);
    }

    public  Patient getPatient(String id){
        if(Storage.storage.patientList.containsKey(id)){
            return Storage.storage.patientList.get(id);
        }
        return null;
    }

    public  void update(Patient patient){
        Storage.storage.patientList.replace(patient.getId(), patient);
    }

    public boolean isExist(String id){
       return Storage.storage.patientList.containsKey(id);
    }

    public ArrayList<Patient> get(String search){
        
        ArrayList<Patient> list=new ArrayList<>(Storage.storage.patientList.values());
        ArrayList<Patient> temp=new ArrayList<>();
        if(list!=null){
            for(Patient patient:list){
                if(patient.getName().toLowerCase().contains(search.toLowerCase())||patient.getId().toLowerCase().contains(search.toLowerCase())||patient.getPh_no().toLowerCase().equals(search.toLowerCase())){
                    temp.add(patient);
                }
            }
        }
        return temp;
    }

    
}
