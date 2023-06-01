import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);

        int time = Integer.parseInt(str[1]);
        int count = 0;
        String[] needStr = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            int need = Integer.parseInt(needStr[i]);
            if (time >= need) {
                time -= need;
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
