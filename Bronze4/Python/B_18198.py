scoreboard = input()
A_Sum = 0
B_Sum = 0

for i in range(len(scoreboard)):
    if scoreboard[i] == "A":
        A_Sum = A_Sum + int(scoreboard[i+1])
    elif scoreboard[i] == "B":
        B_Sum = B_Sum + int(scoreboard[i+1])
print("A" if A_Sum > B_Sum else "B")