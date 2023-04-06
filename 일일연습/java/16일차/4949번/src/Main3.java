import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s;
 
		while (true) {
 
			s = in.nextLine();
 
			if (s.equals(".")) {
				break;
			}
 
			sb.append(solve(s)).append('\n');
		}
 
		System.out.println(sb);
	}
	public static String solve(String s) {
		
		char[] stack = new char[s.length()];
		int size = 0;
 
		for (char val : s.toCharArray()) {
			if (val == '(' || val == '[') {
				stack[size] = val;
				size++;
			}
			else if (val == ')') {
				if (size == 0 || stack[size - 1] != '(') {
					return "no";
				} 
				else {
					size--;
				}
			}
			else if (val == ']') {
				if (size == 0 || stack[size - 1] != '[') {
					return "no";
				} 
				else {
					size--;
				}
			}
		}
		
		if (size != 0) {
			return "no";
		} 
		else {
			return "yes";
		}
	}
}
