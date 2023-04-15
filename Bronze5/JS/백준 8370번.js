const fs = require("fs");

const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((i) => Number(i));

let n1 = input[0];
let k1 = input[1];
let n2 = input[2];
let k2 = input[3];

console.log(n1 * k1 + n2 * k2);
