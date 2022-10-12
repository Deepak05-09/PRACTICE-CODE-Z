class U1 extends Rocket{
   private static int possibility=(int)(Math.random()*10);
   private int randomNumber=(int)(Math.random()*10);
   public static int limit=18000;

    public boolean launch(){
       if(possibility<=randomNumber){
         return true;
       }  
       return false;
    }
    public boolean land(){
     if(possibility<=randomNumber){
         return true;
       }  
       return false;
    }
 }