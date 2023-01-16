#include <stdio.h>
#include <stdlib.h>

int compare(const void* arg1, const void* arg2) {
	int a = *(int*)arg1;
	int b = *(int*)arg2;

	if (a < b) return 1;
	else if (a > b) return -1;
	else return 0;
}

int main(void)
{
	int arr[1000] = { 0 };
	int sizeOfArr = sizeof(arr) / sizeof(int);
	int n, k, x;

	scanf("%d%d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	qsort(arr, sizeof(arr) / sizeof(int), sizeof(int), compare);
	printf("%d", arr[k - 1]);

	return 0;
}