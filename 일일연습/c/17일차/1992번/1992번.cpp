#include<iostream>
#include<string>

#define endl "\n"
#define MAX 70
using namespace std;

int N;
int MAP[MAX][MAX];

void Input()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        string S; cin >> S;
        for (int j = 0; j < S.length(); j++)
        {
            MAP[i][j] = S[j] - '0';
        }
    }
}

void DFS(int x, int y, int Size)
{
    if (Size == 1)
    {
        cout << MAP[x][y];
        return;
    }

    bool OnlyZero, OnlyOne;
    OnlyZero = OnlyOne = true;
    for (int i = x; i < x + Size; i++)
    {
        for (int j = y; j < y + Size; j++)
        {
            if (MAP[i][j] == 0) OnlyOne = false;
            if (MAP[i][j] == 1) OnlyZero = false;
        }
    }

    if (OnlyZero == true)
    {
        cout << 0;
        return;
    }
    if (OnlyOne == true)
    {
        cout << 1;
        return;
    }

    cout << "(";
    DFS(x, y, Size / 2);
    DFS(x, y + Size / 2, Size / 2);
    DFS(x + Size / 2, y, Size / 2);
    DFS(x + Size / 2, y + Size / 2, Size / 2);
    cout << ")";
}

void Solution()
{
    DFS(0, 0, N);
    cout << endl;
}

void Solve()
{
    Input();
    Solution();
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Solve();

    return 0;
}
