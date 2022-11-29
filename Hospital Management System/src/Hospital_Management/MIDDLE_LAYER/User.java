package Hospital_Management.MIDDLE_LAYER;


import Hospital_Management.DATA_LAYER.UserDAO;

public class User
{
   private String username;
   private String password;
   private String id;
   private Role role;

    enum Role {

    ADMIN, DOCTOR, RECEPTIONIST, CASHIER, PATIENT;
   }
   
   public User(Admin admin){
    username=admin.getMail();
    password=admin.getPassword();
    id=admin.getId();
    role=Role.ADMIN;
   }

   public User(Doctor doctor){
    username=doctor.getMail();
    password=doctor.getPassword();
    id=doctor.getId();
    role=Role.DOCTOR;
   }

   public User(Receptionist receptionist){
    username=receptionist.getMail();
    password=receptionist.getPassword();
    id=receptionist.getId();
    role=Role.RECEPTIONIST;
   }

   public User(Cashier cashier){
    username=cashier.getMail();
    password=cashier.getPassword();
    id=cashier.getId();
    role=Role.CASHIER;
   }

    public User(String mail,String password,Patient patient){
    username=mail;
    this.password=password;
    id=patient.getId();
    role=Role.PATIENT;
   }
   
   public void setPassword(String password) {
       this.password = password;
   }

   public String getUsername() {
       return username;
   }

   public String getId() {
       return id;
   }

   public String getPassword() {
       return password;
   }

   public Role getRole() {
       return role;
   }

   public  void changePassword(String username,String password){
       userDAO.changePassword(username,password);
   }
    
   private UserDAO userDAO=new UserDAO();

   
}