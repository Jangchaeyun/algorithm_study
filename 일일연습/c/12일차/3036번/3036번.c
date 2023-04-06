#include <stdio.h>

int get_gcd(int a, int b) {
	int ta = a > b ? a : b;
	int tb = a > b ? b : a;
	int t;

	do {
		t = (int)(ta % tb);
		ta = tb;
		tb = t;
	} while (tb != 0);

	return ta;
}

int main(void) {
	int N, i, gcd;
	int ring[100];

	scanf("%d", &N);
	for (i = 0; i < N; i++) {
		scanf("%d", &ring[i]);
	}

	for (i = 1; i < N; i++) {
		gcd = get_gcd(ring[0], ring[i]);
		printf("%d/%d\n", ring[0] / gcd, ring[i]/gcd);
	}

	return 0;
}