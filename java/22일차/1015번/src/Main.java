import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(reader.readLine());
        
        int[][] A = new int[N][2];
        
        int[] B = new int[N];
        
        String[] temp = reader.readLine().split(" ");
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < N; i++)
        {
        	A[i][0] = Integer.parseInt(temp[i]);
        	A[i][1] = i;
        }
        
        sort(A);
        
        for (int i = 0; i < N; i++)
        {
        	int index = A[i][1];
        	B[index] = i;
        }
        
        for (int i = 0; i < N; i++)
        {
        	int index = A[i][1];
        	
        	B[index] = i;
        }
        
        for (int b : B)
        {
        	builder.append(b).append(" ");
        }
        
        System.out.println(builder.toString().trim());
        
        writer.close();
        reader.close();
	}

	private static void sort(int[][] A)
	{
		Arrays.sort(A, (next, current) -> 
		{
			if (next[0] < current[0])
			{
				return -1;
			}
			
			else if (next[0] > current[0])
			{
				return 1;
			}
			
			else
			{
				return Integer.compare(next[1], current[1]);
			}
		});
	}
}
