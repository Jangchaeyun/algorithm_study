import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        String s = st.nextToken();
        long f = (long) Math.pow(10, s.length());
        int N = Integer.parseInt(s);
        int K = Integer.parseInt(st.nextToken());
        int now = N % K;

        boolean[] vis = new boolean[K];
        vis[now] = true;

        int cnt = 1;
        while (now != 0) {
            now = (int) ((now * f + N) % K);
            if (vis[now]) {
                System.out.println(-1);
                return;
            }
            vis[now] = true;
            ++cnt;
        }

        System.out.println(cnt);
    }
}