package Hospital_Management.UI;

import java.util.regex.Pattern;

public class Validate {
    
    private static final String emailPattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@+[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
    
    //private static final String emailPattern="^[a-z]([a-z0-9\\+-_])+\\.[a-z0-9-+_]+@[a-z]+\\.[a-z]{2,6}?+\\.[a-z]{2,6}?$";
    private static final String namePattern="[a-zA-Z]+";
    private static final String numberPattern="^[6-9][0-9]{9}";
    private static final String IdPattern="^[A-Za-z]+[0-9]{1,10}";
    private static final String passwordPattern="[a-zA-Z0-9!@#$%^&*()]{6,30}";
    private static final String onlyString="[a-zA-Z]+";
    private static final String onlyNumber="[0-9]+";

    public static boolean login(String id){
         return true;
    }
    public static boolean name(String name){
        return Pattern.matches(namePattern, name);
    }
    public static boolean ph_no(String ph_no){
        return Pattern.matches(numberPattern, ph_no);
    }
    public static boolean email(String email){
        return Pattern.matches(emailPattern, email);
    }
    public static boolean Patientage(String age){
        return Integer.parseInt(age)<200&&Integer.parseInt(age)>0;
    }
    public static boolean EmployeeAge(String age){
        return Integer.parseInt(age)<60&&Integer.parseInt(age)>22;
    }
    public static boolean Id(String id){
        return Pattern.matches(IdPattern, id);
    }
    public static boolean password(String password){
        return Pattern.matches(passwordPattern, password);
    }
    public static boolean onlyString(String value){
        return Pattern.matches(onlyString, value);
    }
    public static boolean onlyNumber(String value){
        return Pattern.matches(onlyNumber, value);
    }
}
