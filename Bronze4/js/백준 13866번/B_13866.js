const fs = require('fs');

const [A, B, C, D] = fs.readFileSync("B_13866.txt").toString().trim().split(' ').map(Number);

const answer = Math.abs((A + D) - (B + C));
console.log(answer);