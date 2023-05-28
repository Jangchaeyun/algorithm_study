import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] testIBM = br.readLine().split("");

            System.out.println("String #" + (i + 1));
            for (int j = 0; j < testIBM.length; j++) {
                char tmp = testIBM[j].charAt(0);
                tmp += 1;
                if (tmp == 91) {
                    tmp = 65;
                }
                System.out.print(tmp);
            }
            System.out.println();
            System.out.println();
        }
    }
}