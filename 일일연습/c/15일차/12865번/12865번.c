#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int i, j, n, k;
	int* warr, * varr, * arr;

	scanf("%d %d", &n, &k);

	warr = (int*)malloc(sizeof(int) * n);
	varr = (int*)malloc(sizeof(int) * n);
	arr = (int*)malloc(sizeof(int) * (k + 1));

	for (i = 0; i < n; i++)
	{
		scanf("%d %d", &warr[i], &varr[i]);
		if (varr[i] == 0)
			warr[i] = 0;
	}
	for (i = 0; i < k; i++)
		arr[i] = 0;
	for (i = 0; i < n; i++)
	{
		for (j = k; j > 0; j--)
		{
			if (warr[i] <= j)
			{
				if (arr[j] < arr[j - warr[i]] + varr[i])
					arr[j] = arr[j - warr[i]] + varr[i];
			}
		}
	}
	printf("%d", arr[k]);

	free(warr);
	free(varr);
	free(arr);

	return 0;
}