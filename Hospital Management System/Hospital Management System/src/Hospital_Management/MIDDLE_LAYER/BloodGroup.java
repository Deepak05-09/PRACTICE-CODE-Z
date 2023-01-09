package Hospital_Management.MIDDLE_LAYER;

public enum BloodGroup
{
   O_POSITIVE(1), A_POSITIVE(2), B_POSITIVE(3), AB_POSITIVE(4), O_NEGATIVE(5), A_NEGATIVE(6), B_NEGATIVE(7), AB_NEGATIVE(8);
   
   private final int value;

   private  BloodGroup(int value)
   {
      this.value=value;
   }

   public  int value()
   {
      return this.value;
   }

}