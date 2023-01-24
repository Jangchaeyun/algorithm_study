#include <stdio.h>

int arr[1000001];

int fibo(int n)
{
	if (n < 2)
		return n;
	else if (n == 2)
		return 2;
	else if (arr[n] == 0)
		arr[n] = (fibo(n - 1) + fibo(n - 2)) % 15746;
	return arr[n];
}

int main()
{
	int n;
	scanf("%d", &n);
	fibo(n);
	printf("%d", fibo(n));
}