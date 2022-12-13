package year2021.day07.part1;

import java.util.Arrays;

public class TheTreacheryOfWhales {
    public int fuelSpend(String testStr) {
        int[] horizontalPositions = Arrays.stream(testStr.split(",")).mapToInt(Integer::parseInt).toArray();
        int maxHorizontalPosition = Arrays.stream(horizontalPositions).max().orElseThrow();
        int fuel;
        int minFuel = Integer.MAX_VALUE;
        for (int i = maxHorizontalPosition; i >= 0; i--) {
            final int x = i;
            fuel = Arrays.stream(horizontalPositions).reduce(0, (subtotal, element) -> subtotal + linear(element, x));
            if (minFuel < fuel) {
                break;
            }
            minFuel = fuel;
        }
        return minFuel;
    }

    public int linear(int value, int n) {
        return Math.abs(value - n);
    }
}
