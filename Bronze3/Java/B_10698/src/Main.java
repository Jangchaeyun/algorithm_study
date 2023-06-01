import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");

            int sum = 0;

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);
            int c = Integer.parseInt(str[4]);

            if (str[1].equals("+")) {
                sum = a + b;
            } else if (str[1].equals("-")) {
                sum = a - b;
            }
            System.out.println("Case " + (i + 1) + ": " + (sum == c ? "YES" : "NO"));
        }
        sc.close();
    }
}