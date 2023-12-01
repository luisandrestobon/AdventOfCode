package year2023.day01.part1;

import java.util.List;
import java.util.stream.Collectors;

public class Trebuchet {
    public int sumOfCalibrationValues(List<String> input) {
        return input.stream().map(this::getCalibrationValue).mapToInt(Integer::intValue).sum();
    }

    private int getCalibrationValue(String line) {
        int leftIndex = 0;
        int rightIndex = line.length() - 1;
        Character leftChar = null;
        Character rightChar = null;
        while (leftIndex <= rightIndex && (leftChar == null || rightChar == null)) {
            if (leftChar == null) {
                if (Character.isDigit(line.charAt(leftIndex))) {
                    leftChar = line.charAt(leftIndex);
                } else {
                    leftIndex++;
                }
            }
            if (rightChar == null) {
                if (Character.isDigit(line.charAt(rightIndex))) {
                    rightChar = line.charAt(rightIndex);
                } else {
                    rightIndex--;
                }
            }
        }
        if (rightChar == null) {
            rightChar = '0';
        }
        if (leftChar == null) {
            leftChar = '0';
        }
        return 10 * Character.getNumericValue(leftChar) + Character.getNumericValue(rightChar);
    }
}
