#include <stdio.h>

int main() {
	int A, B, V;
	int dev;
	
	scanf("%d %d %d", &A, &B, &V);

	dev = (V - B - 1) / (A - B) + 1;

	printf("%d", dev);

	return 0;
}