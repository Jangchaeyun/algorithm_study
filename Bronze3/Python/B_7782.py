n = int(input())
b1, b2 = map(int, input().split())
for _ in range(n):
    a, b, c, d = map(int, input().split())
    if a <= b1 and c >= b1 and b <= b2 and d >= b2:
        print("Yes")
        exit(0)
print("No")