const fs = require("fs");

const input = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(BigInt);

const appleAllCount = input[0];
const claudiaCount = input[1];

let cluadia = (appleAllCount + claudiaCount) / 2n;
let natalia = (appleAllCount - claudiaCount) / 2n;

console.log(`${cluadia}\n${natalia}`);
