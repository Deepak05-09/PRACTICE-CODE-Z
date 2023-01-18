import UIKit

class Vehicle{
    var wheels:Int
    
    init(wheels:Int){
        self.wheels=wheels
    }
    convenience init() {
        self.init(wheels:4)
    }
}

class Car: Vehicle{
    var name:String
    
    init(name:String,wheels:Int){
        self.name=name
        super.init(wheels:wheels)
    }
    
    override convenience  init(wheels:Int) {
        self.init(name:"Lamborgini",wheels:wheels)
    }
}

class SuperCar: Car{
    var power:Int=0
    
    
    
}

var c=Car()
c.name
c.wheels

//Initialization failures
class Truck{
    var name:String
    var wheel:Int
    
    init?(name:String,wheel:Int){
        if(name.isEmpty||wheel==0){
            return nil
        }
        self.name=name
        self.wheel=wheel
    }
}

var truck=Truck(name: "q", wheel: 20)
