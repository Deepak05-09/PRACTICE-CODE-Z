class EnumEx{  
    enum Mode{   
    EASY(5), MEDIUM(10), HARD(15), DIFFICULT(20);   
      
    private int getPoint;  
    private Mode(int value){  
    this.getPoint=value;  
    }  
    }  
    public static void main(String args[]){  
    for (Mode m : Mode.values())  
    System.out.println("Game mode -"+m+" points :"+m.getPoint);  
      
    }}  