package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.PatientDAO;
import Hospital_Management.DATA_LAYER.Storage;
import Hospital_Management.DATA_LAYER.UserDAO;
import Hospital_Management.MIDDLE_LAYER.User.Role;
import Hospital_Management.UI.AdminPage;
import Hospital_Management.UI.CashierPage;
import Hospital_Management.UI.DoctorPage;
import Hospital_Management.UI.PatientPage;
import Hospital_Management.UI.ReceptionistPage;

public class Login {
    
    public void login(String id){
        
        Role role=userDAO.getUser(id).getRole();
        String Id=userDAO.getUser(id).getId();
        
        switch(role){

            case ADMIN : new AdminPage(id, (Admin)Storage.storage.getEmployee(Id)).adminFeatures(); break;
            
            case DOCTOR : new DoctorPage(id, (Doctor)Storage.storage.getEmployee(Id)).doctorFeatures(); break;
            
            case RECEPTIONIST : new ReceptionistPage(id, (Receptionist)Storage.storage.getEmployee(Id)).receptionistFeatures(); break;
            
            case CASHIER : new CashierPage(id, (Cashier)Storage.storage.getEmployee(Id)).cashierFeatures(); break;
            
            case PATIENT : new PatientPage(id,patientDAO.getPatient(Id)).menu(); break;
            
            default :  System.out.println("\nError Occured");
            
        }
    }
    
    public void changePassword(String username,String password){
        userDAO.changePassword(username, password);
    }

    public boolean isIdExist(String id){
        return userDAO.isUserExist(id);
    }

    public boolean isPasswordCorrect(String id,String password){
        return userDAO.getPassword(id).equals(password);
    }

    private UserDAO userDAO=new UserDAO();
    private PatientDAO patientDAO=new PatientDAO();
}
