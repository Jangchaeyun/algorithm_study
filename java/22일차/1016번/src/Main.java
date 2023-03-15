import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static long min;
	private static long max;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] temp = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		min = temp[0];
		max = temp[1];

		writer.write(Integer.toString(solve()));
		writer.newLine();

		writer.close();
		reader.close();
	}

	private static int solve() {
		int size = 0;

		boolean[] isNotPow = eratosthenes();

		for (boolean item : isNotPow) {
			if (!item) {
				size++;
			}
		}
		return size;
	}

	private static boolean[] eratosthenes() {
		int length = (int) (max - min + 1);

		boolean[] isNotPow = new boolean[length];

		for (long i = 2; i * i <= max; i++) {
			long pow = i * i;

			long start = min % pow == 0 ? min / pow : (min / pow) + 1;

			for (long j = start; j * pow <= max; j++) {
				isNotPow[(int) (j * pow - min)] = true;
			}
		}

		return isNotPow;
	}
}