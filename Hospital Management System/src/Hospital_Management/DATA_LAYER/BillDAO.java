package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Bill;

public class BillDAO {
    
    HashMap<LocalDate,ArrayList<Bill>> billList;

    BillDAO(){
         billList=new HashMap<>();
    }

    public HashMap<LocalDate, ArrayList<Bill>> getBillList() {
        return billList;
    }

    public void add(LocalDate date,Bill bill){

          if(billList.containsKey(date)){
            ArrayList<Bill> list=billList.get(date);
            list.add(bill);
            billList.replace(date,list);
          }
          else{
            ArrayList<Bill> list=new ArrayList<>();
            list.add(bill);
            billList.put(date, list);
          }
    }

    public ArrayList<Bill> get(LocalDate date){
        return billList.get(date);
    }
}
