#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int N, i, j;
	scanf("%d", &N);
	for (i = 2; i <= N; i++)
	{
		while (N % i == 0)
		{
			printf("%d\n", i);
			N /= i;
		}
	}
	return 0;
}