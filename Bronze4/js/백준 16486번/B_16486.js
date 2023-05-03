const fs = require('fs');
let ip = fs.readFileSync('B_16486.txt').toString().split('\n');
var d1 = parseInt(ip[0]);
var d2 = parseInt(ip[1]);
var pi = 3.141592;
console.log(2 * d1 + 2 * pi * d2);