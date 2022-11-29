package Hospital_Management.DATA_LAYER;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Hospital_Management.MIDDLE_LAYER.Bill;

public class BillDAO {
    
   

    public BillDAO(){
        
    }
    

    public HashMap<LocalDate, ArrayList<Bill>> getBillList() {
        return Storage.storage.billList;
    }

    public void add(LocalDate date,Bill bill){

          if(Storage.storage.billList.containsKey(date)){
            ArrayList<Bill> list=Storage.storage.billList.get(date);
            list.add(bill);
            Storage.storage.billList.replace(date,list);
          }
          else{
            ArrayList<Bill> list=new ArrayList<>();
            list.add(bill);
            Storage.storage.billList.put(date, list);
          }
    }

    public ArrayList<Bill> get(String patientId){
        Collection<ArrayList<Bill>> bill=Storage.storage.billList.values();
        
        ArrayList<Bill> temp=new ArrayList<>();
        for(ArrayList<Bill> bi: bill){
            ArrayList<Bill> list=bi;
            for(Bill b:list){
               if(b.patientId.equals(patientId)){
                temp.add(b);
               }
            }
        }
        return temp;
    }

    public Double getAmmount(LocalDate date){
        Double ammount=0.0;
        for(Bill bill:Storage.storage.billList.get(date)){
             ammount+=bill.total;
        }
        return ammount;
    }
}
