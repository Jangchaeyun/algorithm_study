import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int cnt = sc.nextInt();
            char sym = sc.next().charAt(0);
            for (int j = 0; j < cnt; j++) {
                System.out.print(sym);
            }
            System.out.println();
        }
    }
}
