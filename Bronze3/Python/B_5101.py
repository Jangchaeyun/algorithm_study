while True:
    start, dif, target = map(int, input().split())

    if start == dif == target == 0:
        break

    if ((dif > 0 and target <= start) or (dif < 0 and target >= start)):
        print('X')
    elif (target - start) % dif == 0:
        print((target - start) // dif + 1)
    else:
        print('X')
