import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 1;
		
		while(N != 0) {
			sum = sum * N;
			N--;
		}
		
		System.out.print(sum);
	}
}