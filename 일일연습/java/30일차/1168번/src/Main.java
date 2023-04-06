import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int K = Integer.parseInt(st.nextToken()) - 1; // index는 0부터 시작하므로 K에 1을 빼준다.
		 
		 List<Integer> a = new ArrayList<>();
		 
		 for (int i = 1; i <= N; i++) {
			 a.add(i);
		 }
		 
		 int index = 0;
		 StringBuilder sb = new StringBuilder();
		 sb.append("<");
		 for (int i = 0; i < N - 1; i++) {
			 index += K;
			 
			 // index가 size를 초과할 경우 MOD 연산.
			 if (index >= a.size()) {
				 index %= a.size();
			 }
			 
			 // index에 해당하는 요소를 삭제.
			 sb.append(a.remove(index) + ", ");
		 }
		 // 출력을 편하게 하기 위하여 마지막 요소는 따로 뺴서 삭제.
		 sb.append(a.remove(0) + ">");
		 
		 bw.write(sb.toString() + "\n");
		 bw.flush();
		 bw.close();
		 br.close();
	}

}
