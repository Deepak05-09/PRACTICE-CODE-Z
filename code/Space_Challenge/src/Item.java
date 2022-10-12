
public class Item{
    String name;
    int weight;

    Item(String item){
        String arr[]=item.split("=");
       this.name=arr[0];
       this.weight=Integer.parseInt(arr[1]);
    }
    public  String toString(){
        return this.name+" "+this.weight;
    }
}