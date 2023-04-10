import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] c = new int[3];
		for (int i = 0; i < 3; i++) {
			c[i] = sc.nextInt();
		}
		
		int bx = c[0] - a[2];
		int bz = c[1] / a[1];
		int by = c[2] - a[0];
		
		System.out.println(bx + " " + bz + " " + by);
	}
}