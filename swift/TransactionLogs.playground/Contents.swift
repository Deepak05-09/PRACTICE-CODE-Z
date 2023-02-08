import Foundation


func readFile()->Logs?{
    print("readfile")
    let fileName="logs"
    let fileType="json"
    if let path=Bundle.main.path(forResource: fileName, ofType: fileType){
        do{
            let data = try Data(contentsOf: URL(filePath: path),options:.mappedIfSafe)
            let decoder=JSONDecoder()
             let log=try decoder.decode(Logs.self, from:data)
            return log
        }
        catch {
            print(error)
        }
    }
    else{
        print("No file")
    }
    return nil
}

struct TransactionMap: Codable{
   let tableName: String
   let lookupLabel: String
   let recordID: String?
   let lookupID: String
   let lookupColumn: String
   let modifiedTime: Int
   let transactionID: String

   enum CodingKeys: String, CodingKey {
       case tableName = "table_name"
       case lookupLabel = "lookup_label"
       case recordID = "record_id"
       case lookupID = "lookup_id"
       case lookupColumn = "lookup_column"
       case modifiedTime = "modified_time"
       case transactionID = "transaction_id"
   }
    
    var modTime:String{
        let date = Date(timeIntervalSince1970:Double(modifiedTime) / 1000.0)
            let formatter = DateFormatter()
            formatter.dateStyle = .medium
        formatter.timeStyle = .medium
            return formatter.string(from: date)
    }
}



struct Transaction: Codable {
    let moduleName: String
    let transactionID: String
    let transactionTime: Int
    let errorMessage:String
    let operationType: Int
    
    enum CodingKeys: String, CodingKey {
        case moduleName = "module_name"
        case transactionID = "transaction_id"
        case transactionTime = "transaction_time"
        case errorMessage = "error_message"
        case operationType = "operation_type"
    }
    
    var error:String?{
        errorDetails(errorMessage: errorMessage, start: "{error=(", end: ",")
    }
    
    var serverTime:String?{
        if let time=errorDetails(errorMessage: errorMessage, start: "servertime=", end: ";")
        {
                let date = Date(timeIntervalSince1970:Double(time)! / 1000.0)
                let formatter = DateFormatter()
                formatter.dateStyle = .medium
                return formatter.string(from: date)
            }
        return nil
        }
    
    private func errorDetails(errorMessage:String,start:String,end:String)->String?{
        if let startIndex = errorMessage.range(of: start)?.upperBound,
           let endIndex = errorMessage.range(of: end, range: startIndex..<errorMessage.endIndex)?.lowerBound {
            return String(errorMessage[startIndex..<endIndex]).replacing("\"", with: "")
        }
        return nil
    }
    
    }
   

struct Logs : Codable{
    let transactionMap:[TransactionMap]
    let transactions:[Transaction]
    
    enum CodingKeys: String, CodingKey {
        case transactionMap="TRANSACTIONS_MAP"
        case transactions="TRANSACTIONS"
    }
    
    private func error(transaction:Transaction)->String{
        if transaction.error==nil{
            for map in transactionMap{
                if map.transactionID==transaction.transactionID{
                    return "Account- \(map.lookupID) is the Owner"
                }
            }
        }
        return "Record owner Changed"
    }
    
    
    func details(){
        
        print("SI-NO\tTRANSACTION-ID\tLOOKUP-ID\tLOOKUP-LABEL\tLOOKUP-COLUMN\tTABLENAME\tRECORD-ID\tMODIFIED-TIME\n")
        for (index,map) in transactionMap.enumerated(){
            print("\(index+1)  \(map.transactionID)  \(map.lookupID)  \(map.lookupLabel)  \(map.lookupColumn)  \(map.tableName)  \(map.recordID ?? "-")  \(map.modTime)")
        }
        
        print("\nSI-NO\tTRANSACTION-ID\tMODULE-NAME\tOPERATION-TYPE\tERROR\tSERVER-TIME\n")
        for (index,transaction) in transactions.enumerated(){
            print("\(index+1)  \(transaction.transactionID)  \(transaction.moduleName)  \(transaction.operationType)  \(transaction.error ?? error(transaction: transaction))  \(transaction.serverTime ?? "-")")
        }
    }
    
}

var log=readFile()
log?.details()



