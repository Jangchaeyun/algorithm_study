import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] arr = new int[3];

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = scanner.nextInt();
            }
            Arrays.sort(arr);

            if (arr[0] + arr[1] <= arr[2]) {
                System.out.printf("Case #%d: ", i);
                System.out.println("invalid!");
            } else if (arr[0] == arr[1] && arr[0] == arr[2]) {
                System.out.printf("Case #%d: ", i);
                System.out.println("equilateral");
            } else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
                System.out.printf("Case #%d: ", i);
                System.out.println("isosceles");
            } else {
                System.out.printf("Case #%d: ", i);
                System.out.println("scalene");
            }
        }
    }
}