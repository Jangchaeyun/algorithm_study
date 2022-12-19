const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(input[0]);

for(let i=1; i<=n; i++){
    let count = 1;
    let sum = 0;
    
    for(let j=0; j<input[i].length; j++){
        if(input[i][j]==="O"){
            sum+=count;
            count++;
        }else{
            count = 1;
        }
    }
    console.log(sum);
}