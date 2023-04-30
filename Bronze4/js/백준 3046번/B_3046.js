const fs = require('fs');

const input = fs.readFileSync('B_3046.txt').toString().trim().split(" ").map(Number);

let answer = input[1] * 2 - input[0];

console.log(answer);