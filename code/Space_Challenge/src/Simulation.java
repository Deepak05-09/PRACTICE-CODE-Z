import java.io.File;
import java.io.IOException;
import java.util.*;

public class Simulation  {

    //read the file 
    // convert it into item type
    // store it in a arraylist 
    public static ArrayList<Item> loadItems(String file) throws IOException{
          File F=new File(file);
          Scanner sc=new Scanner(F);
          ArrayList<Item> items=new ArrayList<>();
          while(sc.hasNextLine()){
          items.add(new Item(sc.nextLine()));
        }
        sc.close();
        return items;
    }

    //load the items in the U1 rocket
    //if limit exceeded new U1 rocket will be created and add the remaining items
    //all the rockets are stored as fleet
      public static ArrayList<Rocket> loadU1(ArrayList<Item> loadItems){
       ArrayList<Rocket> fleet=new ArrayList<>();
       Rocket rocket=new U1();

       for(Item i: loadItems){
        if(rocket.canCarry(i)){
            rocket.carry(i);
        }
        else{
          fleet.add(rocket);
           rocket=new U1();
        }
       }
       return fleet;
    }
    
    //load the items in the U2 rocket
    //if limit exceeded new U2 rocket will be created and add the remaining items
    //all the rockets are stored as fleet
    public static ArrayList<Rocket> loadU2(ArrayList<Item> loadItems){
      ArrayList<Rocket> fleet=new ArrayList<>();
      Rocket rocket=new U2();

      for(Item i: loadItems){
       if(rocket.canCarry(i)){
           rocket.carry(i);
       }
       else{
         fleet.add(rocket);
          rocket=new U2();
       }
      }
      return fleet;
   }
    
     
    //give total budget
    //if rocket failed to launch or land  by shifting the position we are again launching or landing
    public static double runSimulation(ArrayList<Rocket> fleet){
      int c=0;
       double totalBudget=0;
      
        for(int i=0;i<fleet.size();i++){
          c++;
        Rocket r1=fleet.get(i);
      if(r1.launch()&&r1.land()){
        totalBudget+=r1.budget();
       
      }
      else if(!r1.launch()||!r1.land()){
        totalBudget+=r1.budget();
       i=i-1;
      }
      else{
        totalBudget+=r1.budget();
      }
      
      
    }
    System.out.println("No.of.rockets needed is :"+c);
    return totalBudget;
    
}
}