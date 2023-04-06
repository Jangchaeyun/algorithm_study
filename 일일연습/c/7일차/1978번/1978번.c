#include <stdio.h>

int main()
{
	int N, i, j;
	int num, flags, cnt = 0;

	scanf("%d", &N);

	for (i = 0; i < N; i++) {
		scanf("%d", &num);
		flags = 0;

		if (num == 1)
			continue;

		for (j = 2; j < num; j++)
			if (num % j == 0)
				flags = 1;
		if (flags == 0)
			cnt++;
	}
	printf("%d\n", cnt);

	return 0;
}