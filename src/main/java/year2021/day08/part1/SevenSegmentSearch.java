package year2021.day08.part1;

import java.util.Arrays;
import java.util.List;

public class SevenSegmentSearch {
    public int times1478DigitsAppear(List<String> testList) {
        return testList.stream()
                .map(line -> line.split(" \\| ")[1])
                .mapToInt(this::countDigitsInLine).sum();
    }

    private int countDigitsInLine(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(String::length)
                .reduce(0, (subtotal, element) -> subtotal + (element == 2 || element == 3 || element == 4 || element == 7 ? 1 : 0));
    }
}
