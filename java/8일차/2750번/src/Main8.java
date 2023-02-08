import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main8 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[2001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}
		
		for (int i = 0; i < 2001; i++) {
			if (arr[i]) {
				System.out.println(i - 1000);
			}
		}
	}
}