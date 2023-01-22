#include <stdio.h>

int Arr[7] = { 0, };

void BackTracking(int N, int M, int d) {
	for (int i = 1; i <= N; i++) {
		Arr[d] = i;
		if (M - 1 == d) {
			for (int k = 0; k < M; k++)
				printf("%d ", Arr[k]);
			printf("\n");
		}
		else BackTracking(N, M, d + 1);
	}
}

int main() {
	int N, M;
	scanf("%d%d", &N, &M);

	BackTracking(N, M, 0);

	return 0;
}