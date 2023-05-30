import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int N = sc.nextInt();
            double D = sc.nextDouble();
            double A = sc.nextDouble();
            double B = sc.nextDouble();
            double F = sc.nextDouble();
            String sum = String.format("%.6f", D / (A + B) * F);
            System.out.println(N + " " + sum);
        }
    }
}
