import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = 0;
        int R = 0;
        int I = 0;

        for (int i = 0; i < N; i++) {
            int result = Integer.parseInt(st.nextToken());

            if (result == 1) {
                A++;
            } else if (result == -1) {
                R++;
            } else {
                I++;
            }
        }

        int M = 0;
        if (N % 2 != 0) {
            M = (N / 2) + 1;
        } else {
            M = N / 2;
        }

        if (I >= M) {
            System.out.println("INVALID");
            return;
        }

        if (A > R) {
            System.out.println("APPROVED");
        } else {
            System.out.println("REJECTED");
        }
    }
}