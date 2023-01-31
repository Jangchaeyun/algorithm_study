#include<stdio.h>
#define SZ 101
#define QUE_SZ 1000001

int map[SZ][SZ][SZ] = { 0 };
int X, Y, Z;
int cnt = 0;

int vectX[6] = { 0, 0, 1, -1, 0, 0 };
int vectY[6] = { 1, -1, 0, 0, 0, 0 };
int vectZ[6] = { 0, 0, 0, 0, 1, -1 };

struct node {
    int x;
    int y;
    int z;
};
struct node queue[QUE_SZ];
int tail = 0;
int head = 0;

void enque(int i, int j, int k) {
    struct node temp;
    temp.x = i; temp.y = j; temp.z = k;
    queue[tail] = temp;
    tail = (tail + 1) % QUE_SZ;
}

struct node deque() {
    struct node temp = queue[head];
    head = (head + 1) % QUE_SZ;
    return temp;
}

int isQueEmpty() {
    return(head == tail) ? 1 : 0;
}

int do_bfs() {
    int nextX; int nextY; int nextZ;
    struct node temp;


    while (isQueEmpty() == 0) {
        temp = deque();
        for (int i = 0; i < 6; i++) {
            nextX = temp.x + vectX[i];
            nextY = temp.y + vectY[i];
            nextZ = temp.z + vectZ[i];
            if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < X && nextY < Y && nextZ < Z) {
                if (map[nextX][nextY][nextZ] == 0) {
                    map[nextX][nextY][nextZ] = map[temp.x][temp.y][temp.z] + 1;
                    enque(nextX, nextY, nextZ);
                    cnt--;
                }
            }
        }
    }

    if (cnt == 0) {
        return map[temp.x][temp.y][temp.z] - 1;
    }
    return -1;
}

int main() {
    scanf("%d %d %d", &X, &Y, &Z);
    for (int i = 0; i < Z; i++) {
        for (int j = 0; j < Y; j++) {
            for (int k = 0; k < X; k++) {
                scanf("%d", &map[k][j][i]);
                if (map[k][j][i] == 1) {
                    enque(k, j, i);
                }
                else if (map[k][j][i] == 0) {
                    cnt++;
                }
            }
        }
    }

    printf("%d\n", do_bfs());
}