import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int area = Integer.parseInt(st.nextToken());

            if (length == 0 && width == 0 && area == 0) {
                break;
            } else if (length == 0 && width != 0 && area != 0) {
                length = area / width;
            } else if (length != 0 && width == 0 && area != 0) {
                width = area / length;
            } else if (length != 0 && width != 0 && area == 0) {
                area = width * length;
            }
            else {
                throw new IOException();
            }
            sb.append(length).append(" ").append(width).append(" ").append(area).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}