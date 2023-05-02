const fs = require('fs');

const [A, B, C, D, E, F] = fs.readFileSync("B_11948.txt").toString().trim().split('\n');
const science = [A, B, C, D].sort((a, b) => b - a).map(Number);
const society = [E, F].sort((a, b) => b - a).map(Number);

science.pop();
society.pop();

const answer = science.reduce((acc, cur) => acc + cur) + society[0];

console.log(answer);