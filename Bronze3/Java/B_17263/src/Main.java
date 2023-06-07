import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String str[] = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length -1]);
    }
}
