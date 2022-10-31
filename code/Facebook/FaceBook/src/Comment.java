import java.util.ArrayList;
import java.util.HashMap;


public class Comment {
    
     String comment;
     HashMap<Reaction, ArrayList<User>>likedby;
     String time;
     String date;

     Comment(String comment){
        this.comment=comment;
        likedby=new HashMap<>();
     }

   void reactToComment(Reaction reaction,User user){
      
      ArrayList<User> list=likedby.get(reaction);
      if(list == null) {
          list = new ArrayList<User>();
          list.add(user);
          likedby.put(reaction,list);
     }
      else {
         
         if(!list.contains(user)){ 
          list.add(user);
         }
      }
     }

    public String toString(){
      return comment;
    }
}
