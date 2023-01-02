const readline = require('readline');
const rl = readline.createInterface({
    input : process.stdin,
    output : process.stdout
});

let count = 2;
const input = [];
rl.on('line', function (line) {
     input.push(line.split(''));
     count--;
     if (count === 0) rl.close();
}).on('close', function () {
     const n = input[0].length;
     const m = input[1].length;
     const IcsArray = Array.from(Array(n + 1), () => new Array(m + 1).fill(0));
     for (let i = 0; i < n; i++) {
          const char = input[0][i];
          for (let j = 0; j < m; j++) {
               if (char === input[1][j]) {
                    IcsArray[i + 1][j + 1] = IcsArray[i][j] + 1;
               } else {
                    IcsArray[i + 1][j + 1] = Math.max(IcsArray[i][j+1], IcsArray[i+1][j]);
               }
          }
     }
     console.log(IcsArray[n][m]);
})