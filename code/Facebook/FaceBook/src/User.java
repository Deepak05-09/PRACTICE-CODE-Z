import java.util.ArrayList;

public class User{
   
    String name;
    String userId;
    String password;
    int age;
    String dateofBirth;
    String address;
    ArrayList<Post> posts;

    User(String name,String userId,String password,int age,String dateofBirth,String address){
        this.name=name;
        this.userId=userId;
        this.password=password;
        this.age=age;
        this.dateofBirth=dateofBirth;
        this.address=address;
        posts=new ArrayList<>();
    }
     void react(Post post,Reaction reaction,User user){
         post.reactPost(reaction,user);
         //reaction.reactedby.add(user);
         reaction.reactedby.add(user);
    }
     void react(Comment comment,Reaction reaction,User user){
        comment.reactToComment(reaction,user);
        //reaction.reactedby.add(user);
        reaction.reactedby.add(user);
   }

     void commentToPost(Post post,Comment comment,User user){
         post.AddComment(comment,user);
    }

    public String toString(){
        return name;
    }


}
