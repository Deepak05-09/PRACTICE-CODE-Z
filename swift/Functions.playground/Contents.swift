import UIKit

//no return type
func message(){
    print("Hello")
}
message()


//with return type
func add(number1:Int,number2:Int)->Int{
  return  number1+number2
}
print("Add :\(add(number1: 4, number2: 5))")


//multiple return values

func minMaxInArray(array:[Int])->(min:Int,max:Int){
    var min=array[0]
    var max=array[0]
    for numbr in array[1..<array.count]{
        if(min>numbr){
            min=numbr
        }
        if(max<numbr){
            max=numbr
        }
    }
    return (min,max)
}
var array=[4,3,5,6]
print("Array Sorting: \(minMaxInArray(array: array))")


//argument labels

func sub(number1:Int,from number2:Int)->Int{
    number2-number1
}
print("sub: \(sub(number1: 6, from: 9))")


//default values

func multiply(number1:Int,number2:Int=1)->Int{
    number1*number2
}
print("With default: \(multiply(number1: 67))")
print("Without default: \(multiply(number1: 67,number2: 3))")


//variadic parameter

func addition(numbers:Int...)->Int{
    var total=0;
    for numbr in numbers{
        total+=numbr
    }
    return total
}
print("Addition of numbers: \(addition(numbers: 1,2,3,4,5,6,7,8,9))")


//In-Out parameter
func sort(array:inout [Int]){
    for  i in 0..<array.count{
        for j in 0..<array.count{
            if(array[i]<array[j]){
                var temp=array[i]
                array[i]=array[j]
                array[j]=temp
            }
        }
    }
}
var arr=[8,4,5,33]
sort(array: &arr)
print("Inout : \(arr)")


//Function types

var subraction:(Int,Int)->Int=sub
print("Ans: \(subraction(3,5))")


//Function type as parameters

func calculator(action: (Int,Int)->Int,number1: Int,number2: Int)->Int{
  action(number1,number2)
}
print("add: \(calculator(action: add,number1: 4,number2: 5))")
print("sub: \(calculator(action: sub,number1: 4,number2: 5))")
print("multiply: \(calculator(action: multiply,number1: 4,number2: 5))")

//Function types as return types

func chooseFunction(value:Int)->(Int,Int)->Int{
    switch value{
    case 1:
        return add
    case 2:
        return sub
    case 3:
        return multiply
    default :
        return add
    }
    
}

var Action=chooseFunction(value: 2)
print("func Return :\(Action(2,3))")


//Nested Function
func nestedFunc(flag: Bool)->(Int,Int)->Int{
    func ad(input1:Int,input2:Int)->Int{
        return input1+input2
    }
    func sb(input1:Int,input2:Int)->Int{
        return input1-input2
    }
    return flag ? ad : sb
}

print("Nested : \(nestedFunc(flag: true)(3,4))")
print("Nested : \(nestedFunc(flag: false)(3,4))")

