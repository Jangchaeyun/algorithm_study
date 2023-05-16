axel, petra = map(int, input().split())

if axel * 7 == petra * 13:
    print("lika")
else:
    print("Petra" if axel * 7 < petra * 13 else "Axel")