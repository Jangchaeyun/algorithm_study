const fs = require('fs');
const filePath = 'B_24883.txt'
let input = fs.readFileSync(filePath).toString().split('\n');
const word = input[0];

const alpha = function (words) {
    words.toLowerCase() === 'n' ? console.log("Naver D2") : console.log("Naver Whale");
}

alpha(word);