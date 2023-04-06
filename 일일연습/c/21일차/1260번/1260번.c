#include <stdio.h>
#define MAX_VERTICES 1001
int DFS_V[MAX_VERTICES] = { 0, };
int BFS_V[MAX_VERTICES] = { 0, };
int graph[MAX_VERTICES][MAX_VERTICES] = { 0, };
int queue[MAX_VERTICES];
void dfs(int v, int verticies);
void bfs(int v, int verticies);

int main() {
	int verticies, edges, vertex, i, j;
	scanf("%d %d %d", &verticies, &edges, &vertex);

	while (edges--) {
		scanf("%d %d", &i, &j);
		graph[i][j] = 1;
		graph[j][i] = 1;
	}

	dfs(vertex, verticies);
	printf("\n");
	bfs(vertex, verticies);

	return 0;
}

void dfs(int v, int verticies) {
	int w;
	DFS_V[v] = 1;
	printf("%d ", v);
	for (w = 1; w <= verticies; w++) {
		if (graph[v][w] == 1 && DFS_V[w] == 0) {
			dfs(w, verticies);
		}
	}
}

void bfs(int v, int verticies) {
	int w;
	int front, rear, pop;
	front = rear = 0;
	printf("%d ", v);
	BFS_V[v] = 1;
	queue[0] = v;
	rear++;
	while (front < rear) {
		pop = queue[front];
		front++;
		for (w = 1; w <= verticies; w++) {
			if (graph[pop][w] == 1 && BFS_V[w] == 0) {
				printf("%d ", w);
				queue[rear] = w;
				rear++;
				BFS_V[w] = 1;
			}
		}
	}
}