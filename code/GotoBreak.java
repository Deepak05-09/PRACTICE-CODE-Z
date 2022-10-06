public class GotoBreak{
    public static void main(String[]args){
        first: for(int i=0;i<7;i++){
            System.out.println("1st loop "+i);
               second: for(int j=0;j<7;j++){
                    System.out.println("2nd loop "+j);
                   third: for(int k=0;k<7;k++){
                        System.out.println("3rd loop "+k);
                        if(k==1){
                            break second;
                        }
                    }
                }
            }
        }
    }
