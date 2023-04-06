#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct compare {
	bool operator()(int a, int b) {
		if (abs(a) == abs(b)) {
			return a > b;
		}
		else {
			return abs(a) > abs(b);
		}
	}
};

int N, x;
priority_queue<int, vector<int>, compare> pq;
int main(int argc, char* argv[]) {
	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d", &x);
		if (x == 0) {
			if (!pq.empty()) {
				printf("%d\n", pq.top());
				pq.pop();
			}
			else {
				printf("0\n");
			}
		}
		else {
			pq.push(x);
		}
	}
	return 0;
}