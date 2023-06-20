number = 0

while True:
    n = int(input())
    number += 1
    if n == 0:
        break
    if n % 2 != 0:
        print(number, ". odd ", n // 2, sep='')
    else:
        print(number, ". even ", n // 2, sep='')