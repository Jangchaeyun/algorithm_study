const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
//const input = ['2','6 12 10','30 50 72'];
const A = parseInt(input.shift());// 첫번째 값 제거

for(let i = 0 ;i <A; i++){
   const arr= input[i].split(' ')
   const H = parseInt(arr[0]);
   const N = parseInt(arr[2]);
   if(N % H === 0){//꼭대기층
      fl = H; 
      ho = N / H;
   }else if(N % H !== 0){
    fl = N % H;
    ho = Math.floor(N / H)+1;
  }
  if(ho < 10){ho = `0${ho}`;}
   console.log(`${fl}${ho}`);
 
}