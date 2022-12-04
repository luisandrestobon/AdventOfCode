package year2022.day04.part1;

import java.util.Arrays;
import java.util.List;

public class CampCleanup {
    public int assignmentPairsCount(List<String> testList) {
        int count = 0;
        for(String line : testList) {
            int[][] elfPairs = getElfPairs(line);
            if (anyFullyContained(elfPairs[0], elfPairs[1])) {
                count++;
            }
        }
        return count;
    }

    private boolean anyFullyContained(int[] firstPair, int[] lastPair) {
        return (firstPair[0] == lastPair[0] && firstPair[1] == lastPair[1]) ||
                        (Math.min(firstPair[0], lastPair[0]) == firstPair[0] && Math.max(firstPair[1], lastPair[1]) == firstPair[1]) ||
                        (Math.min(firstPair[0], lastPair[0]) == lastPair[0] && Math.max(firstPair[1], lastPair[1]) == lastPair[1]);
    }

    private int[][] getElfPairs(String line) {
        String[] lineSplit = line.split(",");
        int[][] elfPairs = new int[2][2];
        for (int i = 0; i < lineSplit.length; i++) {
            elfPairs[i] = Arrays.stream(lineSplit[i].split("-")).mapToInt(Integer::parseInt).toArray();
        }
        return elfPairs;
    }
}
