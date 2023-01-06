const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const iter = Number(input[0]);

input = input[1].split(" ").map((item) => Number(item));

let ans = new Array(iter).fill(-1);

let count = {};

input.forEach((x) => {
  count[x] = (count[x] || 0) + 1;
});

let stack = [];

for (let i = 0; i < iter; i++) {
    while (
        stack.length &&
        count[input[stack[stack.length - 1]]] < count[input[i]]
    ) {
        ans[stack.pop()] = input[i];
    }
    stack.push(i);
}

console.log(ans.join(" "));