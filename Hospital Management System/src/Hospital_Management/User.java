package Hospital_Management;

interface User{
    Boolean login(String id,String password);
    Boolean logout();
    void changePassword(String password);
}