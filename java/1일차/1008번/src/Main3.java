import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main3 {
 
	public static void main(String[] args) throws IOException {
		     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		double a = Double.parseDouble(str[0]);
		double b = Double.parseDouble(str[1]);
		
		System.out.println(a/b);
	}
}