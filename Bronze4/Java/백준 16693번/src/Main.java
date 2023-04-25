import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble(), p = sc.nextDouble(), r = sc.nextDouble(), q = sc.nextDouble();
		double x = a / p, y = Math.PI * r * r / q;
		if (x < y)
			System.out.println("Whole pizza");
		else
			System.out.println("Slice of pizza");
	}
}