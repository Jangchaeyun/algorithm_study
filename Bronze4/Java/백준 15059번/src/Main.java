import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] available = new int[3]; // 준비된 양
		int[] requested = new int[3]; // 선호하는 양
		
		for (int i = 0; i < 3; i++) {
			available[i] = sc.nextInt(); // 준비된 양 입력(치킨, 비프, 파스타 순)
		}
		
		for (int i = 0; i < 3; i++) {
			requested[i] = sc.nextInt(); // 선호하는 양 입력(치킨, 비프, 파스타 순)
		}
		
		sc.close();
		
		int result = 0;
		for (int i = 0; i < 3; i++) {
			if (requested[i] - available[i] > 0) // 치킨, 버프, 파스타 순서로 돌면서 차이가 0보다 크면
				result += (requested[i] - available[i]); // 차이값을 result에 더해줌
		}
		
		System.out.println(result);
	}

}
