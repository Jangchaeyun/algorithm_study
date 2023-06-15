num = 0
result = []

for i in range(1, 11):
    down, up = list(map(int, input().split()))
    num = num - down + up
    result.append(num)

result.sort()
print(result[-1])