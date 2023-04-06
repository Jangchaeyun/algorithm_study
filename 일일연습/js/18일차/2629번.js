"use strict";
const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n")

const N_w = Number(input[0])
const weight = [0].concat(input[1].split(" ").map(Number))
const N_b = Number(input[2])
const ball = input[3].split(" ").map(Number)

const knapsack = []
let max_ball = 0;

for (let i=1; i<N_w+1; i++){
    max_ball += weight[i];
}

for (let i=0; i<N_w+1; i++){
    knapsack.push(Array.from({length: max_ball+1}, (v, i) => ("N")));
}

for (let row=1; row<N_w+1; row++){
    for (let col=1; col<max_ball+1; col++){
        if (knapsack[row-1][col] === "Y"){
            knapsack[row][col] = "Y";
        }else if (weight[row] === col){
            knapsack[row][col] = "Y";
        }else{
            const a = knapsack[row][col] = knapsack[row-1][Math.abs(weight[row]-col)];
            const b = knapsack[row][col] = knapsack[row-1][weight[row]+col];
            if (a === "Y" | b === "Y"){
                knapsack[row][col] = "Y";
            }else{
                knapsack[row][col] = "N";
            }
        }
    }
}

const result = [];
for (let i=0; i<ball.length; i++){
    const request = ball[i];
    
    if (request > max_ball){
        result.push("N");
    }else{
        result.push(knapsack[N_w][request]);
    }
}

console.log(result.join(" "));
for (let i=0; i<N_w+1; i++){
    console.log(knapsack[i]);
}