import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[][] map; // 입력 땅 정보
	static int n;
	// 확장 방향 ↖︎↗︎↙︎↘︎ 에 맞는 x, y 측 이동 방향
	static int[] fx = { -1, 1, -1, 1 };
	static int[] fy = { 1, 1, -1, -1 };
	// 확장의 시작점을 구하기 위해 기준(꼭지점)에 더해줄 값
	static int[] dx = { 0, 1, 0, 1 };
	static int[] dy = { 0, 0, -1, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 대각선 확장을 쉽게 구하기 위해 0은 비워둘 것
		map = new int[n + 1][n + 1];
		// input
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int allCount = 0;
		// 교차점 순회
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < n; j++) {
				// 교차점 기준으로 ↖︎ vs ↘︎, ↗︎ vs ↙︎ 비교한 총 경우의 수
				allCount += pointCount(i, j);
			}
		}
		System.out.println(allCount);
	}
	
	private static int pointCount(int y, int x) {
		int same = 0;
		// 첫번째: ↖︎(0) vs ↘︎(3), 두번째 : ↗︎(1) vs ↙︎(2)
		for(int dir = 0; dir < 2; dir++) {
			// 왼쪽 방향과 오른쪽 방향에서 가능한 직사각형의 총 수익을 담는 배열
			ArrayList<Integer> left = getRevenue(y + dy[dir], x + dx[dir], dir);
			int rd = 3 - dir;
			ArrayList<Integer> right = getRevenue(y + dy[rd], x + dx[rd], rd);
			
			// 왼쪽 vs 오른쪽 각 직사각형의 수익을 비교
			for (int l : left) {
				for (int r : right) {
					if (l == r) same++;
				}
			}
		}
		
		return same;
	}
	
	private static ArrayList<Integer> getRevenue(int y, int x, int dir) {
		int[][] revMap = new int[n + 1][n + 1]; // 이전 확장 값을 저장하기 위한 배열
		ArrayList<Integer> revenue = new ArrayList<>(); // 가능한 직사각형 수
		
		for (int i = y; fy[dir] > 0 ? i <= n : i > 0; i+= fy[dir]) {
			int horSum = 0; // 각 행 확장 값 저장 용도
			for (int j  = x; fx[dir] > 0 ? j <= n : j > 0; j += fx[dir]) {
				horSum += map[i][j];
				 // revMap[i - fy[dir]][j] : 확장 방향 기준, 해당 열 이전 행까지의 총 수익
				// 새로운 직사각형 = (특정 열까지)(현재 행의 총 수익 + 이전 행까지의 총 수익)
				
				revMap[i][j] = revMap[i - fy[dir]][j] + horSum;
				revenue.add(revMap[i][j]);
			}
		}
		return revenue;
	}
}