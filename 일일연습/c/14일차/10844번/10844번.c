#include <stdio.h>
#define mod 1000000000;

int main()
{
	int dp[101][10];
	int i, j, n;
	int sum = 0;
	scanf("%d", &n);
	i = 0;
	while (i <= 9)
	{
		dp[1][i] = 1;
		i++;
	}
	i = 2;
	while (i <= n)
	{
		j = 0;
		while (j <= 9)
		{
			if (j == 0)
			{
				dp[i][j] = dp[i - 1][1] % mod;
			}
			else if (j == 9)
			{
				dp[i][j] = dp[i - 1][8] % mod;
			}
			else
			{
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
			j++;
		}
		i++;
	}
	i = 1;
	while (i <= 9)
	{
		sum = (sum + dp[n][i]) % mod;
		i++;
	}
	printf("%d", sum);
}