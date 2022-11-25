package Hospital_Management.MIDDLE_LAYER;

import Hospital_Management.DATA_LAYER.Storage;

public class Checker {
    
    public static boolean ispatientExists(String id){
        return Storage.patientList.isExist(id);
    }
}
