let fs = require('fs');
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
input[0] = input[0].split(" ");
const cards = input[1].split(" ").map((element) => Number(element));
const N = Number(input[0][0]);
const M = Number(input[0][1]);
let answer = 0;

const getCombinations = (array, selectNumber) => {
    const results = [];
    if (selectNumber === 1) {
        return array.map((element) => [element]);
    }
    array.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1);
        const combinations = getCombinations(rest, selectNumber - 1);
        const attached = combinations.map((combination) => [fixed, ...combination]);
        results.push(...attached)
    });
    return results;
}

getCombinations(cards, 3).forEach((element) => {
    let sum = element[0] + element[1] + element[2];
    let gap = M - sum;
    if (gap >= 0 && answer <= sum) {
        answer = sum;
    }
});

console.log(answer)