import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int answer = 0;
		
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = sc.nextInt();
		}
		
		for (int i : arr) {
			if ((k / i) != 0) {
				answer += (k / i);
				k %= i;
			}
		}
		System.out.println(answer);
	}
}