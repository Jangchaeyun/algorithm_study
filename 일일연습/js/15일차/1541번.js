function solution(list) {
     let tmp = [];

     for (i of list) {
          let cnt = 0;
          let s = i.split("+")
          for (j of s) {
               cnt += parseInt(j);
          }
          tmp.push(cnt);
     }
     let result = tmp[0];

     for (let j = 1; j < tmp.length; j++) {
          result -= tmp[j];
     }
     console.log(result);
}

const { timeStamp } = require("console");
const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input;
rl.on("line", function (line) {
    input = line;
    rl.close();
}).on("close", function () {
    //-기준으로 문자열 분리
    let list = input.split('-');
    solution(list);
});