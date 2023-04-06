import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int[] fibonacci = new int[N + 1];
		
		for (int i = 0; i < fibonacci.length; i++) {
			if (i == 0) fibonacci[0] = 0;
			else if (i == 1) fibonacci[1] = 1;
			else fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		
		System.out.println(fibonacci[N]);
	}
}