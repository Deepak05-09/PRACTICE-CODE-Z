package Hospital_Management.DATA_LAYER;

import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Admin;
import Hospital_Management.MIDDLE_LAYER.Cashier;
import Hospital_Management.MIDDLE_LAYER.Doctor;
import Hospital_Management.MIDDLE_LAYER.Patient;
import Hospital_Management.MIDDLE_LAYER.Receptionist;
import Hospital_Management.MIDDLE_LAYER.User;

public class UserDAO {
    
    private HashMap<String,User> userDetails;

     UserDAO(){
        userDetails=new HashMap<>();
        initialise();
    }

    public void add(User user){
        userDetails.put(user.getUsername(), user);
    }

    public User getUser(String id){
        return userDetails.get(id);
    }

    public boolean isUserExist(String id){
        return userDetails.containsKey(id);
    }

    public String getPassword(String id){
        return userDetails.get(id).getPassword();
    }

    public void remove(String id){
        userDetails.remove(id);
    }

    private void initialise(){
       add(new User(Doctor.doc));
       add(new User(Doctor.doc2));
       add(new User(Doctor.doc3));
       add(new User(Doctor.doc4));
       add(new User(Doctor.doc5));
       add(new User(Admin.mainAdmin));
       add(new User(Receptionist.rec));
       add(new User(Cashier.cashier2));
       add(new User("123","Patient123",Patient.patient1));
    }
   
   
}
