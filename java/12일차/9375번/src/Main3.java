import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main3 {
	
	public final static int MOD = 10007;
    
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());	
 
		while (T -- > 0) {
			
			int[] table = new int[MOD];
			
			int N = Integer.parseInt(br.readLine());
			
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken();
				
				table[hash(st.nextToken())]++;
			}
 
			int result = 1;

			for (int val : table) {
				result *= (val + 1);
			}
			result--;	
			sb.append(result).append('\n');	
			table = null;
		}
		System.out.println(sb);
	}
	
	static int hash(String s) {
		return Math.abs(s.hashCode() ^ (s.hashCode() >>> 16)) % MOD;
	}
}