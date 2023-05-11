def recur(a):
    s = str(a)
    if (a == int(s[0]) * len(s)):
        return "FA"
    return recur(int(s[0]) * len(s))
x = int(input())
print(recur(x))