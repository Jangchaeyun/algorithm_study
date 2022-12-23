const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let N = Number(input.shift());
let numArr = [];
for (let i = 0; i < N; i++) {
    numArr.push(input[i].trim().split(' ').map(x => +x))
}
let answer = '';

numArr.sort((a, b) => {
    if (a[1] === b[1]) { return a[0] - b[0]; }
    else { return a[1] - b[1]; }
})

numArr.forEach(e => {
    answer += e[0] + ' ' + e[1] + '\n'
})
console.log(answer)