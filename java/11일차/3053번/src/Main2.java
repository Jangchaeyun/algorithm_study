import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		double R = Double.parseDouble(br.readLine());
	
		System.out.println(R * R * Math.PI);
		System.out.println(2 * R * R);
		
	}
}