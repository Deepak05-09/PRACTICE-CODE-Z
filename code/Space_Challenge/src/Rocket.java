class Rocket implements SpaceShip{
    private int limit=10000;
    
    public int budget(){
      return 9;
    }
    public boolean launch(){
      return true;
    }
    public boolean land(){
      return true;  
    }
    public boolean canCarry(Item item ){
        return true;
    }
    public void carry(Item object){
        if(canCarry(object)){
         limit-=object.weight;
     } 
    } 
}
