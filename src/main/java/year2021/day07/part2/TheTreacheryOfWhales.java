package year2021.day07.part2;

import java.util.Arrays;

public class TheTreacheryOfWhales {
    public int fuelSpendProgression(String testStr) {
        int[] horizontalPositions = Arrays.stream(testStr.split(",")).mapToInt(Integer::parseInt).toArray();
        int maxHorizontalPosition = Arrays.stream(horizontalPositions).max().orElseThrow();
        int fuel;
        int minFuel = Integer.MAX_VALUE;
        for (int i = maxHorizontalPosition; i >= 0; i--) {
            final int x = i;
            fuel = Arrays.stream(horizontalPositions).reduce(0, (subtotal, element) -> subtotal + progression(element, x));
            if (minFuel < fuel) {
                break;
            }
            minFuel = fuel;
        }
        return minFuel;
    }

    public int progression(int value, int n) {
        int gap = Math.abs(value - n);
        return gap * (gap + 1) / 2;
    }


}
