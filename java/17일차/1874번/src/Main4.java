import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int N = in.nextInt();
		
		int[] stack = new int[N];
		
		int idx = 0;
		int start = 0;
		
		while(N -- > 0) {
			int value = in.nextInt();
			
			if (value > start) {
				for(int i = start + 1; i <= value; i++) {
					stack[idx] = i;
					idx++;
					sb.append('+').append('\n');
				}
				start = value;
			}
			
			else if (stack[idx - 1] != value) {
				System.out.println("NO");
				System.exit(0);
			}
			
			idx--;
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}