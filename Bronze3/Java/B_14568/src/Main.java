import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int a = 1;
        int b = 3;
        int c = 2;

        int count = 0;
        while (true) {
            int sum = 0;
            sum += a + b + c;
            if (n == sum) {
                count++;
            }
            c = c + 2;
            int nmg = n - c;

            if (nmg % 2 == 0) {
                a = nmg / 2 - 2;
                b = nmg / 2 + 2;
            } else {
                a = nmg / 2 - 1;
                b = nmg / 2 + 1;
            }

            if (a + b < 3 || c >= n - 3) {
                break;
            }
        }
        System.out.println(count);
    }
}
