import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int top = -1;
		
		int K = in.nextInt();
		int[] arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			int number = in.nextInt();
			
			if(number == 0) {
				top--;
			}
			else {
				top++;
				arr[top] = number;
			}
		}
		int sum = 0;
		for(int i = 0; i <= top; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}