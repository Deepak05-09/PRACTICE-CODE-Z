package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;

public class Register {
    
    public  void create(String id,String password,String name,int age,Sex sex,BloodGroup type,int height,int weight,String ph_no,String allergy)
    {   
        Patient patient=new Patient(name, age, sex, type, weight, height, ph_no, allergy);
        Storage.patientList.add(patient);
        Storage.userDetails.add(new User(id,password,patient));
    }

    public  void create(String id,String password,String patientId)
    {   
        Patient patient=Storage.patientList.getPatient(patientId);
        Storage.userDetails.add(new User(id,password,patient));
    }

    public boolean isIdExist(String id){
        return Storage.userDetails.isUserExist(id);
    }
}
