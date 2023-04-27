import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받는다.
		int axelRevenue = Integer.parseInt(st.nextToken()) * 7;
		int petraRevenue = Integer.parseInt(st.nextToken()) * 13;
		
		// 비교한다.
		String ans;
		if (petraRevenue > axelRevenue) {
			ans = "Petra";
		} else if (petraRevenue == axelRevenue) {
			ans = "lika";
		} else {
			ans = "Axel";
		}
		
		// 출력한다.
		System.out.println(ans);
	}
}
