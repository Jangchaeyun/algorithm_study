const fs = require("fs");

const N = fs.readFileSync("/dev/stdin").toString().trim();

const answer = N == 0 ? "YONSEI" : "Leading the Way to the Future";

console.log(answer);
