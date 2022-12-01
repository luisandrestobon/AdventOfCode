package year2021.day06.part1;

import java.util.Arrays;

public class Lanternfish {
    public long pointsOverlaping(String input) {
        int[] values = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        long[] counts = new long[9];
        printLongArray(counts);
        initialize(counts, values);
        printLongArray(counts);
        simulate(counts, 256);
        return Arrays.stream(counts).sum();
    }

    private void initialize(long[] counts, int[] values) {
        for (int i = 0; i < values.length; i++) {
            counts[values[i]]++;
        }
    }

    private void simulate(long[] counts, int days) {
        for (int i = 0; i < days; i++) {
            long zero = counts[0];
            for (int j = 1; j < 9; j++) {
                counts[j - 1] = counts[j];
            }
            counts[6] += zero;
            counts[8] = zero;
            //printLongArray(counts);
        }
    }

    public void printLongArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
