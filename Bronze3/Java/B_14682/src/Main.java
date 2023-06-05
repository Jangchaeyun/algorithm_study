import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = sc.nextInt();
        int a = num;
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += (a *= 10);
        }
        System.out.println(sum + num);
    }
}