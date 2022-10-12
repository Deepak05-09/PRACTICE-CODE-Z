import java.io.File;
import java.io.IOException;
import java.util.*;

public class Simulation  {
    static double totalBudget=0;
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
      public static ArrayList<Rocket> loadU1(ArrayList<Item> loadItems){
       ArrayList<Rocket> fleet=new ArrayList<>();
       Rocket rocket=new U1();
       for(Item i: loadItems){
        if(rocket.canCarry(i,U1.limit)){
            rocket.carry(i);
        }
        else{
          fleet.add(rocket);
           rocket=new U1();
           

        }
       }
       return fleet;
    }
    
     
    
    public static double runSimulation(ArrayList<Rocket> fleet){
      for(Rocket roc: fleet){
        Rocket r1=roc;
      if(r1.land()||r1.launch()){
        totalBudget+=5000;
      }
      
    }return totalBudget;
    
}
}