import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] arge) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long K = Long.parseLong(st.nextToken());
        Long N = Long.parseLong(st.nextToken());

        Long result = - 1L;
        if (N != 1L) {
            result = (K * N) / (N - 1L);

            if ((K * N)  % (N - 1L) != 0L) {
                result += 1L;
            }
        }
        System.out.println(result);
    }
}
