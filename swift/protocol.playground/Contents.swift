import UIKit

protocol Vehicle{
    var wheels:Int{get set}
    func start()->Void
    func stop()->Void
    init(wheels:Int)
}

protocol Livable{
    associatedtype type
    var car:type{get set}
    
    var isHabiatable:Bool { get set }
    mutating func change()->Void
}

struct Caravan: Vehicle, Livable{
    
    typealias type = Int
    var car:type=45
    
    var wheels: Int
    var isHabiatable: Bool
    
    init(wheels:Int,habitable:Bool){
        self.wheels=wheels
        self.isHabiatable=habitable
    }
    
    init(wheels:Int) {
        self.init(wheels: wheels, habitable:true)
    }
    
    func start() {
        print("Caravan Started")
    }
    
    func stop() {
        print("Caravan Stopped")
    }
    
    mutating func change() {
        if(isHabiatable){
            isHabiatable=false
        }
        else{
            isHabiatable=true
        }
    }
    
}


class Cvan:Vehicle,Livable{
    typealias type = String
    var car: String="Car"
    var wheels: Int
    var isHabiatable: Bool
    
    func start() {
        print("Started")
    }
    
    func stop() {
        print("Stopped")
    }
    
    init(wheels:Int,habit:Bool){
        self.wheels=wheels
        isHabiatable=habit
    }
    
     required convenience init(wheels: Int) {
         self.init(wheels: wheels, habit: true)
    }
    
    func change() {
        if(isHabiatable){
            isHabiatable=false
        }
        else{
            isHabiatable=true
        }
    }
    
}

class Cvan2:Cvan{
    var someVar:String
    
     init(wheels: Int, habit: Bool,some:String) {
        someVar=some
        super.init(wheels: wheels, habit: habit)
    }
    
    required convenience init(wheels: Int) {
        self.init(wheels: wheels, habit: true, some: "some")
    }
}

var variable:any Vehicle & Livable

variable=Cvan2(wheels: 42)

//variable.someVar  //error
variable.start()


