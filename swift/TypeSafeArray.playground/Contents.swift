import UIKit

extension Array {
    public subscript(safeIndex index: Int) -> Element? {
        guard index >= startIndex, index < endIndex else {
            return nil
        }
        return self[index]
    }
}

var arr=[1,2,3,4]
print(arr[safeIndex:2]!)
print(arr[safeIndex:5] as Any)



