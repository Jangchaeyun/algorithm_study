a, b, c = map(int, input().split())
envelop = 229 * 324 * a * 2
poster = 297 * 420 * b * 2
sheet = 210 * 297 * c

print("{:.6f}".format((envelop + poster + sheet) * 0.000001))