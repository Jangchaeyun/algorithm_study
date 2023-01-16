#include <stdio.h>
#include <string.h>

int main() {

    int avg = 0, i, j, temp, num[5] = { 0, }, sum = 0;

    for (i = 0; i < 5; i++) {

        scanf("%d", &num[i]);
        sum += num[i];
    }

    avg = sum / 5;

    for (i = 0; i < 5; i++) {

        for (j = 0; j < 5; j++) {

            if (num[j] > num[j + 1]) {

                temp = num[j];
                num[j] = num[j + 1];
                num[j + 1] = temp;
            }
        }
    }

    printf("%d\n%d", avg, num[2]);
}