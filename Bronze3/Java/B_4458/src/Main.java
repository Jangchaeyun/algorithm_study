import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();

            System.out.println((str.charAt(0) + "").toUpperCase() + str.substring(1, str.length()));
        }

        scan.close();
    }
}
