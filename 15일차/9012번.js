const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const len = input.shift();
const result = [];

function removeStr(str) {
     const resultStr = str.replace(/\(\)/g, '');

     if (str.length !== resultStr.length) {
          return removeStr(resultStr);
     }

     return str[0] === ")" || str[str.length - 1] === "(" ? "NO" : "YES";
}

for (let i = 0; i < len; i++) {
     result.push(removeStr(input[i]));
}

console.log(result.join('\n'));