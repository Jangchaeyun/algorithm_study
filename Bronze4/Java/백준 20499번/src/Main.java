import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String tkn[] = line.split("/");
		int k = Integer.parseInt(tkn[0]);
		int d = Integer.parseInt(tkn[1]);
		int a = Integer.parseInt(tkn[2]);
		
		if (k + a < d || d == 0)
			System.out.println("hasu");
		else
			System.out.println("gosu");
	}
}