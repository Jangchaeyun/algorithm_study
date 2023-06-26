n = int(input())
m = int(input())
lst1 = [input() for _ in range(n)]
lst2 = [input() for _ in range(m)]
for i in lst1:
    for j in lst2:
        print(i, "as", j)
