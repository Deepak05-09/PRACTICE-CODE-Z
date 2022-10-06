import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.math.*;

public class MovieGuess{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
     static String correctWord=" ";
     static String wrongWord="";
    //TO FIND IF THE ENTERED CHARACTER IS CORRECT OR NOT
    private static String GuessedWord(char w,String m){
         char word=w;
         String movie=m;
       if(movie.contains(word)){
        correctWord+=word;
        return ANSI_GREEN+"CORRECT"+ANSI_RESET;
       }
       else{
        wrongWord+=word;
       }
       return ANSI_RED+"WRONG"+ANSI_RESET;
    }

    //RANDOM INDEX VALUE
     private static int indexValue(int i){
        int movieName=i;
        int index=(int)(Math.random()*100);
        if(index>=movieName){
           index=indexValue(movieName);
     }
     return index;
    }
    //FILE READ AND RETURN RANDOM MOVIE NAME
    private static String ReadFile() throws Exception{
        File file=new File("/Users/deepak-pt6306/Documents/movies.txt");
        Scanner sc=new Scanner(file);
        List<String> movieName=new LinkedList<String>();
        while(sc.hasNextLine()){
            movieName.add(sc.nextLine().toUpperCase());
        }
        sc.close();
        return movieName.get(indexValue(movieName.size()));
    }
    //DISPLAY WORDS
    public static String displayMovieName(String l){
        char arr[]=new char[l.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]='_';
        }
        for(int i=0;i<l.length();i++){
            for(int j=0;j<correctWord.length();j++){
                if(l.charAt(i)==correctWord.charAt(j)){
                    arr[i]=l.charAt(i);
                }
            }
        }
        String out=String.valueOf(arr);;
       return out;
        
    }
    public static void main(String[]args) throws Exception{
       
      String RandomMovie=ReadFile();
      //System.out.println(RandomMovie);
     
      
      System.out.println("THE MOVIE CONTAINS "+RandomMovie.split(" ").length+" WORDS");
      System.out.println(displayMovieName(RandomMovie));
      Scanner sc=new Scanner(System.in);

      int guessCount=RandomMovie.length()-(RandomMovie.split(" ").length-1);

      while(guessCount>=0){
          System.out.println("ENTER YOUR GUESS :");
          char guessWord=sc.next().charAt(0);
          System.out.println("YOUR GUESSED WORD IS "+(GuessedWord(guessWord,RandomMovie)));
          System.out.println(displayMovieName(RandomMovie));
          guessCount--;

          if(displayMovieName(RandomMovie).replaceAll("_","").length()==RandomMovie.length()){
            System.out.println(ANSI_GREEN+"CONGRATS! YOU HAVE WON"+ANSI_RESET);
           break;
         }

         if(guessCount>0){
         System.out.println("YOU HAVE "+ANSI_YELLOW+guessCount+ANSI_RESET+" REMAINING GUESS(ES)");}
        }

        if(displayMovieName(RandomMovie).replaceAll("_","").length()!=RandomMovie.length()){
            System.out.println(ANSI_RED+"YOU LOSE ; BETTER LUCK NEXT TIME"+ANSI_RESET);
            System.out.println("THE MOVIE NAME IS :"+ANSI_BLUE+RandomMovie+ANSI_RESET);
        }
        sc.close();
     
    }
    }
   
       
    

