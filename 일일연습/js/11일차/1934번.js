const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const iter = Number(input.shift());

let ans = [];

for (let i = 0; i < iter; i++) {
   let [a, b] = input[i].split(" ").map((item) => Number(item));

   let originala = a;
   let originalb = b;

   while (a % b !== 0) {
      let r = a % b;

      if (r !== 0) {
         a = b;
         b = r;
      }
   }

   let min = originala * originalb / b;
   ans.push(min);
}

console.log(ans.join("\n"));