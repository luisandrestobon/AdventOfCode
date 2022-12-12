package year2021.day06.part1;

import java.util.Arrays;

public class Lanternfish {

    private static final int MAX_DIGIT = 8;
    private static final int MAX_DAYS = 80;

    public long pointsOverlaping(String testStr) {
        int[] counters = new int[MAX_DIGIT + 1];
        Arrays.stream(testStr.split(",")).mapToInt(Integer::parseInt).forEach(i -> counters[i]++);
        for (int i = 0; i < MAX_DAYS; i++) {
            simulateDay(counters);
        }
        return Arrays.stream(counters).sum();
    }

    private void simulateDay(int[] counters) {
        int zeroValue = counters[0];
        System.arraycopy(counters, 1, counters, 0, MAX_DIGIT);
        counters[MAX_DIGIT - 2] = counters[MAX_DIGIT - 2] + zeroValue;
        counters[MAX_DIGIT] = zeroValue;
    }
}
