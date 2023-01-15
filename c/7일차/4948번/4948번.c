#include <stdio.h>
int main(void) {
	int n, n2, arr[1000001] = { 0, }, count = 0;
	arr[1] = 1;

	for (int i = 2; i <= 260000; i++) {
		for (int j = 2; i * j <= 260000; j++) {
			arr[i * j] = 1;
		}
	}


	while (1) {
		scanf("%d", &n);

		if (n == 0) break;

		n2 = n * 2;

		for (int i = n + 1; i <= 2 * n; i++) {	// n은 포함하지 않는다고 명시됨
			if (arr[i] == 0) {
				count++;
			}

		}

		printf("%d\n", count);
		count = 0;
		n = 0;
	}

	return 0;
}