import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[] seq = new int[N];
		int[] LIS = new int[N];
		
		for (int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
		
		LIS[0] = seq[0];
		int lengthOfLTS = 1;
		
		for (int i = 1; i < N; i++) {
			int key = seq[i];
			
			if (LIS[lengthOfLTS - 1] < key) {
				lengthOfLTS++;
				LIS[lengthOfLTS - 1] = key;
			}
			else {
				int lo = 0;
				int hi = lengthOfLTS;
				while(lo < hi) {
					int mid = (lo + hi) / 2;
					
					if (LIS[mid] < key) {
						lo = mid + 1;
					}
					else {
						hi = mid;
					}
				}
				
				LIS[lo] = key;
			}
		}
		
		System.out.println(lengthOfLTS);
	}
}