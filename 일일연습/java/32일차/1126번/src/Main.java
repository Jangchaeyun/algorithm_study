import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int[][] dp;
	public static int[] arr;
	public static int inf = 1 << 20;
	
	public static int search(int n, int diff) {
		if (diff > 250000)
			return -inf;
		
		if (N == n) {
			if (diff == 0)
				return 0;
			else
				return -inf;
		}
		
		if (dp[n][diff] != -1)
			return dp[n][diff];
		
		// 아무 선택하지 않은 경우
		dp[n][diff] = search(n + 1, diff);
		
		// 차이를 더 벌리는 경우
		dp[n][diff] = Math.max(dp[n][diff], search(n + 1, diff + arr[n]));
		
		// 차이를 좁히는 경우
		if (arr[n] > diff) {
			dp[n][diff] = Math.max(dp[n][diff], diff + search(n + 1, arr[n] - diff));
		} else {
			dp[n][diff] = Math.max(dp[n][diff], arr[n] + search(n + 1, diff - arr[n]));
		}
		
		return dp[n][diff];
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new int[N + 1][250001];
		arr = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			
			Arrays.fill(dp[i], -1);
		}
		
		int ans = search(0, 0);
		System.out.print(ans > 0 ? ans : -1);
		
		sc.close();
	}
}