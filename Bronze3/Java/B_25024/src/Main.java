import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int testCaseSize = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, testCaseSize).forEach((i) -> {
            try {
                sb.append(isValidateAndTime());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

    private static String isValidateAndTime() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int num1 = Integer.parseInt(st.nextToken());
        final int num2 = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if (isValidateTime(num1, num2)) {
            sb.append("Yes ");
        } else {
            sb.append("No ");
        }

        if (isValidateDate(num1, num2)) {
            sb.append("Yes\n");
        } else {
            sb.append("No\n");
        }
        return sb.toString();
    }

    private static boolean isValidateTime(int num1, int num2) {
        return (num1 < 24 && num1 >= 0) && (num2 < 60 && num2 >= 0);
    }

    private static boolean isValidateDate(int num1, int num2) {
        boolean isValidDate = false;
        switch (num1) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (num2 > 0 && num2 <= 31) {
                    isValidDate = true;
                }
                break;
            case 2:
                if (num2 > 0 && num2 <= 29) {
                    isValidDate = true;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (num2 > 0 && num2 <= 30) {
                    isValidDate = true;
                }
                break;
            default:
                break;
        }
        return isValidDate;
    }
}
