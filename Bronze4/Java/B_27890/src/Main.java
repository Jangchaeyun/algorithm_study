import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x0 = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            if (x0 % 2 == 0) {
                x0 = ((x0 / 2) ^ 6);
            } else {
                x0 = ((2 * x0) ^ 6);
            }
        }
        System.out.println(x0);
    }
}