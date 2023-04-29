import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine().trim();
            str = str.replaceAll("D-", "");

            if (Integer.parseInt(str) <= 90) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}