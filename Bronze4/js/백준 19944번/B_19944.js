const fs = require('fs');
let ip = fs.readFileSync('B_19944.txt').toString().split(' ');
n = parseInt(ip[0])
m = parseInt(ip[1])
if (m == 1 || m == 2) console.log("NEWBIE!");
else if (m <= n) console.log("OLDBIE!");
else console.log("TLE!");