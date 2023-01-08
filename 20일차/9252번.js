const input = require("fs")
  .readFileSync("./dev/stdin")
  .toString()
  .trim()
  .split("\n");

let str1 = input[0].split("");
let str2 = input[1].split("");

let stack = [];

let dy = Array.from(Array(input[0].length + 1), () =>
  Array(input[1].length + 1).fill(0)
);

for (let i = 1; i < str1.length + 1; i++) {
  for (let k = 1; k < str2.length + 1; k++) {
    if (str1[i - 1] === str2[k - 1]) {
      dy[i][k] = dy[i - 1][k - 1] + 1;
    } else {
      dy[i][k] = Math.max(dy[i - 1][k], dy[i][k - 1]);
    }
  }
}

let row = dy[0].length - 1;
let col = dy.length - 1;
while (row > 0 && col > 0) {
  if (dy[col][row] === dy[col - 1][row]) col--;
  else if (dy[col][row] === dy[col][row - 1]) row--;
  else {
    stack.unshift(str1[col - 1]);
    row--;
    col--;
  }
}

console.log(dy[dy.length - 1][dy[0].length - 1]);
console.log(stack.join(""));