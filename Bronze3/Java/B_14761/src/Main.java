import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, N;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            System.out.println(fizzbuzz(i));
        }
    }

    static String fizzbuzz(int n) {
        String returnString = "";

        if (n % X == 0)
            returnString += "Fizz";
        if (n % Y == 0)
            returnString += "Buzz";
        if (returnString.isEmpty())
            return Integer.toString(n);
        return returnString;
    }
}
