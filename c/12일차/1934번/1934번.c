#include <stdio.h>

int N;

int gcd(int a, int b)
{
	if (b == 0)
		return a;
	return gcd(b, a % b);
}

int main() {
	int x, y;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d %d", &x, &y);
		printf("%d\n", x * y / gcd(x, y));
	}
}