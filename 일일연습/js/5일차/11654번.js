const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim();

const answer = input.charCodeAt();

console.log(answer)