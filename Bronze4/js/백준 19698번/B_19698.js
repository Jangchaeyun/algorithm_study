const fs = require('fs');

let ip = fs.readFileSync('B_19698.txt').toString().split(' ')
var n = parseInt(ip[0]);
var w = parseInt(ip[1]);
var h = parseInt(ip[2]);
var l = parseInt(ip[3]);
w = parseInt(w / l);
h = parseInt(h / l);
var sum = w * h;
if (n >= sum) console.log(sum);
else console.log(n);