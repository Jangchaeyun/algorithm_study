import java.util.Scanner;
 
public class Main3 {
	
	static int N;
	static int[] seq;
	static int[] r_dp;
	static int[] l_dp;
	
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		
		r_dp = new int[N];
		l_dp = new int[N];
		seq = new int[N];
		
 
		for (int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
 
		LTS();
		LDS();
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(max < r_dp[i] + l_dp[i]) {
				max = r_dp[i] + l_dp[i];
			}
		}
 
		System.out.println(max - 1);
	}
 
	
	
	static void LTS() {
 
		for(int i = 0; i < N; i++) {
			r_dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
				}
			}
		}
	}
	
	static void LDS() {
		for (int i = N - 1; i >= 0; i--) {
			l_dp[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
					l_dp[i] = l_dp[j] + 1;
				}
			}
		}
	}
}