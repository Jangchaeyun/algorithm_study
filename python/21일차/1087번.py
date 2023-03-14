import sys; input = sys.stdin.readline

def f(t):
    points = []
    for px, py, vx, vy in mouse:
        points.append([px + vx * t, py + vy * t])

    points.sort()
    result = points[-1][0] - points[0][0]

    points.sort(key = lambda x: x[1])
    result = max(result, points[-1][1] - points[0][1]) 
    return result

N = int(input())
mouse = [list(map(int, input().split())) for _ in range(N)]

start = 0; end = 2000

for _ in range(500):
    mid_1 = (start * 2 + end) / 3
    mid_2 = (start + end * 2) / 3
    if f(mid_1) <= f(mid_2):
        end = mid_2
    else:
        start = mid_1

print(f(start))