import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Student = scan.nextInt();
        int MultiN = scan.nextInt();

        int[] arr = new int[MultiN];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
            if (arr[i] % 2 == 0) {
                sum += arr[i] / 2;
            } else {
                sum += (arr[i] / 2) + 1;
            }
        }

        if (sum >= Student) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
