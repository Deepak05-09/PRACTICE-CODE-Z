

interface Android{
    void camera();
    void security();
    String call(int Number);
    String version();

}

abstract class Samsung implements Android{
    public void camera(){
        System.out.println("I have 5 Megapixel camera Quality");
    }
    public void security(){
        System.out.println("long press hash to unlock");
    }
    public String call(int Number){
       return ("calling...");
    }
    
    abstract void touchScreen();

}

class SamsungGalaxy extends Samsung {
    public void camera(){
        System.out.println("I have 60 pixel camera Quality");
    }
    public void transaction(int amount){
        System.out.println("Your Transaction of amount "+amount+" is being processed....");
    }
    public void touchScreen(){
        System.out.println("Amoled display");
    }
    public void security(){
        System.out.println("Enter pin/password to Unlock");
    }
    public void security(String mode){

        if(mode.equalsIgnoreCase("fingerprint")){
           System.out.println("use fingerprint to unlock");
        }
        else if(mode.equalsIgnoreCase("face")){
            System.out.println("Face REcoginition please dont close your eyes");
        }
    }
    public String version(){
        return "Android 10";
    }


}
class abstraction{

    public static void main(String[] args){
        
      Samsung mbl1=new SamsungGalaxy();
      mbl1.camera();
      
      System.out.println(mbl1.call(456789));
      SamsungGalaxy mbl2=new SamsungGalaxy();
      mbl2.transaction(100000);
      System.out.println();
      mbl2.security();
      mbl2.security("FACE");

    }
}
