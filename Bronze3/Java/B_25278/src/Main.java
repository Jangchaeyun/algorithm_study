import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static MarsCondition mc;

    public static void main(String[] args) throws IOException {
        mc = new MarsCondition(0, 0, -30);
        final int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            final String[] input = br.readLine().split(" ");
            final String commandType = input[0];
            final int commandVal = Integer.parseInt(input[1]);
            executeCommand(commandType, commandVal);
        }
        System.out.println(isMarsLiveable() ? "liveable" : "not liveable");
    }

    private static boolean isMarsLiveable() {
        final int MIN_OCEAN_COVERAGE = 9;
        final int MIN_OXYZEN = 14;
        final int MIN_TEMPERATURE = 8;

        boolean isLiveable = true;
        if (mc.oceanCoverage < MIN_OCEAN_COVERAGE) isLiveable = false;
        if (mc.oxygenLevel < MIN_OXYZEN) isLiveable = false;
        if (mc.temperatureLevel < MIN_TEMPERATURE) isLiveable = false;
        return isLiveable;
    }

    private static void executeCommand(String commandType, int commandVal) {
        switch (commandType) {
            case "temperature": {
                mc.temperatureLevel += commandVal;
                break;
            }
            case "oxygen": {
                mc.oxygenLevel += commandVal;
                break;
            }
            case "ocean": {
                mc.oceanCoverage += commandVal;
                break;
            }
        }
    }

    private static class MarsCondition {
        int oceanCoverage;
        int oxygenLevel;
        int temperatureLevel;

        public MarsCondition(int oceanCoverage, int oxygenLevel, int temperatureLevel) {
            this.oceanCoverage = oceanCoverage;
            this.oxygenLevel = oxygenLevel;
            this.temperatureLevel = temperatureLevel;
        }
    }
}