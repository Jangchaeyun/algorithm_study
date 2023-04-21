import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] cho = new long[2];
		cho[0] = sc.nextLong();
		cho[1] = sc.nextLong();
		
		if (cho[0] % 2 == 0 || cho[1] %2 == 0) System.out.println(0);
		else {
			Arrays.sort(cho);
			System.out.println(cho[0]);
		}
	}
}