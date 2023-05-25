import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 1;
        int b = 1;
        int n = scanner.nextInt();
        while (a * b < n) {
            if (a > b) {
                b += 1;
            } else {
                a += 1;
            }
        }
        System.out.print(b + "\t");
        System.out.print(a);
    }
}
