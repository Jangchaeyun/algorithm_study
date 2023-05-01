const fs = require('fs');

const input = fs.readFileSync("B_6749.txt").toString().trim().split("\n").map(i => Number(i));

let input1 = input[0];
let input2 = input[1];

console.log(input2 + (input2 - input1));