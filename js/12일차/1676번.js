var fs = require('fs');
var inputs = fs.readFileSync('/dev/stdin').toString();
inputs = Number(inputs);
var answer = 0;
while (inputs >= 5) {
     answer += parseInt(inputs / 5);
     inputs /= 5;
}

console.log(answer);