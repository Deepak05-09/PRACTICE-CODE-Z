import UIKit

enum Errors:Error{
    case welcomeError,exitError,MiddleError
}


class ErrorHandling{
    
    func Function(Value:Int) throws->String{
        switch(Value){
        case 1...10:
            throw Errors.welcomeError
        case 11...20 where Value != 12:
            throw Errors.MiddleError
        case 21...30:
            throw Errors.exitError
        default:
            return "Hello...!"
        }
        
    }
}

var err=ErrorHandling()
try? err.Function(Value: 13)
try! err.Function(Value: 66)

do{
   print( try err.Function(Value: 67))
}
catch Errors.welcomeError  {
    print("Error At Welcome")
}
catch Errors.MiddleError{
    print("Error at Middle")
}
catch{
    print("Error At \(error)")
}


func DEFER(){
    print(1+2)
    defer{
        print(1)
    }
    defer{
        print(12)
    }
    defer{
        print(13)
    }
}

DEFER()
