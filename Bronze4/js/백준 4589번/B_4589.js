const input = require('fs').readFileSync('B_4589.txt').toString().split('\n');

const inputNum = input[0];
console.log('Gnomes:');

for (let i = 1; i <= inputNum; i++) {
    input[i] = input[i].split(' ').map(x => +x);
    const arr = [...input[i]];

    if (JSON.stringify(arr) === JSON.stringify(input[i].sort((a, b) => a - b))) {
        console.log('Ordered');
    } else if (
        JSON.stringify(arr) === JSON.stringify(input[i].sort((a, b) => b - a))
    ) {
        console.log('Ordered');
    } else {
        console.log('Unordered');
    }
}