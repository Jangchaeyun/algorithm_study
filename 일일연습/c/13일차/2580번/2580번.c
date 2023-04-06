#include <stdio.h>
#include <stdlib.h>

void solve(int(*sudoku)[9], int count);

int main(void) {
	int sudoku[9][9];
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			scanf("%d", &sudoku[i][j]);
		}
	}

	solve(sudoku, 0);
}

void solve(int(*sudoku)[9], int count) {
	if (count == 81) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				printf("%d ", sudoku[i][j]);
			}
			printf("\n");
		}
		exit(0);
	}
	else {
		int index1 = count / 9;
		int index2 = count % 9;

		if (sudoku[index1][index2] != 0) {
			solve(sudoku, count + 1);
		}
		else {
			for (int i = 1; i <= 9; i++) {
				sudoku[index1][index2] = i;
				int failure = 0;
				for (int j = 0; j < 9; j++) {
					if (j != index2 && sudoku[index1][j] == i)
						failure = 1;
					if (j != index1 && sudoku[j][index2] == i)
						failure = 1;
				}
				int center1 = 0;
				int center2 = 0;
				for (int k1 = 1; k1 <= 7; k1 += 3) {
					for (int k2 = 1; k2 <= 7; k2 += 3) {
						if (abs(k1 - index1) <= 1 && abs(k2 - index2) <= 1) {
							center1 = k1;
							center2 = k2;
						}
					}
				}
				for (int num1 = center1 - 1; num1 <= center1 + 1; num1++) {
					for (int num2 = center2 - 1; num2 <= center2 + 1; num2++) {
						if (num1 == index1 && num2 == index2)
							continue;
						else {
							if (sudoku[num1][num2] == i)
								failure = 1;
						}
					}
				}
				if (!failure) {
					solve(sudoku, count + 1);
				}
				sudoku[index1][index2] = 0;
			}
		}
	}
}