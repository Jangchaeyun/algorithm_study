let fs = require("fs");
let knapsack = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = Number(knapsack[0].split(" ")[0]);
const K = Number(knapsack[0].split(" ")[1]);

knapsack = knapsack.map((element) => element.trim().split(" ").map((value) => Number(value)));
const weight = [];
const value = [];
for (let n = 0; n <= N; n++) {
     weight.push(knapsack[n][0]);
     value.push(knapsack[n][1]);
}

const dp = Array.from(new Array(N + 1), () => new Array(K + 1));

for (let i = 0; i <= N; i++) {
     dp[i][0] = 0;
}
for (let j = 0; j <= K; j++) {
     dp[0][j] = 0;
}
for (let j = 1; j <= K; j++) {
     if (knapsack[1][0] <= j) {
          dp[1][j] = knapsack[1][1];
     } else {
          dp[1][j] = 0;
     }
}

for (let i = 2; i <= N; i++) {
     for (let j = 1; j <= K; j++) {
          if (j < weight[i]) {
               dp[i][j] = dp[i - 1][j];
          } else {
               dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
          }
     }
} 
console.log(dp[N][K])