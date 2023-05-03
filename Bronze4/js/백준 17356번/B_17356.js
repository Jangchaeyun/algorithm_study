const wookje = () => {
    let [w, j] = require("fs")
        .readFileSync("B_17356.txt")
        .toString()
        .split(" ")
        .map(Number);
    console.log(1 / (1 + Math.pow(10, (j - w) / 400)));
};

wookje();