const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n').map(Number);
const test = input[0];
const isPrime = (n) => {
    if (n === 1) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}

for (i = 1; i <= test; i++) {
    let num = input[i];
    let primeArr = [];
    for (j = 2; j < num; j++) {
        if (isPrime(j)) {
            primeArr.push(j);
        }
    }
    let ans = [];
    for (k = 0; primeArr[k] < num / 2 + 1; k++) {
        if (isPrime(num - primeArr[k])) {
            ans.push([primeArr[k], num - primeArr[k]]);
        }
    }
    let a = ans.pop();
    console.log(`${a[0]} ${a[1]}`);
}