class U1 extends Rocket{

   private  int limit=8000;

   
    @Override
   public int budget(){
      return 8000;
   }

   
   @Override
    public boolean launch(){
      return 0.05*(8000-this.limit)/800<=(Math.random());
    }

    @Override
    public boolean land(){
      return 0.05*(8000-this.limit)/800<=(Math.random());
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