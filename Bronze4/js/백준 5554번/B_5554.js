const fs = require('fs');

let answer = 0;

const input = fs.readFileSync('B_5554.txt').toString().trim().split('\n').map(i => answer += Number(i));

let minute = parseInt(answer / 60);
let second = parseInt(answer % 60);

let ans = `${minute}\n${second}`;

console.log(ans);