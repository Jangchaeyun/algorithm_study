num = int(input())

for i in range(num):
    numShips, shipSpeed, numDays = map(int, input().split())

    ducats = 0
    for j in range(numShips):
        shipDistance, numDucats = map(int, input().split())

        if (numDays * shipSpeed >= shipDistance):
            ducats = ducats + numDucats

    format_ = f"Data Set {i + 1}:"
    print(format_); print(ducats); print();