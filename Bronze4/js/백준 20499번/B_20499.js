const fs = require('fs');
let input = fs.readFileSync('B_20499.txt').toString().split('/');
var k = parseInt(input[0]);
var d = parseInt(input[1]);
var a = parseInt(input[2]);
if (k + a < d || d == 0) console.log("hasu");
else console.log("gosu");