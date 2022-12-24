const fs = require('fs');
const readFileSyncAddress = '/dev/stdin';
let input = fs.readFileSync(readFileSyncAddress).toString().trim().split('\n');

function solution(input) {
    [n, ...person] = input;
    let count = [];

    for (let i = 0; i < n; i++) {
        let rank = 0;
        for (let j = 0; j < n; j++) {
            if (i === j) continue;
            [aWeight, aTall] = person[i].split(' ');
            [bWeight, bTall] = person[j].split(' ');

            if (Number(aWeight) < Number(bWeight) && Number(aTall) < Number(bTall))
                rank += 1;
        }
        count.push(rank + 1);
    }
    return count.join(' ');
}

console.log(solution(input));