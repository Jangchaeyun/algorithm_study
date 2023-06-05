import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] line = new int[N];
        int count = 0;
        int next = 0;
        for (int i = 0; i < line.length; i++) {
            line[i] = scan.nextInt();
        }

        for (int i = 0; i < line.length; i++) {
            if (line[i] == next && next == 0) {
                count++;
                next = 1;
                continue;
            }
            if (line[i] == next && next == 1) {
                count++;
                next = 2;
                continue;
            }
            if (line[i] == next && next == 2) {
                count++;
                next = 0;
                continue;
            }
        }

        System.out.println(count);
    }
}