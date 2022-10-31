import java.util.ArrayList;
import java.util.HashMap;

public class Post{
    String caption;
    Object postType;
    HashMap<Reaction,ArrayList<User>> Postreaction;
    ArrayList<Comment> comment;
    

    Post(String caption,Object postType){
        this.caption=caption;
        this.postType=postType;
        Postreaction=new HashMap<>();
        comment=new ArrayList<>();
    }

     void reactPost(Reaction reaction,User user){

        ArrayList<User> list=Postreaction.get(reaction);
        if(list == null) {
            list = new ArrayList<User>();
            list.add(user);
            Postreaction.put(reaction,list);
       }
        else {
           
           if(!list.contains(user)){ 
            list.add(user);
        }
       }
    }
    
    void  AddComment(Comment comment,User user){
        this.comment.add(comment);
    }
    public String toString(){
        return caption+" "+postType;
    }
}