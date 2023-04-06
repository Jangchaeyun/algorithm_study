const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
let input = [];
let list = [];
let result = [];
let check = new Array(9).fill(false);
rl.on('line', function (line) {
  input.push(line);
})
  .on('close', async function () {
  let answer =0;
  
  input = input[0].split(' ');
  let n = input[0];
  let m = input[1];
  re(0,n,m,0);  
  console.log(result.join('\n'));  
  process.exit();
});

let re = function(cnt,n,m,k){
  if(cnt==m){
    result.push(list.join(' '))
    return 1;
  }
  for(let i=1;i<=n;i++){
    if(!check[i] && k<i){
      check[i] = true;
      list[cnt] = i;
      k = i;
      re(cnt+1,n,m,k);
      check[i] = false;
    }
  }
  return 1;
}