#include <stdio.h>

int min(int a, int b) {
	return a < b ? a : b;
}

int c(int p, int d) {
	if (p <= d)
		return d - p;
	else if (p == 1)
		return 1;
	else if (p % 2)
		return 1 + min(c(p - 1, d), c(p + 1, d));
	else
		return min(p - d, 1 + c(p / 2, d));
}

int main() {
	int N, K;

	scanf("%d %d", &N, &K);
	printf("%d", c(K, N));
}