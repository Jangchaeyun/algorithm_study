const fs = require('fs');

const input = fs.readFileSync('B_2845.txt').toString().trim().split('\n');

const input1 = input[0].split(' ').map(Number);
const input2 = input[1].split(' ').map(Number);

const people = input1[0];
const area = input1[1];

const answer = input2.map(i => i - (people * area));

console.log(...answer);