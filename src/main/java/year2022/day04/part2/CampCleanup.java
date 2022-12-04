package year2022.day04.part2;

import java.util.Arrays;
import java.util.List;

public class CampCleanup {
    public int assignmentPairsCountPartial(List<String> testList) {
        int count = 0;
        for(String line : testList) {
            int[][] elfPairs = getElfPairs(line);
            if (!notPartialContained(elfPairs[0], elfPairs[1])) {
                count++;
            }
        }
        return count;
    }

    private boolean notPartialContained(int[] firstPair, int[] lastPair) {
        return (firstPair[0] > lastPair[1]) ||
                (firstPair[1] < lastPair[0]);
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
