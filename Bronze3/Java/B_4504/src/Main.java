import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine().trim());

        while (true) {
            int data = Integer.parseInt(scan.nextLine().trim());

            if (data == 0) break;

            if (data % input == 0) {
                System.out.println(data + " is a multiple of " + input + ".");
            } else {
                System.out.println(data + " is NOT a multiple of " + input + ".");
            }
        }
    }
}
