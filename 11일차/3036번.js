const fs = require('fs');
const [_, input] = fs.readFileSync("./dev/stdin").toString().trim().split('\n');

const nums = input.split(' ').map(v => +v);
let first = nums.shift();

nums.forEach(v => {
   const gcd = GCD(first, v);
   console.log((first / gcd) + '/' + (v / gcd))
})

function GCD(a, b) {
   let x;
   let y;
   if (a > b) {
      x = a; y = b;
   } else {
      x = b; y = a;
   }
   let r;
   while (y != 0) {
      r = x % y;
      x = y;
      y = r;
   }
   return x;
}