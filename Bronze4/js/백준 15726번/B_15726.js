const fs = require('fs');
const [A, B, C] = fs.readFileSync("B_15726.txt").toString().trim().split(' ').map(Number);

const answer = parseInt(Math.max((A * B) / C, (A / B) * C))

console.log(answer);