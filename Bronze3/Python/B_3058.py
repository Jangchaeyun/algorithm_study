x = int(input())

for i in range(x):
    even_sum = []
    a = list(map(int, input().split()))
    for i in a:
        if i % 2 == 0:
            even_sum.append(i)
    print(sum(even_sum), min(even_sum))
