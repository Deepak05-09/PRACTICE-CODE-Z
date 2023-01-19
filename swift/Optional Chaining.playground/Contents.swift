import UIKit


class Furniture{
    var name:String
    
    init(){
        name=""
    }
    init(name:String){
        self.name=name
    }
    
}

class Table:Furniture{
    var material:String
    var price:Int
    var noOfLegs:Int
    var type:String?
    
    init(material:String,price:Int,noOfLegs:Int){
        self.material=material
        self.price=price
        self.noOfLegs=noOfLegs
        super.init(name:"Table")
    }
    convenience init(material:String) {
        self.init(material:"Tek",price:100,noOfLegs:4)
    }
    
}

class chair:Furniture{
    var material:String
    var price:Int
    var noOfLegs:Int
    var type:String?
    
    init(material:String,price:Int,noOfLegs:Int){
        self.material=material
        self.price=price
        self.noOfLegs=noOfLegs
        super.init(name:"Chair")
    }
    convenience init(material:String) {
        self.init(material:"Tek",price:100,noOfLegs:4)
    }

}

class Buy{
    var material:Furniture?
    
}

var buy=Buy()

buy.material?.name="Table"
print(buy.material?.name)
buy.material=Table(material: "Rose Wood")
buy.material?.name="Table"
print(buy.material?.name)


