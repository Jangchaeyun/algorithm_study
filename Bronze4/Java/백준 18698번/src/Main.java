import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			String t = sc.nextLine();
			for (int j = 0; j < t.length(); j++) {
				if (t.charAt(j) == 'U') {
					result++;
				} else
					break;
			}
			System.out.println(result);
			result = 0;
		}
	}
}