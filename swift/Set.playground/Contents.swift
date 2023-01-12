import UIKit

var set=Set<Int>();
var set1:Set<Int>=[1,2,3,4];

set1.insert(5);

if set1.remove(5) != nil{
    print("Removed");
}
else{
    print("Not removed");
}

for numbr in set1{
    print(numbr);
}

var set2:Set<Int>=[1,2];
print(set.isSubset(of: set1));
print(set1.symmetricDifference(set2));
print(set1.subtracting(set2));
