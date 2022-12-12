package year2021.day06.part2;

import java.util.Arrays;

public class Lanternfish {

    private static final int MAX_DIGIT = 8;
    private static final int MAX_DAYS = 256;

    public long pointsOverlapingLongTime(String testStr) {
        long[] counters = new long[MAX_DIGIT + 1];
        Arrays.stream(testStr.split(",")).mapToInt(Integer::parseInt).forEach(i -> counters[i]++);
        for (int i = 0; i < MAX_DAYS; i++) {
            simulateDay(counters);
        }
        return Arrays.stream(counters).sum();
    }

    private void simulateDay(long[] counters) {
        long zeroValue = counters[0];
        System.arraycopy(counters, 1, counters, 0, MAX_DIGIT);
        counters[MAX_DIGIT - 2] = counters[MAX_DIGIT - 2] + zeroValue;
        counters[MAX_DIGIT] = zeroValue;
    }
}
