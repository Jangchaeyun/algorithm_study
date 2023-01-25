#include<iostream>
#include<algorithm>
using namespace std;

#define SIZE 1001

int n, tmp;
int A[SIZE];
int DP1[SIZE];
int DP2[SIZE];
int ans[SIZE];

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> A[i];
		tmp = 0;
		for (int j = 0; j < i; j++)
		{
			if (A[i] > A[j] && DP1[j] > tmp) tmp = DP1[j];
		}
		DP1[i] = tmp + 1;
		ans[i] += DP1[i];
	}

	for (int i = n - 1; i >= 0; i--)
	{
		tmp = 0;
		for (int j = n - 1; j > i; j--)
		{
			if (A[i] > A[j] && DP2[j] > tmp) tmp = DP2[j];
		}
		DP2[i] = tmp + 1;
		ans[i] += DP2[i];
	}



	sort(ans, ans + n, greater<>());

	cout << ans[0] - 1;

}