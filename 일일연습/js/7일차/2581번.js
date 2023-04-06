const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let M = Number(input[0]); // 60
let N = Number(input[1]); // 100
let resultArr = [];
for (let i = M; i <= N; i++) {
    let count = 0;
    for (let j = 1; j <= i; j++) {
        if ((i % j) === 0) {
            count++;
        }
    }
    if (count === 2) {
        resultArr.push(i);
    }
}

if (resultArr.length !== 0) {
    let plus = resultArr.reduce((a,b) => {return a+b});
    let min = resultArr[0];
    for (let i = 0; i < resultArr.length; i++) {
        if (min > resultArr[i]) {
            min = resultArr[i];
        }
    }
    console.log(plus);
    console.log(min);
} else {
    console.log(-1)
}