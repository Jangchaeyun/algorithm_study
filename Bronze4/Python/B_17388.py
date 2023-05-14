s, k, h = map(int, input().split())
if s + h + k >= 100:
    print('OK')
else:
    if min(s, k, h) == s:
        print('Soongsil')
    elif min(s, k, h) == k:
        print('Korea')
    else:
        print('Hanyang')