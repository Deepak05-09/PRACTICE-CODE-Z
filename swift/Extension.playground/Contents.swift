import UIKit

protocol Human{
    var gender:String{get}
    func eat()->Void
    func drink(liquid:String)->String
}

class Person{
    var name:String
    var age:Int
    static var staticVar:Bool=true
    
    init(name:String,age:Int){
        self.name=name
        self.age=age
    }
    
    static func somefunc(){
        print("Something static")
    }
    
    func talk(){
        print("Blah,Blah,Blah")
    }
    func walk(){
        print("Walking")
    }
    
}

var ramu=Person(name: "Ramu", age:21)
ramu.name
ramu.age
ramu.talk()
ramu.walk()
//ramu.description
//ramu.eat()

//computed property
extension Person{
    var description:String{
        return "Person's name is \(name) and age is \(age)"
    }
}
ramu.description

//Initializer
extension Person{
    convenience init(name:String) {
        self.init(name: name, age: 1)
    }
}

var somu=Person(name: "Somu")

//Methods
extension Person{
    func goToWork(){
        print("Going to work")
    }
    static func staFunc(){
        print("static func in extension")
    }
}
ramu.goToWork()
Person.staFunc()

extension Person:Human{
    var gender: String {
        return "Male"
    }
    
    func eat() {
        print("Eating")
    }
    
    func drink(liquid: String) -> String {
        return "I am drinking \(liquid)"
    }
    
}

ramu.gender
ramu.eat()
ramu.drink(liquid: "Milk")
