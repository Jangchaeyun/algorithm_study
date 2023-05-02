const fs = require('fs');

const [S, T, D] = fs.readFileSync("B_14924.txt").toString().trim().split(" ").map(Number);

console.log(D / (S * 2) * T);