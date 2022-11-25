package Hospital_Management.DATA_LAYER;

import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Patient;

public class PatientDAO {
     
    private  HashMap<String,Patient> patientList;

    public PatientDAO(){
        patientList=new HashMap<>();
        initialise();
    }

    public void add(Patient patient){
        patientList.put(patient.getId(), patient);
    }

    public  Patient getPatient(String id){
        if(patientList.containsKey(id)){
            return patientList.get(id);
        }
        return null;
    }

    public  void update(Patient patient){
        patientList.replace(patient.getId(), patient);
    }

    public boolean isExist(String id){
       return patientList.containsKey(id);
    }

    public Patient get(String name,String mbl_no){
        
        ArrayList<Patient> list=new ArrayList<>(patientList.values());
        if(list!=null){
            for(Patient patient:list){
                if(patient.getName().equals(name)&&patient.getPh_no().equals(mbl_no)){
                    return patient;
                }
            }
        }
        return null;
    }

    private void initialise(){
        patientList.put(Patient.patient1.getId(),Patient.patient1);
        patientList.put(Patient.patient2.getId(),Patient.patient2);
        patientList.put(Patient.patient3.getId(),Patient.patient3);
    }
}
