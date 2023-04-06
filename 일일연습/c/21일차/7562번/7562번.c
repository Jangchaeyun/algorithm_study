#include <stdio.h>
#include <string.h>
#define SZ 301
#define QUE_SZ 90001

int chess_board[SZ][SZ] = { 0 };
int test_case, chess_size;

int vectY[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };
int vectX[8] = { -2, -1, 1, 2, 2, 1, -1, -2 };

struct node {
	int x;
	int y;
};
struct node queue[QUE_SZ];
int tail = 0;
int head = 0;

void enque(int a, int b) {
	struct node temp;
	temp.x = a;
	temp.y = b;
	queue[tail] = temp;
	tail = (tail + 1) % QUE_SZ;
}

struct node deque() {
	struct node temp = queue[head];
	head = (head + 1) % QUE_SZ;
	return temp;
}

int isQueEmpty() {
	return (head == tail) ? 1 : 0;
}

void do_bfs() {

    struct node temp;
    while (isQueEmpty() == 0) {
        temp = deque();
        int a = temp.x; int b = temp.y;

        int nextX; int nextY;
        for (int i = 0; i < 8; i++) {
            nextX = a + vectX[i];
            nextY = b + vectY[i];

            if (nextX >= 0 && nextY >= 0 && nextX < chess_size && nextY < chess_size) {
                if (chess_board[nextX][nextY] == 0) {
                    chess_board[nextX][nextY] = chess_board[a][b] + 1;
                    enque(nextX, nextY);
                }
            }
        }
    }
    return;
}

void solution(int chess_start_x, int chess_start_y, int chess_dst_x, int chess_dst_y) {
    chess_board[chess_start_x][chess_start_y] = 1;
    enque(chess_start_x, chess_start_y);
    do_bfs();
    printf("%d\n", chess_board[chess_dst_x][chess_dst_y] - 1);
    return 0;
}

int main() {
    scanf("%d", &test_case);
    int chess_start_x, chess_start_y, chess_dst_x, chess_dst_y;

    for (int i = 0; i < test_case; i++) {
        scanf("%d", &chess_size);
        scanf("%d %d", &chess_start_x, &chess_start_y);
        scanf("%d %d", &chess_dst_x, &chess_dst_y);

        memset(chess_board, 0, sizeof(chess_board));
        solution(chess_start_x, chess_start_y, chess_dst_x, chess_dst_y);
    }
}