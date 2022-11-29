package Hospital_Management.UI;

import java.util.regex.Pattern;

public class Validate {
    
    private  final String emailPattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@+[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; 
    private  final String namePattern="[a-zA-Z]{3,}";
    private  final String numberPattern="^[6-9][0-9]{9}";
    private  final String IdPattern="^[A-Za-z]+[0-9]{1,10}";
    private  final String passwordPattern="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
    private  final String onlyString="[a-zA-Z]+";
    private  final String onlyNumber="[0-9]+";

    public  boolean name(String name)
    {
        return Pattern.matches(namePattern, name);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean ph_no(String ph_no)
    {
        return Pattern.matches(numberPattern, ph_no);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean email(String email)
    {
        return Pattern.matches(emailPattern, email);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean patientAge(String age)
    {
        if(Pattern.matches(onlyNumber,age))
        {
            try{
                return Integer.parseInt(age)>0&&Integer.parseInt(age)<200;
            }
            catch (NumberFormatException numberFormatException){
                return false;
            }
        }

        return false;
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean employeeAge(String age)
    {
        if(Pattern.matches(onlyNumber,age))
        {
            try{
                return Integer.parseInt(age)>22&&Integer.parseInt(age)<60;
            }
            catch (NumberFormatException numberFormatException){
                return false;
            }
        }

        return false;
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean Id(String id)
    {
        return Pattern.matches(IdPattern, id);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean password(String password)
    {
        return Pattern.matches(passwordPattern, password);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean onlyString(String value)
    {
        return Pattern.matches(onlyString, value);
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

    public  boolean onlyNumber(String value)
    {
        return Pattern.matches(onlyNumber, value)&&value.length()<8;
    }
//---------------------------------------------------------------------------------------------------------------------------------------//

}
