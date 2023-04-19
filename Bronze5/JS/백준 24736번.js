var fs = require("fs");
var score = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
var teamA = score[0]
  .toString()
  .trim()
  .split(" ")
  .map((v) => +v);
var teamB = score[1]
  .toString()
  .trim()
  .split(" ")
  .map((v) => +v);
var scoreA,
  scoreB = 0;

scoreA =
  teamA[0] * 6 + teamA[1] * 3 + teamA[2] * 2 + teamA[3] * 1 + teamA[4] * 2;
scoreB =
  teamB[0] * 6 + teamB[1] * 3 + teamB[2] * 2 + teamB[3] * 1 + teamB[4] * 2;

console.log(scoreA + " " + scoreB);
