import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input % 2 == 1) {
            System.out.println(0);
            return;
        } else {
            if ((1 + input) % 2 == 1 && (input / 2) % 2 == 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
                return;
            }
        }
    }
}
