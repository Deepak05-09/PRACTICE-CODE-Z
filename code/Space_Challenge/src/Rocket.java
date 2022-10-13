class Rocket implements SpaceShip{
    
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
        
    } 
}