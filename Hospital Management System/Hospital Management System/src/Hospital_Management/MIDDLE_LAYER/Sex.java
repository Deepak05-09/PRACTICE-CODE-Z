package Hospital_Management.MIDDLE_LAYER;

public enum Sex{
    MALE(1),FEMALE(2),TRANSGENDER(3);

    private final int value;

    private Sex(int value)
    {
        this.value=value;
    }
    
    public int value(){
        return this.value;
    } 
} 