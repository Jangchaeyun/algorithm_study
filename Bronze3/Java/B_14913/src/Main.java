import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 1;

        while (a < k) {
            a = a + d;
            cnt++;
        }
        if (a == k) {
            System.out.println(cnt);
        } else {
            System.out.println("X");
        }
    }
}
