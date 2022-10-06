import java.util.*;


class ComparatorEx{
    public static void main(String[]args) {
    Map<String,Integer> map=new TreeMap<String,Integer>();
      map.put("Apple",56);
      map.put("banana",46);
      map.put("custard apple",20);
      map.put("dragon fruit",80);
      map.put("lemon",10);
       List<Map.Entry<String,Integer>> set=new ArrayList<>(map.entrySet());
       Collections.sort(set,new Comparator<Map.Entry<String,Integer>>(){
        public int compare(Map.Entry<String,Integer> val1,Map.Entry<String,Integer> val2){
            return val1.getValue()-val2.getValue();
        }
       });
       System.out.println(set);
        
    }
}