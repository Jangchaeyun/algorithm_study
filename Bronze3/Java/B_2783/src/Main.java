import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X = scan.nextInt();
        int Y = scan.nextInt();
        int N = scan.nextInt();
       double minPrice = (double) X / Y * 1000;

       for (int i = 0; i < N; i++) {
           int X1 = scan.nextInt();
           int Y1 = scan.nextInt();
           double price = (double) X1 / Y1 * 1000;
           minPrice = Math.min(minPrice, price);
       }

        System.out.println(minPrice);
       scan.close();
    }
}
