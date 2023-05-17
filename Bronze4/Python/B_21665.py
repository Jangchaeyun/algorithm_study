count = 0
N, M = map(int, input().split())
lst = list(range(0, M, 1))
lst_0 = []
for i in range(N):
    lst_0.append(input())
input()
lst_1 = []
for i in range(N):
    lst_1.append(input())

for x, y in zip(lst_0, lst_1):
    for i in range(M):
        if x[i] == y[i]:
            count = count + 1

print(count)