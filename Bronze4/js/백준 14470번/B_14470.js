const fs = require('fs');

const [A, B, C, D, E] = fs.readFileSync("B_14470.txt").toString().trim().split('\n').map(Number);

if (A < 0) {
    const absA = Math.abs(A);
    console.log((absA * C) + D + (B * E));
}

if (A > 0) {
    const seconds = B - A;
    console.log(seconds * E);
}