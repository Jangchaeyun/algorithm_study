let [a, b] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
console.log(a - (a / 100) * b >= 100 ? 0 : 1);
