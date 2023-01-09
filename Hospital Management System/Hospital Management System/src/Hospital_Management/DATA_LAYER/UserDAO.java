package Hospital_Management.DATA_LAYER;

import java.util.ArrayList;



import Hospital_Management.MIDDLE_LAYER.User;

public class UserDAO {
    
   

    public UserDAO(){
        
        
    }
   

    public void add(User user){
        Storage.storage.userDetails.put(user.getUsername(), user);
    }

    public User getUser(String id){
        return Storage.storage.userDetails.get(id);
    }

    public boolean isUserExist(String id){
        return Storage.storage.userDetails.containsKey(id);
    }

    public String getPassword(String id){
        return Storage.storage.userDetails.get(id).getPassword();
    }

    public void remove(String id){
        Storage.storage.userDetails.remove(id);
    }

    public void changePassword(String username,String password){
       User user=Storage.storage.userDetails.get(username);
        user.setPassword(password);
        Storage.storage.userDetails.replace(username,user);
    }

    public boolean isIdConnected(String patientId){
          ArrayList<User> list=new ArrayList<>(Storage.storage.userDetails.values());
          for(User user:list){
            if(user.getId().equals(patientId)){
                return true;
            }
          }
         return false; 
    }

   
   
   
}
