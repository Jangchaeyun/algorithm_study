import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.print(findCorrectRewrittenLetters());
    }

    private static int findCorrectRewrittenLetters() throws IOException {
        int retCnt = 0;
        int len = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                retCnt++;
            }
        }

        return retCnt;
    }
}
