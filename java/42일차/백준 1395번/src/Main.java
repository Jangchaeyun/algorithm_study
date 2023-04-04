import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static Fs fs = new Fs();
	static int n, m;
	static int[] tree;
	static int[] lazy;

	public static void updateLazy(int node, int st, int ed) {
		if (lazy[node] != 0) {
			tree[node] = (ed - st + 1) - tree[node];

			if (st != ed) {
				lazy[node * 2] ^= 1;
				lazy[node * 2 + 1] ^= 1;
			}
			lazy[node] = 0;
		}
	}

	public static void toggle(int node, int st, int ed, int left, int right) {
		updateLazy(node, st, ed);
		if (st > right || ed < left)
			return;
		if (left <= st && ed <= right) {
			tree[node] = (ed - st + 1) - tree[node];

			if (st != ed) {
				lazy[node * 2] ^= 1;
				lazy[node * 2 + 1] ^= 1;
			}
			return;
		}

		toggle(node * 2, st, (st + ed) / 2, left, right);
		toggle(node * 2 + 1, (st + ed) / 2 + 1, ed, left, right);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static int sum(int node, int st, int ed, int left, int right) {
		updateLazy(node, st, ed);
		if (st > right || ed < left)
			return 0;
		if (left <= st && ed <= right)
			return tree[node];

		return sum(node * 2, st, (st + ed) / 2, left, right) + sum(node * 2 + 1, (st + ed) / 2 + 1, ed, left, right);
	}

	public static void main(String[] args) throws IOException {
		n = fs.nInt();
		m = fs.nInt();
		int size = 1;
		while (size < n)
			size <<= 1;
		size <<= 1;

		tree = new int[size];
		lazy = new int[size];

		while (m-- != 0) {
			int cond = fs.nInt();
			int t1 = fs.nInt();
			int t2 = fs.nInt();
			if (cond == 0) {
				// toggle
				toggle(1, 0, n - 1, t1 - 1, t2 - 1);

			} else {
				// sum
				System.out.println(sum(1, 0, n - 1, t1 - 1, t2 - 1));
			}
		}

	}

	static class Fs {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		public int nInt() throws IOException {
			if (!st.hasMoreElements())
				st = new StringTokenizer(br.readLine());
			return Integer.parseInt(st.nextToken());
		}
	}
}