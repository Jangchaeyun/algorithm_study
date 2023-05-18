Chicken = int(input())
Coke, Bear = map(int, input().split())
Eat = Coke//2 + Bear

if Chicken >= Eat:
    print(Eat)
else:
    print(Chicken)