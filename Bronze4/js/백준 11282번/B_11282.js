const fs = require('fs');

const input = fs.readFileSync("B_11282.txt").toString().trim();
const answer = String.fromCharCode(Number(input) + 44031);

console.log(answer);