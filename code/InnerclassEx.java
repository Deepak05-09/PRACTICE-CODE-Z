class OuterClass{
 int x=45;

    class InnerClass{
      int y=55;

       class InnerInnerClass{
        int z=50;

         static class IIclass{
           int w=60;
         }
       }
    }
}

class InnerclassEx{
    public static void main(String[]args){
      OuterClass cal=new OuterClass();
      OuterClass.InnerClass cal1= cal.new InnerClass();
      OuterClass.InnerClass.InnerInnerClass cal2=cal1.new InnerInnerClass();
      System.out.println(cal.x+cal1.y+cal2.z);

      OuterClass.InnerClass.InnerInnerClass.IIclass cal3=new OuterClass.InnerClass.InnerInnerClass.IIclass();
      System.out.println(cal3.w);
    }
}