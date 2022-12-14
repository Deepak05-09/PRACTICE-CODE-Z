class U2 extends Rocket{

    private  int limit=10000;
 
    
     @Override
    public int budget(){
       return 15000;
    }
 
    
    @Override
     public boolean launch(){
       return 0.05*(10000-this.limit)/1000<=(Math.random());
     }
 
     @Override
     public boolean land(){
       return 0.04*(10000-this.limit)/1000<=(Math.random());
     }
 
     @Override
     public boolean canCarry(Item item){
      return limit>=item.weight;
     }
 
     @Override
     public void carry(Item object){
       if(canCarry(object)){
          limit-=object.weight;
      } 
    
  } 
  
 
  }