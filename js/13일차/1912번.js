const readline = require('readline');
const rl = readline.createInterface({
     input: process.stdin,
     output: process.stdout
});
let input = [];
rl.on('line', function (line) {
     input.push(line)
})

     .on('close', async function () {
          let arr = input[1].split(' ');
          let answer = max_sum_dp(arr);
          console.log(answer);
          process.exit();
     }); 

function max_sum_dp(arr) {
     let result = arr[0];
     for (let i = 1; i < arr.length; i++) {
          arr[i] = Math.max(arr[i] * 1, arr[i] * 1 + arr[i - 1] * 1);
          result = Math.max(arr[i], result);
     }
     return result;
}