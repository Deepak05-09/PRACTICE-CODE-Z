package Hospital_Management;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Storage.intialize();
        Boolean Start=true;
        Scanner sc=new Scanner(System.in);
        while(Start){
            Show.start();
            String choice=sc.nextLine();
                switch(choice){
                    case "1": {System.out.println("enter id\n") ;
                              String s=sc.nextLine();   
                                } break;
                    case "2": System.out.println("register"); break;
                    case "3": {System.out.println("exit"); Start=false; } break;
                    default: System.out.println("Enter correct option");
                } 
        }
      
    }
}
