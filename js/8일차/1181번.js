const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

solution(input);

function solution(inputArr) {
    let answer = [];
    let arr = inputArr;
    arr.shift();
    
    arr = Array.from(new Set(arr));

    let sorted = arr.sort((a, b) => {
        if (a.length !== b.length) {
            return a.length - b.length;
        }
    });
    for (let i = 1; i <= sorted[sorted.length - 1].length; i++) {
        let temp = sorted.filter((el) => el.length === i);
        answer.push(...temp.sort());
    }
    for (let word of answer) {
        console.log(word);
    }
}