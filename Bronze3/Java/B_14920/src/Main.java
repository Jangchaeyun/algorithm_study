import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        while (true) {
            if (num == 1)
                break;
            if (num % 2 == 0)
            {
                num = num / 2;
                cnt++;
            } else if (num % 2 != 0) {
                num = num * 3 + 1;
                cnt++;
            }
        }
        sc.close();
        System.out.print(cnt+1);
    }
}
