var fs = require("fs");

const stdin = fs.readFileSync("/dev/stdin").toString().split("\n");

let caseNum = stdin[0];
let caseAry = [];
let curIdx = 1;

while (caseNum > 0) {
  let temp = {};
  temp.infoAry = stdin[curIdx].split(" ").map(Number);
  temp.buildTimes = stdin[curIdx + 1].split(" ").map(Number);
  temp.buildTimes.unshift(0);
  let edges = [];
  for (let j = 0; j < temp.infoAry[1]; j++) {
    edges[j] = stdin[curIdx + 2 + j].split(" ").map(Number);
  }
  temp.edges = edges;
  temp.target = Number(stdin[curIdx + 3 + temp.infoAry[1] - 1]);

  caseAry.push(temp);
  curIdx = curIdx + 3 + temp.infoAry[1];
  caseNum--;
}

function compTime(caseObj) {
  let endPointAry = new Array(caseObj.infoAry[0] + 1).fill(0);
  let map = [];
  for (let i = 0; i < caseObj.infoAry[0] + 1; i++) {
    map.push([]);
  }

  for (let i = 0; i < caseObj.edges.length; i++) {
    map[caseObj.edges[i][0]].push([caseObj.edges[i][1]]);
    endPointAry[caseObj.edges[i][1]]++;
  }

  let queue = [];
  let visited = [...caseObj.buildTimes];
  for (let i = 1; i < endPointAry.length; i++) {
    if (endPointAry[i] === 0) queue.push(i);
  }

  while (queue.length > 0) {
    let curbuilding = queue.shift();

    map[curbuilding].forEach((nextNode) => {
      visited[nextNode] = Math.max(
        visited[nextNode],
        visited[curbuilding] + caseObj.buildTimes[nextNode]
      );
      endPointAry[nextNode]--;

      if (endPointAry[nextNode] === 0) queue.push(nextNode);
    });
  }

  return visited[caseObj.target];
}

caseAry.forEach((obj) => {
  console.log(compTime(obj));
});
