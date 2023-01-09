const readline = require('readline');
const rl = readline.createInterface(
    {input: process.stdin, output: process.stdout}
);
let input = [];
rl
    .on('line', function (line) {
        input.push(line)
    })
    .on('close', async function () {
        let answer = '';
        let n = input.splice(0, 1);
        for (let i = 0; i < n; i++) {
            input[i] = input[i].split(' ');
        }
        answer = int_angle(n, input);
        console.log(answer)
        process.exit();
    });

function int_angle(n, arr) {
    let dp = [];
    for (let i = 0; i < n; i++) {
        let tmp = new Array(3 + i).fill(0);
        dp.push(tmp);
    }
    dp[0][1] = arr[0][0];
    for (let i = 1; i < n; i++) {
        for (let j = 1; j <= (i + 1); j++) {
            dp[i][j] = arr[i][j - 1] * 1 + Math.max(dp[i - 1][j], dp[i - 1][j - 1])
        }
    }
    return Math.max(...dp[n - 1]);
}