const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();

const N = parseInt(input)

let M = 0
for (let i = 0; i < N; i++) {
    let sum = 0;

    const cardidateValue = i;

    const stringValue = cardidateValue.toString()

    for (let j = 0; j < stringValue.length; j++) {
        sum += parseInt(stringValue[j])
    }

    sum += cardidateValue;

    if (sum == N) {
        M = cardidateValue
        break;
    }
}

console.log(M)