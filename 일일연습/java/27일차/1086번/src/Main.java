import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] Nums;
	static int K, N;
	static int MaxBitmask;
	static long[][] Dp;
	static int[][] Mods;
	
	public static long dp(int bitmask, int mod) {
		if(Dp[bitmask][mod] != -1) {
			return Dp[bitmask][mod];
		}
		
		if (bitmask == MaxBitmask) {
			return mod == 0 ? 1 : 0;
		}
		
		long count = 0;
		for (int i = 0; i  < N; i++) {
			int idx = 1 << i;
			if ((bitmask & idx) == 0) {
				count += dp(bitmask|idx, getMod(i, mod));
			}
		}
		return Dp[bitmask][mod] = count;
	}
	
	public static int getMod(int idx, int mod) {
		if (Mods[idx][mod] != -1) return Mods[idx][mod];
		int curr = mod;
		int length = Nums[idx].length();
		for (int i = 0; i < length; i++) {
			curr *= 10;
			curr += (Nums[idx].charAt(i) - '0');
			curr %= K;
		}
		return Mods[idx][mod] = curr;
	}
	
	public static long getGcd(long n, long m) {
		if (m == 0) return n;
		return getGcd(m, n % m);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Nums = new String[N];
		for (int i = 0; i < N; i++) {
			Nums[i] = br.readLine();
		}
		K = Integer.parseInt(br.readLine());
		MaxBitmask = (1 << N) - 1;
		Dp = new long[1<<N][K];
		Mods = new int[N][K];
		for(int j = 0; j < K; j++) {
			for (int i = 0; i < N; i++) {
				Mods[i][j] = -1;
			}
			for (int i = 0; i <= MaxBitmask; i++) {
				Dp[i][j] = -1;
			}
		}
		long answer = dp(0, 0);
		if (answer == 0) {
			System.out.println("0/1");
		} else {
			long fac = 1;
			for (int i = 2; i <= N; i++) {
				fac *= i;
			}
			
			long gcd = getGcd(fac, answer);
			System.out.println(answer / gcd + "/" + fac / gcd);
		}
		br.close();
	}
}