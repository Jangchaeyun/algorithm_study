const fs = require('fs');

const [R, C, N] = fs.readFileSync('B_13136.txt').toString().trim().split(' ').map(Number);

const cctv1 = Math.ceil(R / N);
const cctv2 = Math.ceil(C / N);

console.log(cctv1 * cctv2);