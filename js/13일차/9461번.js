const fs = require('fs');
const [ T, ...inputs ] = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(num => parseInt(num));

const padovan = [ 1, 1, 1, 2, 2, 3, 4, 5 ];
const max = Math.max(...inputs);

for(let i = padovan.length; i < max; i++) {
  const push = padovan[(i - 1)] + padovan[(i - 5)];
  padovan.push(push);
}

inputs.forEach((num) => {
  console.log(padovan[(num - 1)]);
});