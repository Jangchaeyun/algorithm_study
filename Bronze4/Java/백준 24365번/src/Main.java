import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		// BufferedRreader Object 생성
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		List<Integer> beeCntList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
		
		// 계산
		final int distance = -beeCntList.get(0) + beeCntList.get(2);
		
		// 출력
		System.out.print(distance);
		// 생성된 BufferedReader 반환
		br.close();
	}
}