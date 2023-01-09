package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.PatientDAO;
import Hospital_Management.DATA_LAYER.UserDAO;

public class Register {
    
    public  void create(String id,String password,String name,int age,Sex sex,BloodGroup type,int height,int weight,String ph_no,String allergy)
    {   
        Patient patient=new Patient(name, age, sex, type, weight, height, ph_no, allergy);
        patientDAO.add(patient);
        userDAO.add(new User(id,password,patient));
    }

    public  void create(String id,String password,String patientId)
    {   
        Patient patient=patientDAO.getPatient(patientId);
        userDAO.add(new User(id,password,patient));
    }

    public boolean isIdExist(String id){
        return userDAO.isUserExist(id);
    }

    public boolean isIdConnectedToAcc(String id){
        return userDAO.isIdConnected(id);
    }

    private UserDAO userDAO=new UserDAO();
    private PatientDAO patientDAO=new PatientDAO();

}
