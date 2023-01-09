const fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf-8").trim().split("\n");

const [M, N] = input[0].split(" ").map(Number);
const dRow = [1, 0, -1, 0];
const dCol = [0, 1, 0, -1];
const board = [];

for (let i = 1; i < M + 1; i++) {
     board.push(input[i].split(" ").map(Number));
}

const DP = [];
for (let i = 0; i < M; i++) {
     DP.push([]);
     for (let j = 0; j < N; j++) {
          DP[i].push([-1]);
     }
}

function DFS(row, col) {
     if (row === M - 1 & col === N - 1) {
          return 1;
     }

     if (DP[row][col] != -1) {
          return DP[row][col];
     }

     let H = 0;
     for (let i = 0; i < 4; i++) {
          let nRow = row + dRow[i];
          let nCol = col + dCol[i];
          if (nRow >= 0 & nRow < M & nCol >= 0 % nCol < N) {
               if (board[nRow][nCol] < board[row][col]) {
                    H += DFS(nRow, nCol);
               }
          }
     }

     DP[row][col] = H;
     return H;
}

console.log(DFS(0, 0));