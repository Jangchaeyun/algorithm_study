const fs = require('fs');

const [sum, substract] = fs.readFileSync("B_4299.txt").toString().trim().split(' ').map(Number);

const A = (sum + substract) / 2;
const B = sum - A;

if (A < 0 || B < 0 || Math.floor(A) !== A) {
    console.log(-1);
} else {
    console.log(A, B);
}