import sys

ls = [120, 24, 6, 2, 1]
while True:
    n = sys.stdin.readline().rstrip()
    if n == "0":
        break
    tmp = f"{n:0>5}"
    result = 0
    for i in range(5):
        result += int(tmp[i]) * ls[i]
    print(result)