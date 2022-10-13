import java.io.IOException;
import java.util.ArrayList;

public class Space_Challenge2{
    public static void main(String[]args) throws IOException{
       
        ArrayList<Item> phase1=Simulation.loadItems("Phase1.txt");
        ArrayList<Item> phase2=Simulation.loadItems("Phase2.txt");

        ArrayList<Rocket> fleet=Simulation.loadU1(phase1);
        ArrayList<Rocket> fleet2=Simulation.loadU1(phase2);
        System.out.println(" Total Budget phase 1 for U1="+Simulation.runSimulation(fleet));
        System.out.println(" Total Budget phase 2 for U1="+Simulation.runSimulation(fleet2));

        ArrayList<Rocket> fleet3=Simulation.loadU2(phase1);
        ArrayList<Rocket> fleet4=Simulation.loadU2(phase2);
        System.out.println(" Total Budget phase 1 for U2="+Simulation.runSimulation(fleet3));
        System.out.println(" Total Budget phase 2 for U2="+Simulation.runSimulation(fleet4));
    }
}