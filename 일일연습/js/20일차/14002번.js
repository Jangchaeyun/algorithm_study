const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
let input = [];
rl.on('line', function (line) {
  input.push(line)
})
  .on('close', async function () {
  let arr = input[1].split(' ');
  let answer = max_sub_dp(arr);
  console.log(answer);
  process.exit();
});

function max_sub_dp(arr){
  let result_arr = JSON.parse(JSON.stringify(arr));  
  let max_sub = arr.reduce((acc,cur,idx,arry)=>{    
    let tmp = [];
    let index = [];
    for(let i = 0 ; i<idx+1;i++){      
      if(arry[i]<parseInt(cur)){
        tmp.push(acc[i]);
        index.push(i);
      }
    }    
    if(tmp.length>0){
      let max = Math.max(...tmp);
      acc[idx] += max;
      
      let k = index[tmp.indexOf(max)];      
      result_arr[idx] =  result_arr[k]+' '+result_arr[idx];
    } 
    return acc;
  },Array(arr.length).fill(1));     
  return Math.max(...max_sub)+'\n'+result_arr[max_sub.indexOf(Math.max(...max_sub))];
}