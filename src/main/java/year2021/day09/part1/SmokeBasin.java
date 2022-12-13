package year2021.day09.part1;

import java.util.Arrays;
import java.util.List;

public class SmokeBasin {

    private int[][] matrix;
    private final int[][] positions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int sumRiskLevels(List<String> testList) {
        populateMatrix(testList);
        int output = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                output += calculateRisk(i, j);
            }
        }
        return output;
    }

    private void populateMatrix(List<String> testList) {
        matrix = new int[testList.size()][testList.get(0).length()];
        for (int i = 0; i < testList.size(); i++) {
            int[] row = Arrays.stream(testList.get(i).split("")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
    }

    private int calculateRisk(int i, int j) {
        boolean isLowPoint = Arrays.stream(positions).filter(p -> insideBoundaries(i + p[0], j + p[1])).allMatch(p -> matrix[i][j] < matrix[i + p[0]][j + p[1]]);
        return isLowPoint ? matrix[i][j] + 1 : 0;
    }

    private boolean insideBoundaries(int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
