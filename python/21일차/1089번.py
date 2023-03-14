import sys
input = sys.stdin.readline
n = int(input())
g = [list(map(str, list(input().strip()))) for _ in range(5)]
numOfNum = [0 for _ in range(n)]
sumOfNum = [0 for _ in range(n)]
totalNum = 1
ans = 0

numHt = { 0 : [[1, 1], [2, 1], [3, 1]],
          1 : [[0, 0], [0, 1], [1, 0], [1, 1], [2, 0], [2, 1], [3, 0], [3, 1], [4, 0], [4, 1]],
          2 : [[1, 0], [1, 1], [3, 1], [3, 2]],
          3 : [[1, 0], [1, 1], [3, 0], [3, 1]],
          4 : [[0, 1], [1, 1], [3, 0], [3, 1], [4, 0], [4, 1]],
          5 : [[1, 1], [1, 2], [3, 0], [3, 1]],
          6 : [[1, 1], [1, 2], [3, 1]],
          7 : [[1, 0], [1, 1], [2, 0], [2, 1], [3, 0], [3, 1], [4, 0], [4, 1]],
          8 : [[1, 1], [3, 1]],
          9 : [[1, 1], [3, 1], [3, 0]]
}

nj = 0
for idx in range(n):
    for num in range(10):
        numValueArr = numHt[num]
        cnt = 0 
        for i, j in numValueArr:
            j = nj + j
            if g[i][j] == '.':
                cnt += 1
            if cnt == len(numValueArr):
                sumOfNum[idx] += num * (10 ** (n - idx - 1))
                numOfNum[idx] += 1
    nj = nj + 4

for i in range(n):
    numSum = 1
    for j in range(n):
        if i != j:
            numSum *= numOfNum[j]
        if i == 0:
            totalNum *= numOfNum[j]
    ans += sumOfNum[i] * numSum

if totalNum == 0:
    print(-1)
    exit(0)
print(ans / totalNum)