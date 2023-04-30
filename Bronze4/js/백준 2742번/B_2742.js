let input = Number(require('fs').readFileSync('B_2742.txt').toString());

let answer = '';

for (let i = input; i >= 1; i--) {
    answer += i + "\n";
}

console.log(answer);