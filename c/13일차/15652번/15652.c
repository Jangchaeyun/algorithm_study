#include <stdio.h>

int n, m;
int result[1000];

void DFS(int depth, int cnt)
{
	int i;

	if (depth == m)
	{
		for (int i = 0; i < m; i++)
			printf("%d ", result[i]);
		printf("\n");
	}
	else
	{
		for (i = 1; i <= n; i++)
		{
			if (cnt <= i)
			{
				result[depth] = i;
				DFS(depth + 1, i);
			}
		}
	}
}

int main(void)
{
	scanf("%d %d", &n, &m);
	DFS(0, 0);
	return 0;
}