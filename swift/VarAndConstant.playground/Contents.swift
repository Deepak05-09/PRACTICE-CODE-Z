import UIKit

let constant=45;
var variable="hello";

//TUPLE
var tuple=(4,"Value");
var Organization=((company:"zoho",employee:678),(company:"CTS",employee:607));

var comName=Organization.0.company;
Organization.0.company="TCS";
var employeeCount=Organization.1.employee;

print(comName);
print(employeeCount);
print(Organization);
