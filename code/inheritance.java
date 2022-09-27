
class Vehicle{
    public void Steering(){
        System.out.println("I can turn the Car");
    }
    public void suspensionSystem(){
        System.out.println("I have wheels,axles,Tires and Springs");
    }
    public exhaustSystem (){
        System.out.println("The gas is coming out ");
    }
    public void engine(){
        System.out.println("I have 1000 horse power");
    }
}

class Lamborgini extends Vehicle{

     //override
      public void engine(){
        System.out.println("I have an ASpirated Engine");
      }
      protected void gps(){
        System.out.println("Searching for directions");
      }
      protected void powerSeating(){
        System.out.println("Have a comfortable ride");
      }
}

class LamborginiAventador extends Lamborgini {
     public void antiLockBraking(){
        System.out.println("The wheels are unlocked");
     }
     public void climateControl(){
        System.out.println("The Air condition is adjusted");
     }
     //override
     public void engine(){
        System.out.println("I can generate 8500rpm");
     }
     public void speed(){
        System.out.println("217 mph");
     }
     public void speed(int x){
        System.out.println("Speed increased by :"+x);
     }
     public void brakingForce(){
        System.out.println("Maximum power output : 770PS");
     }
}

public class inheritance {
    public static void main(String[]args){
       Lamborgini  car1=new Lamborgini();
       car1.engine();
       car1.Steering();
       LamborginiAventador car2=new LamborginiAventador();
       car2.engine();
       car2.speed(80);
       car2.antiLockBraking();
       car2.brakingForce();
    }
}
