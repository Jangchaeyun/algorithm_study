const fs = require('fs');

const input = fs.readFileSync("B_15439.txt").toString().trim();

const answer = Number(input);

console.log(answer * (answer - 1));