package year2022.day08.part2;

import java.util.Arrays;
import java.util.List;

public class TreetopTreeHouse {

    private int[][] forest = null;

    public int highestScenicScore(List<String> testList) {
        createForest(testList);
        int highestScore = Integer.MIN_VALUE;
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[0].length; j++) {
                int score = calculateScore(i, j);
                highestScore = Math.max(score, highestScore);
            }
        }
        return highestScore;
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

    private int treesTopToBottom(int x, int y) {
        int initialHeight = forest[x][y];
        int count = 0;
        for (int i = x + 1; i < forest.length; i++) {
            count++;
            if (forest[i][y] >= initialHeight) {
                break;
            }
        }
        return count;
    }

    private int treesBottomToTop(int x, int y) {
        int initialHeight = forest[x][y];
        int count = 0;
        for (int i = x - 1; i >= 0; i--) {
            count++;
            if (forest[i][y] >= initialHeight) {
                break;
            }
        }
        return count;
    }

    private int treesLeftToRight(int x, int y) {
        int initialHeight = forest[x][y];
        int count = 0;
        for (int j = y + 1; j < forest[0].length; j++) {
            count++;
            if (forest[x][j] >= initialHeight) {
                break;
            }
        }
        return count;
    }

    private int treesRightToLeft(int x, int y) {
        int initialHeight = forest[x][y];
        int count = 0;
        for (int j = y - 1; j >= 0; j--) {
            count++;
            if (forest[x][j] >= initialHeight) {
                break;
            }
        }
        return count;
    }

    private int calculateScore(int x, int y) {
        return treesTopToBottom(x, y) * treesBottomToTop(x, y) * treesLeftToRight(x, y) * treesRightToLeft(x, y);
    }
}
