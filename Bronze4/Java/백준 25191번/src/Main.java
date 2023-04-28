import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	private void solution() throws Exception {
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int cnt = a / 2 + b;
		System.out.println(Math.min(n, cnt));
	}
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}