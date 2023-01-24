#include <stdio.h>
int arr[10001];
int dp[10001];
int MAX(int a, int b)
{
	return a > b ? a : b;
}

int main()
{
	int N;
	int i;
	scanf("%d", &N);
	for (i = 1; i <= N; i++)
		scanf("%d", &arr[i]);
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	for (i = 3; i <= N; i++)
	{
		dp[i] = MAX(dp[i - 2] + arr[i], MAX(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 1]));
	}
	printf("%d", dp[N]);
}