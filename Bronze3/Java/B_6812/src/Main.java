import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int timeInOttawa = Integer.parseInt(br.readLine());

        System.out.println(timeInOttawa + " in Ottawa");
        System.out.println(adjustTime(timeInOttawa - 300) + " in Victoria");
        System.out.println(adjustTime(timeInOttawa - 200) + " in Edmonton");
        System.out.println(adjustTime(timeInOttawa - 100) + " in Winnipeg");
        System.out.println(timeInOttawa + " in Toronto");
        System.out.println(adjustTime(timeInOttawa + 100) + " in Halifax");
        System.out.println(adjustTime(timeInOttawa + 130) + " in St. John's");
    }

    private static int adjustTime(int rawTime) {
        int curTime = rawTime;

        if (curTime % 100 > 59) {
            curTime += 100;
            curTime -= 60;
        }

        if (curTime % 100 < -59) {
            curTime -= 100;
            curTime += 60;
        }

        if (rawTime < 0) {
            curTime = 2400 + rawTime;
        }

        if (curTime > 2399) {
            curTime %= 2400;
        }

        return curTime;
    }
}
