import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            int num = sc.nextInt();
            System.out.println(num + " " + divisorCount(num));
        }
    }

    public static int divisorCount(int num) {
        int count = 0;
        int i = 1;
        while (i <= num) {
            if (num % i == 0)
                count += 1;
            i++;
        }
        return count;
    }
}
