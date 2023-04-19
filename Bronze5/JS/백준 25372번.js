let [n, ...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let ans = [];
for (let pass of arr)
  ans.push(pass.length >= 6 && pass.length <= 9 ? "yes" : "no");
console.log(ans.join("\n"));
