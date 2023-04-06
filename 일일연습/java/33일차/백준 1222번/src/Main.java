import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int size;
	static long[] count = new long[2000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		size = stoi(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			divide(stoi(st.nextToken()));
		}
		
		long max = 0;
		for (long i = 1; i <= 2000000; i++) {
			if (count[(int) i] < 2) {
				continue;
			}
			max = Math.max(max, count[(int) i] * i);
		}
		System.out.println(max);
	}
	
	private static void divide(int num) {
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				count[i]++;
				if (i != num / i)
					count[num / i]++;
			}
		}
	}
	
	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}