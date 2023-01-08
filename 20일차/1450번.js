const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split('\n');
const [N, S] = input[0].split(' ').map(v => +v);
const B = input[1].split(' ').map(v => +v);
const A = [];
for (let i = 0; i < Math.ceil(N / 2); i++) {
  A.push(B.shift())
}
const sumA = subsetSum(A).sort((a, b) => a - b)
const sumB = subsetSum(B)

function subsetSum(arr) {
  let result = [];
  let len = arr.length;
  for (let i = 0; i < (1 << len); i++) {
    let sum = 0;
    for (let j = 0; j < len; j++) {
      if (i & (1 << j)) {
        sum += arr[j]
      }
    }
    result.push(sum)
  }
  return result
}


let answer = 0;
for (let i = 0; i < sumB.length; i++) {
  if (sumB[i] > S) continue;
  let min = 0;
  let max = sumA.length;
  while (min < max) {
    let mid = Math.floor((min + max) / 2);
    if (sumA[mid] + sumB[i] <= S) {
      min = mid + 1;
    } else {
      max = mid;
    }
  }

  answer += max;
}

console.log(answer)