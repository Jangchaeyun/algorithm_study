const fs = require('fs');

const [A, B] = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

const [B0, B1, B2] = B.split('');

const temp1 = A * B2;
const temp2 = A * B1;
const temp3 = A * B0;
const sum = temp1 + Number(`${temp2}0`) + Number(`${temp3}00`);

console.log(`${temp1}\n${temp2}\n${temp3}\n${sum}`)