import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Aattack = scan.nextInt();
        int Ahp = scan.nextInt();

        int Battack = scan.nextInt();
        int Bhp = scan.nextInt();

        while (true) {
            Ahp -= Battack;
            Bhp -= Aattack;

            if (Bhp <= 0 && Ahp >= 1) {
                System.out.println("PLAYER A");
                break;
            } else if (Ahp <= 0 && Bhp >= 1) {
                System.out.println("PLAYER B");
                break;
            } else if (Ahp >= 1 && Bhp >= 1) {
                continue;
            } else {
                System.out.println("DRAW");
                break;
            }
        }
    }
}