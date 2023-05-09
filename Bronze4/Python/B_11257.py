num = int(input())

for i in range(num):
    a, b, c, d = map(int, input().split())

    sum_ = b + c + d
    if sum_ < 55:
        str_ = f"{a} {sum_} FAIL"
        print(str_)
    elif b / 35 < 0.3:
        str_ = f"{a} {sum_} FAIL"
        print(str_)
    elif c / 25 < 0.3:
        str_ = f"{a} {sum_} FAIL"
        print(str_)
    elif d / 40 < 0.3:
        str_ = f"{a} {sum_} FAIL"
        print(str_)
    elif d / 40 >= 0.3 and c / 25 >= 0.3 and b / 35 >= 0.3:
        str_ = f"{a} {sum_} PASS"
        print(str_) 
