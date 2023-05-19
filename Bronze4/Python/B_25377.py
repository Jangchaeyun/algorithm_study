inf = 100000000
ans = inf

for i in range(int(input())):
    x, y = map(int, input().split())

    if x <= y:
        ans = min(ans, y)

if ans == inf:
    print(-1)

else:
    print(ans)