const fs = require('fs');

const input = fs.readFileSync("B_10101.txt").toString().trim().split('\n').map(Number);

const answer = input => {
    const sum = input.reduce((acc, cur) => acc + cur);

    if (sum !== 180) return 'Error';

    const set = new Set(input);

    if (set.size === 1) return 'Equilateral';
    if (set.size === 2) return 'Isosceles';
    if (set.size === 3) return 'Scalene';
}

console.log(answer(input));