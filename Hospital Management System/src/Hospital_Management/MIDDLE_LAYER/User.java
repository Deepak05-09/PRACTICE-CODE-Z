package Hospital_Management.MIDDLE_LAYER;

interface User{
    Boolean login(String id,String password);
    Boolean logout();
    void changePassword(String password);
}