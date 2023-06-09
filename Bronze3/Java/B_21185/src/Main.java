import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int givenN = Integer.parseInt(br.readLine());

        String outputWord;
        if (givenN % 4 == 0) {
            outputWord = "Even";
        } else if (givenN % 2 == 0) {
            outputWord = "Odd";
        } else {
            outputWord = "Either";
        }

        System.out.println(outputWord);
    }
}