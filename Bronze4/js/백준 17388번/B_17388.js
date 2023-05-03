const fs = require('fs');
let ip = fs.readFileSync('B_17388.txt').toString().split(' ');
var a = parseInt(ip[0]);
var b = parseInt(ip[1]);
var c = parseInt(ip[2]);
var sum = a + b + c;
if (sum >= 100) console.log("OK");
else {
    var min = Math.min(a, Math.min(b, c));
    if (min == a) console.log("Soongsil");
    else if (min == b) console.log("Korea");
    else console.log("Hanyang");
}