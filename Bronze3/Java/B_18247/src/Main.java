import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = 12;

        int Tcase = scan.nextInt();

        for (int i = 0; i < Tcase; i++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            if (N < 12 || M < 4) {
                System.out.println(-1);
                break;
            } else {
                int answer = (L * M) - (M - 4);
                System.out.println(answer);
            }
        }
    }
}