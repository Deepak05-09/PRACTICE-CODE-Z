import java.util.ArrayList;

public class Reaction{
    public static final Reaction LIKE=new Reaction("like");
    public static final Reaction DISLIKE=new Reaction("dislike");

    String reactName;
    Reaction reaction;
    ArrayList<User>reactedby=new ArrayList<>();

    private Reaction(String name){
        reactName=name; 
    }

    Reaction(Reaction reaction){
        this.reaction=reaction;
        reactName=reaction.reactName;
    }
    
    public String toString(){
        return reactName;
    }
}

