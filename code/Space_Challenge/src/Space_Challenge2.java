import java.io.IOException;
import java.util.ArrayList;

public class Space_Challenge2{
    public static void main(String[]args) throws IOException{
        //Simulation o2=new Simulation();
        Simulation.loadItems("Phase1.txt");
        //o2.loadItems("Phase_2.txt");
        ArrayList<Item> phase1=Simulation.loadItems("Phase1.txt");
        ArrayList<Rocket> fleet=Simulation.loadU1(phase1);
        System.out.println(" Total Budget="+Simulation.runSimulation(fleet));
    }
}