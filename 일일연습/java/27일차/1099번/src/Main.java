import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	private static int diff(String s1, String s2) {
		int cnt = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) cnt ++;
		}
		return cnt;
	}
	private static boolean compareAlpabet(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		int[] check = new int[26];
		for (int k = 0; k < s1.length(); k++) {
			check[s1.charAt(k) - 'a']++;
			check[s2.charAt(k) - 'a']--;
		}
		for (int k = 0; k < check.length; k++) {
			if (check[k] != 0) return false; 
		}
		return true;
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[s.length()+1];
		Arrays.fill(dp, Integer.MAX_VALUE-51);
		String[] words = new String[N];
		String[] splitWords;
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		dp[0] = 0;
		for (int i = 1; i <= s.length(); i++) {
			splitWords = new String[i];
			for (int j = 0; j < i; j++) { 
				splitWords[j] = s.substring(j, i);
			}
			
			for (int j = 0; j < splitWords.length; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (!compareAlpabet(splitWords[j], words[j2])) continue;

					int diffCnt = diff(splitWords[j],words[j2]);
				
					if (j == 0) {
						dp[i] = Math.min(diffCnt, dp[i]);
						continue;
					}
					
					dp[i] = Math.min(dp[i], diffCnt + dp[j]);
				}
			}
		}
		
		if (dp[s.length()] != Integer.MAX_VALUE-51) {
			System.out.println(dp[s.length()]);
		} else {			
			System.out.println(-1);
		}
	}
}