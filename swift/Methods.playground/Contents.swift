import UIKit
//MUTATING FUNCTION
struct Rectangle{
    var length:Int
    var breadth:Int
    
   mutating func changeLength(a:Int)->Void{
       length=a
    }
}

var a=Rectangle(length: 23, breadth: 56)
a.length=67
a.breadth=45
print(a)
a.changeLength(a: 55)


//INSTANCE METHOD

class Dog{
    var name:String = ""
    
    func bark(){
        print ("Bow!!...Bow!!!")
    }
    func changeName(newName name:String)->Void{
        self.name=name
    }
}

var d=Dog()
d.name="Harry Potter"
d.bark()
d.changeName(newName: "Guhan")
print(d.name)

//Type Method

class Integer{
    class func isNumber(number:String)->Bool{
        let temp:Int?=Int(number)
        if temp != nil{
            return true
        }
        return false
    }
}

print(Integer.isNumber(number: "23"))
print(Integer.isNumber(number: "hello"))
