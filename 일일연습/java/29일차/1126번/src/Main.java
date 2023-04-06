import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long start = System.currentTimeMillis();

		while (sc.hasNext()) {

			n = sc.nextInt();
			arr = new int[n + 2];
			dp = new int[52][500002];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			for (int j = 0; j < 52; j++) {
				for (int j2 = 0; j2 < 500002; j2++) {
					dp[j][j2] = -2;
				}
			}

			System.out.println(process(0, 0, 0));

		}

//		long end = System.currentTimeMillis();
//		System.out.println("time "+ (end-start)/1000.0);
	}

	static int n;
	static int[] arr;
	static int[][] dp; // index i, 두 값의 차이가 j 일때 가능한 최대높이

	private static int process(int index, int leftTop, int rightTop) {

		int t = leftTop - rightTop + 250000;

		if (index > n)
			return -1;

		if (leftTop > 250000 || rightTop > 250000)
			return -1;
		if (dp[index][t] != -2)
			return dp[index][t]; // 방문했으면, 값 리턴

		dp[index][t] = -1; // 한번 방문햇으면 -1;
		if (leftTop == rightTop && leftTop != 0)
			dp[index][t] = 0;

		int leftVal = process(index + 1, leftTop + arr[index], rightTop);
		int rightVal = process(index + 1, leftTop, rightTop + arr[index]);
		int middleVal = process(index + 1, leftTop, rightTop);

		if (leftVal != -1) { // 갈 수 있으면
			dp[index][t] = Math.max(dp[index][t], leftVal + arr[index]);
		}
		if (rightVal != -1) { // 갈 수 있으면
			dp[index][t] = Math.max(dp[index][t], rightVal);
		}
		if (middleVal != -1) { // 갈 수 있으면
			dp[index][t] = Math.max(dp[index][t], middleVal);
		}

		return dp[index][t];
	}

}