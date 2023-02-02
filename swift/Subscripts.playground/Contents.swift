import UIKit

class grid{
    var row:Int=0
    var column:Int=0
    var arr:[Int]
    init(row:Int,column:Int){
        self.row=row
        self.column=column
        arr=Array(repeating: 0, count: row*column)
    }

    subscript(row:Int,column:Int)->Int?{
        get{
            guard row>=0&&row<self.row&&column>=0&&column<self.column else{
                return nil
            }
            return self.arr[row*column]
        }
        set{
            guard row>=0&&row<self.row&&column>=0&&column<self.column else{
               return print("Index out of bounds")
            }
            self.arr[row*column]=newValue!
        }
    }
    
}
var g=grid(row: 2, column: 2)
g[0,1]=45
print(g[0,2])

enum Week:Int{
    case sunday=1,monday,tuesday,wednesday,thursday,friday,saturday
    static subscript(day:Int)->Week?{
        guard day>0&&day<=7 else{
            return nil
        }
        return Week(rawValue: day)
    }
}
var holiday=Week[1]
Week[8]
