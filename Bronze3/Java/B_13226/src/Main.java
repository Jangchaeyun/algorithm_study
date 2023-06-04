import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf(n + " ");

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                System.out.printf(n + " ");
            }
            else {
                n = n * 3 + 1;
                System.out.printf(n + " ");
            }
        }
    }
}
