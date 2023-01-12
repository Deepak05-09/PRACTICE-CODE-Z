import UIKit

var Str1="";
var Str2=String();

Str1="Hello";
Str2=Str1;
print(Str2);

//CONCATENATION
var concate=Str1+" "+Str2;
print(concate);

//INTERPOLATION
print(concate+" \(defaultValue)");

//INDICES
print(concate[concate.startIndex]);
print(concate[concate.index(after:concate.startIndex )]);
print(concate[concate.index(concate.startIndex, offsetBy: 7)]);

//INSERT
let range=concate.index(concate.endIndex, offsetBy: -5);
concate.insert("W", at:concate.index(concate.endIndex, offsetBy: -5));
print(concate);

//REMOVE
concate.removeSubrange(concate.startIndex..<range);
print(concate);
