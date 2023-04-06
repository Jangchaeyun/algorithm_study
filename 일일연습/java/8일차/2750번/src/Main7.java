import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		boolean[] arr = new boolean[2001];
		
		for (int i = 0; i < N; i++) {
			arr[in.nextInt() + 1000] = true;
		}
		
		for (int i = 0; i < 2001; i++) {
			if (arr[i]) {
				System.out.println(i - 1000);
			}
		}
	}
}