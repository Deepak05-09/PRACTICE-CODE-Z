import java.util.*;
class MyError extends Exception{
    MyError(String msg){
        super(msg);
    }
}

public class ExceptionEx {
    public static void main(String[]args) throws MyError{
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER");
        int i=sc.nextInt();
        if(i<0){
            throw new MyError("NEGATIVE VALUE SHOULD NOT BE GIVEN");
        }
        else{
            System.out.println(i+8);
        }
    }
}
