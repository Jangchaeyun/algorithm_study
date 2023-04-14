const fs = require("fs");
let answer = 0;
const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((i) => (answer += Math.pow(Number(i), 2)));
answer = answer % 10;
console.log(answer);
