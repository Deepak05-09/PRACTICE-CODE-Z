class Rocket implements SpaceShip{
    
    public boolean launch(){
      return true;
    }
    public boolean land(){
      return true;  
    }
    public boolean canCarry(Item item,int limit ){
         if(limit>=item.weight){
            return true;
        } 
        return false;
    }
    public void carry(Item object){
         if(canCarry(object,U1.limit)){
            U1.limit-=object.weight;
        } 
      
    } 
}