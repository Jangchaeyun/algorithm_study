import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] p = new int[num];
        int cnt = 0;
        for (int i = 0; i < p.length; i++) {
            p[i] = sc.nextInt();
            if (p[i] != i + 1)
                cnt++;
        }
        sc.close();
        System.out.println(cnt);
    }
}