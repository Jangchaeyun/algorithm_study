a, b, c, d = map(int, input().split())

if (a * 60 + b) > (c * 60 + d):
    c = c + 24
    time_ = (c * 60 + d) - (a * 60 + b)
print(time_, time_//30)