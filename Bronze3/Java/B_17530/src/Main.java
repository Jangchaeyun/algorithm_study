import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int calors = arr[0];
        boolean sw = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] > calors) {
                sw = true;
            }
        }
        System.out.println(!sw ? "S": "N");
    }
}