import UIKit

var array:[Int]=[1,2,3,4,4];

var array1=Array(repeating: 4, count: 3);
print(array1);

var array2=array+array1;
print(array2);

array2.append(456);
array2+=[45];
print(array2[3]);

for numbr in array2{
    print(numbr);
}

for index in 0..<array2.count{
    print(array2[index]);
}
