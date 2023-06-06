import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int case1 = Math.abs(end - start);
        int case2 = Math.abs(start - x) + Math.abs(end - y);
        int case3 = Math.abs(start - y) + Math.abs(end - x);

        int answer = Math.min(case1, Math.min(case2, case3));

        System.out.print(answer);
    }
}