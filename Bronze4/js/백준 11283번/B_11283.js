const fs = require('fs');

const input = fs.readFileSync("B_11283.txt").toString().trim();

const answer = input.charCodeAt() - 44031;

console.log(answer);