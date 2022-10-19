import java.io.File;
import java.io.IOException;
import java.util.*;

public class Simulation  {

    //read the file 
    // convert it into item type
    // store it in a arraylist 
   ArrayList<Item> loadItems(String file) throws IOException{
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
    private ArrayList<Rocket> loadU1(ArrayList<Item> loadItems){
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
    private ArrayList<Rocket> loadU2(ArrayList<Item> loadItems){
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
    private double runSimulation(ArrayList<Rocket> fleet){
      int RocketCount=0;
      double totalBudget=0;
      
        for(int i=0;i<fleet.size();i++){
         
        Rocket r1=fleet.get(i);
        boolean LAUNCH=r1.launch();
        boolean LAND=r1.land();
        
        //count no.of rockets needed 
        RocketCount++;

      if(LAUNCH&&LAND){
        totalBudget+=r1.budget();
      }
      else if(!LAUNCH||!LAND){
        totalBudget+=r1.budget();
       i=i-1;
      }
      else{
        totalBudget+=r1.budget();
      }
      
    }
    System.out.println("No.of.rockets needed is :"+RocketCount);
    return totalBudget;
    
}
public static void main(String[]args) throws IOException{
       
  Simulation simulation=new Simulation();  

  ArrayList<Item> phase1=simulation.loadItems("Phase1.txt");
  ArrayList<Item> phase2=simulation.loadItems("Phase2.txt");

  ArrayList<Rocket> fleet=simulation.loadU1(phase1);
  ArrayList<Rocket> fleet2=simulation.loadU1(phase2);
  System.out.println(" Total Budget phase 1 for U1="+simulation.runSimulation(fleet));
  System.out.println(" Total Budget phase 2 for U1="+simulation.runSimulation(fleet2));

  ArrayList<Rocket> fleet3=simulation.loadU2(phase1);
  ArrayList<Rocket> fleet4=simulation.loadU2(phase2);
  System.out.println(" Total Budget phase 1 for U2="+simulation.runSimulation(fleet3));
  System.out.println(" Total Budget phase 2 for U2="+simulation.runSimulation(fleet4));
}
}