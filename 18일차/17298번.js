const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let count = 2, n = 0;
let input = [];
rl.on('line', function (line) {
    count--;
    if (count === 1) {
        n = parseInt(line);
    }
    if (count === 0) {
        input = (line.split(' ').map((v) => parseInt(v)));
        rl.close();
    }

}).on('close', function () {
    const result = new Array(n).fill(-1);
    const stack = [];

    for (let i = 0; i < input.length; i++) {
        while (stack.length > 0 && input[stack[stack.length - 1]] < input[i]) {
            result[stack.pop()] = input[i];
        }
        stack.push(i);
    }

    console.log(result.join(' '));
    process.exit();
})