import UIKit

//FOR LOOP

let range=10

for numbr in 0...range{
    print(numbr)
}

for numbr in stride(from: 0, to: range, by: 2){
    print(numbr)
}

for numbr in stride(from: 0, through: range, by: 4){
    print(numbr)
}

//WHILE LOOP
var end=1
while (end<=10 ){
    print(end)
    end+=1;
}

repeat{
   print(end)
}while (end<=10)

