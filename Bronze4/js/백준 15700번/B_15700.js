const fs = require('fs');

const [N, M] = fs.readFileSync("B_15700.txt").toString().trim().split(' ').map(BigInt);

const answer = BigInt(N * M / 2n);

console.log(answer.toString());