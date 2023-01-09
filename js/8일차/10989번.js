const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = +input[0];
const nums = [];
for (let i = 1; i <= n; i++) {
    nums.push(+input[i]);
}

const countNums = Array.from({ length: 10001 }, () => 0);

nums.forEach((v) => {
    countNums[v]++;
});

let print = "";
for (let u = 1; i < countNums.length; i++) {
    const num = i;
    const count = countNums[i];
    if (count > 0) {
        print += (num + "\n").repeat(count);
    }
}

console.log(print.trim());