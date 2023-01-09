const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = Number(input.shift());
let arr = input[0].split(' ').map(x => +x);

let set = new Set(arr);
let uniq = [...set].sort((a, b) => a - b);

let dic = {};
uniq.forEach((e, index) => { dic[e] = index; })
let answer = '';
for (let i = 0; i < arr.length; i++) {
    answer += dic[arr[i]] + ' ';
}

console.log(answer);