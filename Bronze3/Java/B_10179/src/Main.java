import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double price;
        for (int i = 0; i < n; i++) {
            price = sc.nextDouble();
            System.out.println("$" + String.format("%.2f", price * 0.8));
        }
    }
}
