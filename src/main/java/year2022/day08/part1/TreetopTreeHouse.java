package year2022.day08.part1;

import java.util.*;

public class TreetopTreeHouse {

    private int[][] forest = null;
    private final Set<String> visibleCoordinates = new HashSet<>();

    public int countOfTreesVisible(List<String> testList) {
        createForest(testList);
        addTopToBottom();
        addBottomToTop();
        addLeftToRight();
        addRightToLeft();
        return countEdge() + visibleCoordinates.size();
    }

    private int countEdge() {
        return 4 * (forest.length - 1);
    }

    private void createForest(List<String> testList) {
        int n = testList.size();
        forest = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = testList.get(i);
            int[] row = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            forest[i] = row;
        }
    }

    private void addTopToBottom() {
        for (int j = 1; j < forest[0].length - 1; j++) {
            int edgeHeight = forest[0][j];
            for (int i = 1; i < forest.length - 1; i++) {
                if (forest[i][j] > edgeHeight) {
                    visibleCoordinates.add(obtainTextFromCoordinates(i, j));
                    edgeHeight = forest[i][j];
                }
            }
        }
    }

    private void addBottomToTop() {
        for (int j = 1; j < forest[0].length - 1; j++) {
            int edgeHeight = forest[forest[0].length - 1][j];
            for (int i = forest.length - 2; i > 0; i--) {
                if (forest[i][j] > edgeHeight) {
                    visibleCoordinates.add(obtainTextFromCoordinates(i, j));
                    edgeHeight = forest[i][j];
                }
            }
        }
    }

    private void addLeftToRight() {
        for (int i = 1; i < forest.length - 1; i++) {
            int edgeHeight = forest[i][0];
            for (int j = 1; j < forest[0].length - 1; j++) {
                if (forest[i][j] > edgeHeight) {
                    visibleCoordinates.add(obtainTextFromCoordinates(i, j));
                    edgeHeight = forest[i][j];
                }
            }
        }
    }

    private void addRightToLeft() {
        for (int i = 1; i < forest.length - 1; i++) {
            int edgeHeight = forest[i][forest.length - 1];
            for (int j = forest[0].length - 2; j > 0; j--) {
                if (forest[i][j] > edgeHeight) {
                    visibleCoordinates.add(obtainTextFromCoordinates(i, j));
                    edgeHeight = forest[i][j];
                }
            }
        }
    }

    private String obtainTextFromCoordinates(int... coordinates) {
        return "" + coordinates[0] + "," + coordinates[1];
    }

    private int[] obtainCoordinatesFromText(String coordinates) {
        return Arrays.stream(coordinates.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
