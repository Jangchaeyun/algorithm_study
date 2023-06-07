import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = 5000;
        final int[] DRINK = {500, 800, 1000};
        String[] num = br.readLine().split(" ");

        for (int i = 0, len = num.length; i < len; i++) {
            int button = Integer.parseInt(num[i]);
            money -= DRINK[button - 1];
        }
        System.out.println(money);
    }
}
