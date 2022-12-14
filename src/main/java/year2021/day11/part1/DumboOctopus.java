package year2021.day11.part1;

import java.util.HashSet;
import java.util.Set;

public class DumboOctopus {

    private static final int MAX_STEPS = 100;
    private int rows;
    private int columns;
    private int[][] cavern;
    private Set<Integer> alreadyFlashed;
    private int flashes = 0;

    public int getTotalFlashes(int[][] testMatrix) {
        cavern = testMatrix;
        rows = testMatrix.length;
        columns = testMatrix[0].length;
        for (int i = 0; i < MAX_STEPS; i++) {
            startStep();
        }
        return flashes;
    }

    private void startStep() {
        alreadyFlashed = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                increaseEnergy(i, j);
            }
        }
    }

    private void increaseEnergy(int i, int j) {
        int energy = cavern[i][j];
        int number = coordinate2Number(i, j, columns);
        if ((energy == 0 && !alreadyFlashed.contains(number)) || (energy > 0 && energy < 9)) {
            cavern[i][j]++;
        } else if (energy == 9) {
            cavern[i][j] = 0;
            flashes++;
            alreadyFlashed.add(number);
            increaseEnergyAround(i, j);
        }
    }

    private int coordinate2Number(int i, int j, int columns) {
        return j + (i * columns);
    }

    private void increaseEnergyAround(int row, int column) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (isValidCoordinate(row + i, column + j)) {
                    increaseEnergy(row + i, column + j);
                }
            }
        }
    }

    private boolean isValidCoordinate(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < columns;
    }
}
