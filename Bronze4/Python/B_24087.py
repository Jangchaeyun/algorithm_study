S = int(input())
A = int(input())
B = int(input())

if S <= A:
    print(250)
else:
    print(250 + ((S-A)//B)*100 if ((S-A)//B) == ((S-A)/B) else 250+((S-A)//B + 1) * 100)