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
    
            switch(role){
    
                case ADMIN :{
                    String Id=userDAO.getUser(id).getId();
                    AdminPage adminPage=new AdminPage();
                    adminPage.user=(Admin)Storage.storage.getEmployee(Id);
                    adminPage.adminFeatures();
                    break;
                }
                case DOCTOR :{
                    String Id=userDAO.getUser(id).getId();
                    DoctorPage doctorPage=new DoctorPage();
                    doctorPage.user=(Doctor)Storage.storage.getEmployee(Id);
                    doctorPage.doctorFeatures();
                    break;
                }
                case RECEPTIONIST :{
                    String Id=userDAO.getUser(id).getId();
                    ReceptionistPage receptionistPage=new ReceptionistPage();
                    receptionistPage.user=(Receptionist)Storage.storage.getEmployee(Id);
                    receptionistPage.receptionistFeatures();
                    break;
                }
                case CASHIER :{
                    String Id=userDAO.getUser(id).getId();
                    CashierPage cashierPage=new CashierPage();
                    cashierPage.user=(Cashier)Storage.storage.getEmployee(Id);
                    cashierPage.cashierFeatures();
                    break;
                }
                case PATIENT :{
                    String Id=userDAO.getUser(id).getId();
                    PatientPage patientPage=new PatientPage();
                    patientPage.user=patientDAO.getPatient(Id);
                    patientPage.menu();
                    break;
                }
                default :{
                    System.out.println("\nError Occured");
                }
    
        }
    }
    public void changePassword(){

    }

    public boolean isIdExist(String id){
        return userDAO.isUserExist(id);
    }

    public boolean isPasswordCorrect(String id,String password){
        return userDAO.getPassword(id).equals(password);
    }

    private UserDAO userDAO=UserDAO.userDAO;
    private PatientDAO patientDAO=PatientDAO.patientDAO;
}
