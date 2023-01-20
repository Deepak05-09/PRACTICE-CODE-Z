import UIKit

struct PostalAddress: Equatable {
    var moduleName: String
    var record: [String: Any]
    var addressList: [String: AnyObject]
    
    static func == (lhs: PostalAddress, rhs: PostalAddress) -> Bool {
        if let lhsId = lhs.recordId, let rhsId = rhs.recordId, lhsId == rhsId {
            return true
        }
        return false
    }
    
    var fullName: String? {
        return ""
    }
    
    var recordId: String? {
        return ""
    }
    
    static func getDisplayValues(for address: String) -> String {
        return ""
    }
}

struct PostalAddressList: Equatable {
    let recordList: [PostalAddress]
    
    subscript(index:Int)->PostalAddress{
        return recordList[index]
    }
    
}
    
    func createRecordAddressList() -> PostalAddressList {
        var addressList = [PostalAddress]()

        var Range:Int=Int.random(in: 1...3)
        for _ in 0...Range{
            addressList.append(randomPostalAddress())
        }

        return PostalAddressList(recordList: addressList)
    }

func isAddressUpdated(addressList:PostalAddressList) -> Bool {
       

    if addressList != recordAddressList {
        recordAddressList = addressList
        print("updated")
        return true
    } else {
        print("not updated")
        print(recordAddressList!)
        return false
    }
    }

var recordAddressList: PostalAddressList?


    func randomPostalAddress()->PostalAddress{

        func randomRec()->[String:Any]{
            var Range:Int=Int.random(in: 1...2)
            var record=[String : Any]()
            
            for _ in 0...Range {
                
                 var key=["K1","K2","K3","K4","K5"].randomElement()!
                var value=[7,true,3.4,"A"].randomElement()
                record[key]=value
            }
            return record
        }
        
        func randomAddList()->[String:AnyObject]{
            var Range:Int=Int.random(in: 1...2)
            var addList=[String : AnyObject]()
            
            for _ in 0...Range {
                
                 var key=["O1","T2","Th3","F4","Fi5"].randomElement()!
                 var value=randomRec()
                addList[key]=value as AnyObject
            }
            return addList
        }
    
    var name=["One","Two","Three","Four","Five"].randomElement()

    return PostalAddress(moduleName:name!, record: randomRec(), addressList: randomAddList())
}


var postalAddress1=PostalAddress(moduleName: "One", record: ["one":1,"two":"Fox"],
                                 addressList: ["1":["one":1,"two":2] as AnyObject,"2":["one":1,"two":2] as AnyObject] )

var recordList=[postalAddress1,postalAddress1]

// postalAddressList=PostalAddressList(recordList: recordList)

var postalAddressList=createRecordAddressList()

isAddressUpdated(addressList: postalAddressList)

isAddressUpdated(addressList: recordAddressList!)

isAddressUpdated(addressList: createRecordAddressList())
