import UIKit

struct exhaust{
    var type:String
}
//Computed property
struct car{
    var name:String
    let model:String
    var speed:Int
    var maxCapacity=4
    var currentCapacity:Int
    lazy var modifiedexhaust = exhaust(type: "Sound")
    var mileage:Int{
       (currentCapacity*speed)/6
    }
}

//property observers

struct car2{
    var name:String="Maruti"{
        willSet{
            print("Changing Car Name")
        }
        didSet{
            print("Name changed from \(oldValue) to \(name)")
        }
    }
}

var c=car2()
c.name="Lamborgini"

//Property Wrappers

@propertyWrapper
struct Capitalized{
    var value:String
    var wrappedValue:String{
        set{
            value=newValue.uppercased()
        }
        get{
            value
        }
    }
}

struct Car3{
    @Capitalized(value: "Car") var name:String
    
//    init(n: String){
//       name = n
//    }
}

var c1 = Car3()
c1.name = "Mclaren"
print(c1.name)

