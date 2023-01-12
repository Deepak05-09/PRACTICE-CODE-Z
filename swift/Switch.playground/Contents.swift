import UIKit

//SWITCH

var value=8

switch value{
    case 1:
        print("the value is 1")
    case 2:
        print("the value is 2")
    default :
        print("default")
}

//INTERVAL MATCHING
switch value{
case 0:
    print("it is zero")
case 1..<10:
    print("it is less than 10")
case 10:
    print("it is 10")
default:
    print("it is greater than 10")
}


//TUPLE

var point=(1,2,3)

switch point{
case (0,0,0):
    print("the value is 1")
case (_,2,_):
    print("the value is 2")
case (_,_,3):
    print("the value is 3")
default :
    print("default")
}

//VALUE BINDING

switch point{
case (0,0,0):
    print("the value is 1")
case (let x,2,_):
    print("the value of x is \(x)")
case (_,let y,3):
    print("the value of y is \(y)")
default :
    print("default")
}

//COMPOUND CASES

switch value{
case 1,2,3:
    print("less than 3")
case 4,5,6,7:
    print("less than 7")
default :
    print("greater than 8")
}

