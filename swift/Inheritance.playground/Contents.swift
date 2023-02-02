import UIKit

class Animal{
    var name:String
    let legs:Int
    init(name:String,legs:Int=4){
        self.name=name
        self.legs=legs
    }
    deinit{
        print("Animal is dead")
    }
    
    func makeSound(){
        print("some noise")
    }
    
}

final class Cat:Animal{
    var tail:Bool
    override var name: String{
        willSet{
            print("Name will be changed to \(newValue)")
        }
    }
    
    init(name:String,legs:Int,tail:Bool){
        self.tail=tail
        super.init(name: name,legs: legs)
    }
    override func makeSound() {
        print("meow..! meow..!!")
    }
}

var kitty=Cat(name: "Kitty", legs: 4, tail: true)

//class subcat:Cat{
//
//}

