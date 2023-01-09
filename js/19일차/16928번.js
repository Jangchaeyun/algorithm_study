function sol(borad){
     let visited = new Array(101).fill(-1);
   
     let q = [];
     q.push(1); 
     visited[1] = 0;
   
     while(q.length !== 0){
       let cur = q.shift();
       
       for(let dice=1; dice<=6; dice++){
         let next = cur + dice;
         
         if(next > 100)
           continue;    
   
         next = borad[next];
         if(visited[next] === -1){
           visited[next] = visited[cur] + 1;
           q.push(next);
         }  
       }
     }
     console.log(visited[100]);
   }
   
   function insert(){
     const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
     const [n,m] = input[0].split(' ').map(Number);
     
     let board = new Array(101).fill(null).map((_,idx) => idx);  
     
     for(let i=1; i<=n+m; i++){
       let [from,to] = input[i].split(' ').map(Number);
       board[from] = to;
     }  
   
     sol(board);
   }
   insert();