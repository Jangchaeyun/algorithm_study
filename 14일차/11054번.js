     const fs = require("fs");
     const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
     let input = fs.readFileSync(filePath).toString().trim().split("\n");

     const n = input[0];
     const nums = input[1].split(" ").map(Number);

     const increaseDp = new Array(n).fill(1);
     const decreaseDp = new Array(n).fill(1);

     for (let i = 0; i < n; i++) {
          const cur = nums[i];
          let cnt = 1;
          for (let j = 0; j < i; j++) {
               const compare = nums[j];
               if (cur > compare) cnt = Math.max(cnt, increaseDp[j] + 1);
          }
          increaseDp[i] = cnt;
     }

     for (let i = n - 1; i >= 0; i--) {
          const cur = nums[i];
          let cnt = 1;
          for (let j = i + 1; j < n; j++) {
               const compare = nums[j];
               if (cur > compare) cnt = Math.max(cnt, decreaseDp[j] + 1);
          }
          decreaseDp[i] = cnt;
     }

     console.log(Math.max(...increaseDp.map((incVal, index) => incVal + decreaseDp[index])) - 1);