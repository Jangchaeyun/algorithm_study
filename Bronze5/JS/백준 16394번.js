const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim();

const schollBirthday = 1946;
console.log(Number(input) - schollBirthday);
