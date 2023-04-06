import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main5 {
 
	public static void main(String[] args) throws IOException {
		     
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
        
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
		bw.write( ((A+B)%C) + "\n" );
		bw.write( ((A%C + B%C)%C) + "\n" );
		bw.write( ((A*B)%C) + "\n" );
		bw.write( ((A%C * B%C)%C) + "\n" );
 
		bw.flush();
		bw.close();
 
	}
}