#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int gcd(int a, int b)
{
    if (a == 0) return b;
    if (b == 0) return a;

    if (a % b == 0) return b;
    else return gcd(b, a % b);
}

void print_cd(int n)
{
    int list[1000];
    int idx = 0;

    list[idx++] = n;
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            if (i * i == n) printf("%d ", i);
            else
            {
                printf("%d ", i);
                list[idx++] = n / i;
            }
        }
    }

    for (int i = idx - 1; i >= 0; i--)
        printf("%d ", list[i]);
}

int main()
{
    int N, gcdN, min = 1000000000;
    int arr[1001];

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", arr + i);

        if (i == 0) continue;
        arr[i] = abs(arr[i] - arr[0]);

        if (i == 1)
        {
            gcdN = arr[1];
            continue;
        }
        gcdN = gcd(gcdN, arr[i]);
    }

    print_cd(gcdN);

    return 0;
}