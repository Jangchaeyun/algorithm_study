import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == 'i' || str.charAt(i) == 'u')
                sum++;
        }
        System.out.print(sum);
    }
}
