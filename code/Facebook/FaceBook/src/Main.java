public class Main {
    public static void main(String[] args) {

        User user1=new User("raj","1234","uyf",23,"20:09:2002","chennai");
        User user2=new User("mahi", "345", "876",25, "21:04:2011", "coimbatore");
        User user3=new User("rambo", "315", "876",22, "21:06:2015", "salem");

        Post post=new Post("caption","video");
        user1.posts.add(post);

        Reaction like=new Reaction(Reaction.LIKE);
        Reaction dislike=new Reaction(Reaction.DISLIKE);

        user2.react(post,Reaction.LIKE,user2);
        user3.react(post,dislike, user3);
        user3.react(post,like, user3);

       Comment comment= new Comment("super");
       Comment comment1=new Comment("super1");

        user3.commentToPost(post,comment, user3);
        user2.commentToPost(post, comment1, user2);

        user3.react(comment, like, user3);

        System.out.println("\npost: "+post+"-----reacted by: "+post.Postreaction);
        System.out.println("comment: "+post.comment);

        System.out.println("like :"+like.reactedby);
        System.out.println("dislike :"+dislike.reactedby);
    }
}
