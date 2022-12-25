const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().split('\n');

const inputZero = input[0].split(' ').map((num) => Number(num));
const n = inputZero[0];
const m = inputZero[1];

let map = new Map();
let mapRevere = new Map();

for (let i = 1; i <= n; i++) {
     map.set(i, input[i].trim());
     mapRevere.set(input[i].trim(), i);
}
for (let i = 1; i <= m; i++) {
     if (map.has(Number(input[i + n]))) {
          console.log(map.get(Number(input[i + n])));
     } else {
          console.log(mapRevere.get(input[i + n].trim()));
     }
}