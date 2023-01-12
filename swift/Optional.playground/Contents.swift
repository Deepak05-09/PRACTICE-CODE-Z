import UIKit

let const:Int?;
var const1:Int!;
let defaultValue=34;
const=Int(variable);

if let const{
    print("it is covertable \(const)");
}
else{
    print("not convertible");
}


var num=const ?? defaultValue;
print(num);

