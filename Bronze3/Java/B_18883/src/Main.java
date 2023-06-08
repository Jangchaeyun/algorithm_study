import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int row = Integer.parseInt(st.nextToken());
        final int col = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        AtomicInteger idx = new AtomicInteger();
        IntStream.range(0, row).forEach((y) -> {
            IntStream.range(0, col).forEach((x) -> {
                idx.getAndIncrement();
                sb.append(idx.get()).append(" ");
            });
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        });
        System.out.println(sb);
    }
}