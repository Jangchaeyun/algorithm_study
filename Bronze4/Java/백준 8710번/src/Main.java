import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		b -= a;
		
		if (b <= 0) {
			System.out.println(0);
		}
		else {
			int d = b / c;
			if (b % c != 0) d += 1;
			System.out.println(d);
		}
	}
}