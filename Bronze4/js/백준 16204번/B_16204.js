const fs = require('fs');
let ip = fs.readFileSync('B_16204.txt').toString().split(' ');
n = parseInt(ip[0]);
m = parseInt(ip[1]);
k = parseInt(ip[2]);
console.log(Math.min(m, k) + Math.min(n - m, n - k));