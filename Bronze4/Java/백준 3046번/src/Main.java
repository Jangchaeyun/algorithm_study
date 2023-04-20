import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R1 = sc.nextInt();
		int aver = sc.nextInt();
		
		System.out.println((aver * 2) - R1);
	}
}