#include <iostream>

using namespace std;

long long N, K;

long long lessNum_inMatrix(long long mid) {
	long long cnt = 0;
	for (int i = 1; i <= N; i++) {
		cnt += min(N, (long long)mid / i);
		if (i > mid) break;
	}
	return cnt;
}

void Matrix_BS() {
	long long lo = 1;
	long long hi = N * N;

	int res = 0;

	while (lo <= hi) {
		long long mid = (lo + hi) / 2;
		if (lessNum_inMatrix(mid) < K) lo = mid + 1;
		else {
			res = mid;
			hi = mid - 1;
		}
	}
	cout << res;
}

int main() {
	cin >> N >> K;
	Matrix_BS();

	return 0;
}