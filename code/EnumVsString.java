enum Day{
    MONDAY("Working day"){
        public String WorkingHours(){
            return "9 Hrs";
        }
    },
    TUESDAY("Working day"){
        public String WorkingHours(){
            return "8 Hrs";
        }
    },
    WEDNESDAY("Working day"){
        public String WorkingHours(){
            return "4 Hrs";
        }
    },
    THURSDAY("Working day"){
        public String WorkingHours(){
            return "6 Hrs";
        }
    },
    FRIDAY("Working day"){
        public String WorkingHours(){
            return "3 Hrs";
        }
    },
    SATURDAY("holiday"){
        public String WorkingHours(){
            return "no working Hrs";
        }
    },
    SUNDAY("Holiday"){
        public String WorkingHours(){
            return "no working Hrs";
        }
    };
   
    private final String value;
   Day(String value){
    this.value=value;
   }

   public String TypeOfDay(){
    return value;
   }
   public abstract String WorkingHours();
    
    }

class Days{
    public static final String monday="Monday";
    public static final String tuesday="Tuesday";
    public static final String wednesday="Wednesday";
    public static final String thursday="Thursday";
    public static final String friday="Friday";
    public static final String saturday="Saturday";
}

class Players{
    public static final String barbarian="Barabarian";
    public static final String Archer="Archer";
    public static final String giant="Giant";
}

public class EnumVsString{
    
    /*    ------------
      * we can still give invalid values 
      * ex: we can still pass players type
   
     private static void dayType(String day){
        System.out.println("Today is "+day);
    } 
          -------------   */

    //ENUM CONSTANTS
    // here we can only pass type Day
    private static void dayType(Day day){
        System.out.println("Today is "+day);
    }
    public static void main(String[] name){
       
       /*     -------------
        * there will be no type safe 
        * we can still give values that are not  part of our logic..Here "Giant" is not a day but still we can pass the argument and the output will also come
       
        dayType(Players.giant);   //String constant  
            -------------   */
      
       // dayType(Players.giant);// enum constant //compile error

        dayType(Day.MONDAY);  

       // enum has its own constructors and methods unlike constants
         System.out.println(Day.MONDAY.TypeOfDay());
         System.out.println(Day.TUESDAY.WorkingHours());
    }
}