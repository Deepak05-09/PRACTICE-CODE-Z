package Hospital_Management.UI;

import java.util.ArrayList;

import Hospital_Management.MIDDLE_LAYER.Admin;
import Hospital_Management.MIDDLE_LAYER.Employee;
import Hospital_Management.MIDDLE_LAYER.Room;

public class AdminPage {
   
        static void adminFeatures(){
          
          Home.employeefeatures();
        print("5. ADD ADMIN\n6. ADD DOCTOR\n7. ADD RECEPTIONIST\n8. ADD CASHIER\n9. REMOVE EMPLOYEE\n10. VIEW ROOM STATUS\n11.SEARCH EMPLOYEE\n12.VIEW ALL EMPLOYEE\n");
        choice();
        switch(Input.getFromUser()){
              case "1":{
                        print("\n......THANK YOU.....");Home.menu(); break;
                       } 
             case "2":{
                        checkIn();
                        adminFeatures();
                      }break;
             case "3":{
                        checkOut();
                        adminFeatures();
                         break;
                      }
             case "4":{
                         print(Admin.admin.toString()); 
                         adminFeatures();
                         break;
                      }
              case "5":{
                        Admin.admin.createNewAdmin(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                        adminFeatures();
                       }break;
             case  "6":{
                        Admin.admin.addDoctor(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.speciality(),Input.password()); 
                       adminFeatures();
                       }break;
             case  "7":{
                         Admin.admin.addReceptionist(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                         adminFeatures();
                        }break;
             case  "8":{
                         Admin.admin.addCashier(Input.name(),Input.ph_no(),Input.dateOfBirth(),Input.employeeAge(),Input.sex(),Input.mail(),Input.address(),Input.education(),Input.password());
                         adminFeatures();
                        }break;
             case  "9":{
                         print(Admin.admin.viewAll());
                         print("\nENTER EMPLOYEE ID TO REMOVE");
                         print(Admin.admin.removeEmployee(Input.getFromUser()));
                         adminFeatures();
                        }break;
             case  "10":{
                ArrayList<Room> list=Admin.admin.roomStatus();
                         if(!list.isEmpty()){
                         for(Room room:list){
                            Input.print(room.toString());
                         } }
                         else{
                            print("\nNo Rooms");
                         }
                         adminFeatures();
                        }break;
             case  "11":{
                         search();
                         adminFeatures();
                        }break;
             case "12":{
                        Input.print(Admin.admin.viewAll());adminFeatures();break;
                       }
            
             default :  {
                         print("\nInvalid choice......!");
                         adminFeatures();
                        }
        }
       }

       private static void checkIn(){
         if(Admin.admin.checkIn()){
            print("\nSuccessfully Checked In\n");}
            else{
               print("\nYOU HAVE ALREADY CHECKED IN\n");
            }
          }
       
       private static void checkOut(){
         if(Admin.admin.checkOut()){
            print("\nSuccessfully Checked Out");
            }
            else{
               print("\nplease Check In to Check Out");
            }
       }

       private static void search(){
         print("\nENTER EMPLOYEE ID TO SEARCH : \n");
            Employee employee= Admin.admin.viewEmployee(Input.getFromUser());
            if(employee==null){
              print("\nNo Employee Available In that ID");
            }
            else{
               print(employee.toString());
            }
       }

       private static void print(String string){
        System.out.println(string);
       }
       private static void choice(){
        print("\nEnter Your Choice :\n");
       }
       private static void save(){
        print("\nSuccessfully saved.....");
       }
}
