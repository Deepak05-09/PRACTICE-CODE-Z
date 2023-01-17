import UIKit

struct Dog{
    var name=""
    var age=0
}

class Cat{
    var name=""
    var age=0
    
    func toString()->String{
        "Name :"+name+"   age: "+String(age)
    }
}

var doggie=Dog()
var kitty=Cat()

doggie.name="Arnold"
doggie.age=12
print(doggie)

kitty.name="Ronnie"
kitty.age=15
print(kitty.toString())

//Member wise initializer
let dg=Dog(name: "rambo",age: 6)

var dog2=doggie
dog2.name="chris"
dog2.age=33
print(dog2)
print(doggie)

var cat2=kitty
cat2.age=23
print(cat2.toString())

