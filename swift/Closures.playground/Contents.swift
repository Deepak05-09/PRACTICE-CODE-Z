import UIKit

var array=[4,3,5,6,3,1,8]

//Inferring type
array.sorted(by: {a,b in
    return a>b
})

//Implicit
array.sorted(by: {a,b in a<b })

//shortHand Arguments
array.sorted(by: {$0>$1})

//Operator Method
array.sorted(by: >)

//Trailing Closures

func doSomething(b:()->Void){
    b()
}

doSomething{ print("Hello")}

//Multiple trailing Closures
func doSomething2(a:()->Void,b:()->Void){
    a()
    b()
}
doSomething2{
    print("\nHello")
} b: {
    print("World")
}

//Capturing Values

func Increment( by a:Int) ->()->Int {
    var x=0
    
    var b:()->Int={
        x+=a
        return x
    }
    return b
}

var x=Increment(by: 10)
print(x())
print(x())
print(x())

var y=x
print(y())

//Escaping closure

func escaping(a:@escaping(String)->String)->(String)->String{
    print("In Function")
    return a
}

var greet=escaping { name in
    return "Hello \(name)"
}
print(greet("Naveen"))
print(greet("Kumar"))

func autoClosure(a:@autoclosure()->Void){
    a()
}
autoClosure(a: print("AutoClosure"))
