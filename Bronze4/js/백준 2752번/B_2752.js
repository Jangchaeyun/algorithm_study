const fs = require('fs');

const input = fs.readFileSync("B_2752.txt").toString().trim().split(' ').map(Number).sort((a, b) => a - b);

console.log(...input);