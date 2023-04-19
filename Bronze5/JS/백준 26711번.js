const path = "/dev/stdin";

const input = require("fs").readFileSync(path).toString().trim().split("\n");
let [A, B] = input;

let result = "";
let carry = 0;

A = A.padStart(B.length, "0");
B = B.padStart(A.length, "0");

for (let i = A.length - 1; i >= 0; i--) {
  const sum = parseInt(A[i]) + parseInt(B[i]) + carry;
  result = (sum % 10) + result;
  carry = Math.floor(sum / 10);
}

if (carry > 0) {
  result = carry + result;
}

console.log(result);
